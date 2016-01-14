package foxman.earthquakes;

import java.io.Serializable;


public class Properties implements Serializable{

    private double mag;
    private String place;

    public double getMag(){
        return this.mag;
    }

    public String getPlace(){
        return this.place;
    }
}
