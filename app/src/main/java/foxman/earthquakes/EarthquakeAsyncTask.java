package foxman.earthquakes;


import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EarthquakeAsyncTask extends AsyncTask<String, Void, Earthquake> {

    private RecyclerView recyclerView;

        public EarthquakeAsyncTask(RecyclerView recyclerView){
            this.recyclerView = recyclerView;
        }


        /*run method - gets called in a separate thread*/
        @Override
        protected Earthquake doInBackground(String... params) {
            Earthquake earthquake = null;

            try {
                URL url = new URL("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/significant_month.geojson");

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream in = connection.getInputStream();


                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(in));
                Gson gson = new Gson();


                earthquake = gson.fromJson(reader, Earthquake.class);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return earthquake;
        }

        /*what to do when the AsyncTask completes
        * gets called on the UIThread. all text views can only be modified on the UIThread*/
        @Override
        protected void onPostExecute(Earthquake earthquake) {
            super.onPostExecute(earthquake);
            Features[] features = earthquake.getFeatures();
            EarthquakeRecyclerViewAdapter adapter = new EarthquakeRecyclerViewAdapter(features);

            recyclerView.setAdapter(adapter);

        }


    }

