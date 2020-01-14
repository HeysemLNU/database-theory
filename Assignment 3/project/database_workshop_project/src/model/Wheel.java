package model;


import controller.Series;

public class Wheel {
    // only one per series
    private int id;
    private Series series;

    public Wheel(int inputID, Series inputSeries){
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


// idea to comply with the paper smh // get 2 tables, one for the bars and the other for the "items" (wheels bars hinges), then we can do the join and so on

}
