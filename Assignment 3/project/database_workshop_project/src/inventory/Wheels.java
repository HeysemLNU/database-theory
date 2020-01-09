package inventory;

public class Wheels {
    private int id;
    private  String standard;
    private  String color;
    private int type;

    public  Wheels (int inputID, String inputColor, String inputStandard, int inputType ){
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
    public void  setType (int inputType){
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

    public int getType() {
        return type;
    }
}
