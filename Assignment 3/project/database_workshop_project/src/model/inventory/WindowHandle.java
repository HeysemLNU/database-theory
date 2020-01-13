package model.inventory;

import Enums.Color;
import Enums.Standard;
import Enums.Type;

public class WindowHandle {
    private  int id;
    private Color color;
    private  Type type; // This could also mean the material it is made out of
    private Standard standard;

    public WindowHandle(Type inputType, Color inputColor, Standard inputStandard, int inputID ){
        setColor(inputColor);
        setId(inputID);
        setStandard(inputStandard);
        setType(inputType);

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
    public void  setType (Type inputType){
        type = inputType;
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

    public Type getType() {
        return type;
    }

}
