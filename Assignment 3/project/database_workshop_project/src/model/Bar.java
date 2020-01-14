package model;

import controller.Color;
import controller.Series;
import controller.BarType;

public class Bar {

    private int id;
    private double length;
    private Color color;
    private Series series;
    private BarType barType;

    public Bar(int inputID, double inputLength, Color inputColor, Series inputSeries, BarType inputBarType){
        setId(inputID);
        setColor(inputColor);
        setSeries(inputSeries);
        setLength(inputLength);
    }
    public void setId(int inputID){
        id = inputID;
    }
    public void setLength(double inputLength){
        length = inputLength;
    }
    public void setColor (Color inputColor){
        /*
        switch (inputColor){
            case 1: color = Color.BLACK;
            break;
            case 2: color = Color.WHITE;
            break;
            case 3: color = Color.BRONZE;
            break;
            case 4: color= Color.WOOD;
            break;
        }*/
        color = inputColor;
    }
    public void setSeries(Series inputSeries){
        /*
        switch (inputStandard){
            case 1: standard = Standard.STANDARD_v94;
                break;
            case 2: standard =Standard.STANDARD_2300 ;
                break;
            case 3: standard = Standard.STANDARD_2500;
                break;

        }*/
        series = inputSeries;
    }
    public int getId (){
        return id;
    }

    public double getLength() {
        return length;
    }

    public Color getColor() {
        return color;
    }

    public Series getSeries() {
        return series;
    }
}
