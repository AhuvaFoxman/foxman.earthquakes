package foxman.earthquakes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.*;

public class EarthquakeViewHolder extends RecyclerView.ViewHolder {

    private TextView magnitude;
    private TextView place;

    public EarthquakeViewHolder(View itemView) {
            super(itemView);
            place = (TextView) itemView.findViewById(R.id.place);
            magnitude = (TextView) itemView.findViewById(R.id.mag);


        }

    public void bind(Properties property){

        place.setText("Earthquake Place: " + property.getPlace());
        magnitude.setText("Earthquake Magnitude: " + String.valueOf(property.getMag()));



        }
        }