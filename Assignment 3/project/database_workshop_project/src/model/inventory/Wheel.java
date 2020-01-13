package model.inventory;

import Enums.Color;
import Enums.Standard;

public class Wheel {
    private int id;
    private Standard standard;
    private Color color;

    public Wheel(int inputID, Color inputColor, Standard inputStandard){
        setId(inputID);
        setColor(inputColor);
        setStandard(inputStandard);
    }
    public void setId(int inputID){
        id = inputID;
    }
    public void setColor (Color inputColor){
      color = inputColor;
    }
    public void  setStandard (Standard inputStandard){
         standard = inputStandard;
    }

    public int getId() {
        return id;
    }

    public Standard getStandard() {
        return standard;
    }

    public Color getColor() {
        return color;
    }

}
