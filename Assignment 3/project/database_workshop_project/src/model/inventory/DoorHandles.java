package model.inventory;

public class DoorHandles {
    private  int id;
    private  String color;
    private  String type; // This could also mean the material it is made out of
    private  String standard;

    public DoorHandles(String inputType, String inputColor, String inputStandard, int inputID){
        setColor(inputColor);
        setId(inputID);
        setStandard(inputStandard);
        setType(inputType);
    }

    public void setId(int inputID){
        id = inputID;
    }
    public void setColor (String inputColor){
        color = inputColor;
    }
    public void  setStandard (String inputStandard){
        standard = inputStandard;
    }
    public void  setType (String inputType){
        type = inputType;
    }
    public int getId() {
        return id;
    }

    public String getStandard() {
        return standard;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }
}
