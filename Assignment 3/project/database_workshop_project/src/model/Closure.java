package model;

import controller.Color;
import controller.Series;
import controller.BarType;

public class Closure {
    // closures are the system that
    private  int id;
    private Series series;

    public Closure(BarType inputBarType, Color inputColor, Series inputSeries, int inputID ){
        setColor(inputColor);
        setId(inputID);
        setSeries(inputSeries);
        setType(inputBarType);

    }
    public void setId(int inputID){
        id = inputID;
    }
    public void setColor (Color inputColor){
        color = inputColor;
    }
    public void setSeries(Series inputSeries){
         series = inputSeries;
    }
    public void  setType (BarType inputBarType){
        type = inputBarType;
    }
    public int getId() {
        return id;
    }

    public Series getSeries() {
        return series;
    }

    public Color getColor() {
        return color;
    }

    public BarType getType() {
        return type;
    }

}
