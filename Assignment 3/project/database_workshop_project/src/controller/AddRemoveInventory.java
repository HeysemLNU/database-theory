package controller;

import model.Bar;
import model.DoorHandle;
import model.Wheel;
import model.Closure;

import java.util.ArrayList;
import java.util.Random;

public class AddRemoveInventory {
    private  boolean idSetable = true;
    private String barID="bar";
    private  String wheelsID = "wheels";
    private  String whandlesID= "window";
    private  String dhandlesID = "door";
    private  ArrayList<Bar> bars = new ArrayList<>();
    private  ArrayList<Wheel> wheels = new ArrayList<>();
    private  ArrayList<Closure> whandles = new ArrayList<>();
    private  ArrayList<DoorHandle> dhandles = new ArrayList<>();

    public ArrayList<Bar> addBarsInventory (int amountOfBars, double inputLength, int inputColor, int inputStandard){

        ArrayList<Bar> returnBar = new ArrayList();

        for (int i = 0; i<amountOfBars; i++){
            Bar newBar = new Bar(idGenerator(barID),inputLength,  assighnColorSwitch(inputColor),assighnStandardSwitch(inputStandard));
            returnBar.add(newBar);
            // or what ever function u give
        }
        return returnBar;
    }
    public ArrayList<Wheel> addWheelsInventory (int amountOfWheels, int inputColor, int inputStandard){

        ArrayList<Wheel> returnWheel = new ArrayList();

        for (int i = 0; i<amountOfWheels; i++){
            Wheel newWheel = new Wheel(idGenerator(wheelsID),assighnColorSwitch(inputColor),assighnStandardSwitch(inputStandard));
            returnWheel.add(newWheel);
        }
        return returnWheel;
    }
    public ArrayList<Closure> addWHandlesInventory (int amountOfWHandles, int inputType, int inputColor, int inputStandard){
        ArrayList<Closure> returnWHandles = new ArrayList();


        for (int i = 0; i<amountOfWHandles; i++){
            Closure newWHandle = new Closure(assighnTypeSwitch(inputType),assighnColorSwitch(inputColor),assighnStandardSwitch(inputStandard) ,idGenerator(whandlesID));
            returnWHandles.add(newWHandle);
        }
        return returnWHandles;
    }
    public ArrayList<DoorHandle> addDHandlesInventory (int amountOfDHandles, int inputType, int inputColor, int inputStandard){

        ArrayList<DoorHandle> returnDHandles = new ArrayList();

        for (int i = 0; i<amountOfDHandles; i++){
            DoorHandle newDHandle = new DoorHandle(assighnTypeSwitch(inputType),assighnColorSwitch(inputColor),assighnStandardSwitch(inputStandard) ,idGenerator(dhandlesID));
            returnDHandles.add(newDHandle);
        }
        return returnDHandles;
    }
public Color assighnColorSwitch(int chosen){
        System.out.println("Entered Here");
        Color output2;
        switch (chosen){
            case 1: output2 = Color.BLACK;
            System.out.println("enter2");
            break;
            case 2: output2 = Color.WHITE;
                System.out.println("enter3"+ "  " + output2);
            break;
            case 3: output2 = Color.BRONZE;
                System.out.println("enter4");
            break;
            case 4: output2= Color.WOOD;
                System.out.println("enter5");
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + chosen);
        }
        return output2;
    }
    public Series assighnStandardSwitch(int chosen){
        Series stan;
        switch (chosen){
            case 1: stan = Series.STANDARD_v94;
                break;
            case 2: stan = Series.STANDARD_2300 ;
                break;
            case 3: stan = Series.STANDARD_2500;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + chosen);
        }
        return  stan;
    }
    public BarType assighnTypeSwitch(int chosen){
        BarType outBarType;
        switch (chosen){
            case 1: outBarType = BarType.HANDGRIP;
                break;
            case 2: outBarType = BarType.HANDLE ;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + chosen);
        }
        return outBarType;
    }
    private int idGenerator (String material){
        Random randomID = new Random(); //This might be outside the function i will see.
        if (material == barID) {
            int generatedBarId = randomID.nextInt(99);
            for (int i = 0; i < bars.size(); i++) {
                if (bars.get(i).getId() == generatedBarId) {
                    idSetable = false;
                }
            }
            if (idSetable == true) {
                return generatedBarId;
            } else {
                idSetable = true;
                idGenerator(material);
            }
        } else if (material == wheelsID) {
            int generatedWheelId = randomID.nextInt(99) + 100;
            for (int i = 0; i < wheels.size(); i++) {
                if (wheels.get(i).getId() == generatedWheelId) {
                    idSetable = false;
                }
            }
            if (idSetable == true) {
                return generatedWheelId;
            } else {
                idSetable = true;
                idGenerator(material);
            }
        } else if (material == whandlesID) {
            int generatedWhandleId = randomID.nextInt(99) + 200;
            for (int i = 0; i < whandles.size(); i++) {
                if (whandles.get(i).getId() == generatedWhandleId) {
                    idSetable = false;
                }
            }
            if (idSetable == true) {
                return generatedWhandleId;
            } else {
                idSetable = true;
                idGenerator(material);
            }
        } else if (material == dhandlesID) {
            int generatedDhandleId = randomID.nextInt(99) + 300;
            for (int i = 0; i < dhandles.size(); i++) {
                if (dhandles.get(i).getId() == generatedDhandleId) {
                    idSetable = false;
                }
            }
            if (idSetable == true) {
                return generatedDhandleId;
            } else {
                idSetable = true;
                idGenerator(material);
            }

        }

        throw new ArithmeticException("Could not Generate a random number !!");
    }
}
