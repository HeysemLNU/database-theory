package model;

import controller.Color;
import controller.Series;

public class Hinge {
    //there's only one per series, some series (like 2300) might not have hinges
    // (then it won't be in the DB because they don't exist)

    private int id;
    private Series series;

    public Hinge (int inputID, Series inputSeries){
        setId(inputID);
        setSeries(inputSeries);
    }
    public void setId(int inputID){
        id = inputID;
    }

    public void setSeries(Series inputSeries){
        series = inputSeries;
    }

    public int getId() {
        return id;
    }

    public Series getSeries() {
        return series;
    }



}
