package model;

import controller.Color;
import controller.Series;
import controller.BarType;

public class DoorHandle {
    private  int id;
    private Color color;
    private BarType barType; // This could also mean the material it is made out of
    private Series series;

    public DoorHandle(BarType inputBarType, Color inputColor, Series inputSeries, int inputID){
        setColor(inputColor);
        setId(inputID);
        setSeries(inputSeries);
        setBarType(inputBarType);
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
    public void setBarType(BarType inputBarType){
        barType = inputBarType;
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

    public BarType getBarType() {
        return barType;
    }
}
