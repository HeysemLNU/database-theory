package controller;

import model.Bar;
import model.DoorHandle;
import model.Wheel;
import model.Closure;


import java.util.ArrayList;
import java.util.Random;

public class InventoryControl {

    private  boolean idSetable = true;
    private String barID="bar";
    private  String wheelsID = "wheels";
    private  String whandlesID= "window";
    private  String dhandlesID = "door";
    private  ArrayList<Bar> bars = new ArrayList<>();
    private  ArrayList<Wheel> wheels = new ArrayList<>();
    private  ArrayList<Closure> whandles = new ArrayList<>();
    private  ArrayList<DoorHandle> dhandles = new ArrayList<>();

    public InventoryControl(){

    }


    public void addBarsInventory (int amountOfBars, double inputLength, Color inputColor, Series inputSeries, BarType inputBarType){
       for (int i = 0; i<amountOfBars; i++){
           Bar newBar = new Bar(idGenerator(barID),inputLength,inputColor, inputSeries, inputBarType);
           bars.add(newBar);
           // or what ever function u give
       }
    }
    public void addWheelsInventory (int amountOfWheels, Color inputColor, Series inputSeries){
        for (int i = 0; i<amountOfWheels; i++){
            Wheel newWheel = new Wheel(idGenerator(wheelsID),inputColor, inputSeries);
            wheels.add(newWheel);
        }
    }
    public void addWHandlesInventory (int amountOfWHandles, BarType inputBarType, Color inputColor, Series inputSeries){
        for (int i = 0; i<amountOfWHandles; i++){
            Closure newWHandle = new Closure(inputBarType,inputColor, inputSeries,idGenerator(whandlesID));
            whandles.add(newWHandle);
        }
    }
    public void addDHandlesInventory (int amountOfDHandles, BarType inputBarType, Color inputColor, Series inputSeries){
        for (int i = 0; i<amountOfDHandles; i++){
            DoorHandle newDHandle = new DoorHandle(inputBarType,inputColor, inputSeries,idGenerator(whandlesID));

            dhandles.add(newDHandle);
        }


    }
    /*
    public ArrayList<Bar> createBarsInventory (int amountOfBars, double inputLength, String inputColor, String inputStandard){
        ArrayList<Bar> barsToAdd = new ArrayList<>();
        return  barsToAdd;

    }*/
    private   void removeFromInvetoryBar(int idToRemove){
        // The user will input the id of the bar that he wants to remove from the table
    }
    public  void removeFromInventoryWheels(int amountOfWheels, String inputColor, String inputStandard, int inputType){
        // This will make the user remove wheels depending on the color,
    }
    public  void removeFromInventoryWHandles(int amountOfWHandles, String inputType, String inputColor, String inputStandard ){

    }
    public void removeFromInventoryDHandles (String inputType, String inputColor, String inputStandard){
        // I dont think we need to specifie the amount since it would probably be one at a time
    }
    public  void editBar(int id, double amountUsed){
        // Albert I was thinking that we would display all the bars with their properties and stuff and then he can
        // just give us the id of it and how much he used. Or we can do it both ways where he just enters the properties and the amount
        // and we just minus from that
        for (int i=0; i<bars.size(); i++){
            if (bars.get(i).getId()==id){
                if (bars.get(i).getLength()>=amountUsed){
                    bars.get(i).setLength(bars.get(i).getLength()-amountUsed);
                    break;
                }
            }
        }
    }


    public  void editBarMain (double inputLengthUsed, Color inputColor, Series inputSeries){
        for (int i=0; i<bars.size(); i++){
           if ((bars.get(i).getColor()==inputColor)&&(bars.get(i).getSeries()== inputSeries)){
               if (bars.get(i).getLength()>=inputLengthUsed){
                   bars.get(i).setLength(bars.get(i).getLength()-inputLengthUsed);
                   if (bars.get(i).getLength()==0.0){
                       removeFromInvetoryBar(bars.get(i).getId());
                       // function to remove that bar from database
                   }

                   // A function to save the changes
                   break;
               }
           }
        }

    }


        private int idGenerator (String material){
            Random randomID = new Random(); // This might be outside the function i will see.
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
        private void getArrays (Bar bars, Wheel wheels, Closure windowHandles, DoorHandle doorHandles){
            // Albert i need a function from you to fill in these arrays
        }
    }

