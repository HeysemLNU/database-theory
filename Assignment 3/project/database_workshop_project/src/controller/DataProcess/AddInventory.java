package controller.DataProcess;

import Enums.Color;
import Enums.Standard;
import Enums.Type;
import model.inventory.Bar;
import model.inventory.DoorHandle;
import model.inventory.Wheel;
import model.inventory.WindowHandle;

import java.util.ArrayList;
import java.util.Random;

public class AddInventory {
    private  boolean idSetable = true;
    private String barID="bar";
    private  String wheelsID = "wheels";
    private  String whandlesID= "window";
    private  String dhandlesID = "door";
    private  ArrayList<Bar> bars = new ArrayList<>();
    private  ArrayList<Wheel> wheels = new ArrayList<>();
    private  ArrayList<WindowHandle> whandles = new ArrayList<>();
    private  ArrayList<DoorHandle> dhandles = new ArrayList<>();

    public ArrayList<Bar> addBarsInventory (int amountOfBars, double inputLength, int inputColor, int inputStandard){

        ArrayList<Bar> returnBar = new ArrayList();

        //assighnColorSwitch(inputColor,toAddColor);
        //assighnStandardSwitch(inputStandard,toAddStandard);

        for (int i = 0; i<amountOfBars; i++){
            Bar newBar = new Bar(idGenerator(barID),inputLength,  assighnColorSwitch(inputColor),assighnStandardSwitch(inputStandard));
            returnBar.add(newBar);
            // or what ever function u give
        }
        return returnBar;
    }
    public ArrayList<Wheel> addWheelsInventory (int amountOfWheels, int inputColor, int inputStandard){

        ArrayList<Wheel> returnWheel = new ArrayList();

        //assighnColorSwitch(inputColor,toAddColor);
        //assighnStandardSwitch(inputStandard,toAddStandard);

        for (int i = 0; i<amountOfWheels; i++){
            Wheel newWheel = new Wheel(idGenerator(wheelsID),assighnColorSwitch(inputColor),assighnStandardSwitch(inputStandard));
            returnWheel.add(newWheel);
        }
        return returnWheel;
    }
    public ArrayList<WindowHandle> addWHandlesInventory (int amountOfWHandles, int inputType, int inputColor, int inputStandard){
        ArrayList<WindowHandle> returnWHandles = new ArrayList();

       // assighnColorSwitch(inputColor,toAddColor);
        //assighnStandardSwitch(inputStandard,toAddStandard);
        //assighnTypeSwitch(inputType, toAddType);


        for (int i = 0; i<amountOfWHandles; i++){
            WindowHandle newWHandle = new WindowHandle(assighnTypeSwitch(inputType),assighnColorSwitch(inputColor),assighnStandardSwitch(inputStandard) ,idGenerator(whandlesID));
            returnWHandles.add(newWHandle);
        }
        return returnWHandles;
    }
    public ArrayList<DoorHandle> addDHandlesInventory (int amountOfDHandles, int inputType, int inputColor, int inputStandard){

        ArrayList<DoorHandle> returnDHandles = new ArrayList();

        //assighnColorSwitch(inputColor,toAddColor);
        //assighnStandardSwitch(inputStandard,toAddStandard);
        //assighnTypeSwitch(inputType, toAddType);


        for (int i = 0; i<amountOfDHandles; i++){
            DoorHandle newDHandle = new DoorHandle(assighnTypeSwitch(inputType),assighnColorSwitch(inputColor),assighnStandardSwitch(inputStandard) ,idGenerator(dhandlesID));
            returnDHandles.add(newDHandle);
        }
        return returnDHandles;
    }
private Color assighnColorSwitch(int chosen){
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
    private   Standard assighnStandardSwitch(int chosen){
        Standard stan;
        switch (chosen){
            case 1: stan = Standard.STANDARD_v94;
                break;
            case 2: stan =Standard.STANDARD_2300 ;
                break;
            case 3: stan = Standard.STANDARD_2500;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + chosen);
        }
        return  stan;
    }
    private Type  assighnTypeSwitch(int chosen){
        Type outType;
        switch (chosen){
            case 1: outType = Type.HANDGRIP;
                break;
            case 2: outType = Type.HANDLE ;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + chosen);
        }
        return outType;
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
