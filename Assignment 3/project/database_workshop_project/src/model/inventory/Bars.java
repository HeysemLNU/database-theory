package model.inventory;

public class Bars {
    private int id;
    private double length;
    private String color;
    private  String standard;

    public Bars (int inputID, double inputLength,String inputColor, String inputStandard ){
        setId(inputID);
        setColor(inputColor);
        setStandard(inputStandard);
        setLength(inputLength);
    }
    public void setId(int inputID){
        id = inputID;
    }
    public void setLength(double inputLength){
        length = inputLength;
    }
    public void setColor (String inputColor){
     color = inputColor;
    }
    public void  setStandard (String inputStandard){
        standard = inputStandard;
    }
    public int getId (){
        return id;
    }

    public double getLength() {
        return length;
    }

    public String getColor() {
        return color;
    }

    public String getStandard() {
        return standard;
    }
}
