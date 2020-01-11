package model.DataProcess;

import model.inventory.Bars;
import model.inventory.DoorHandles;
import model.inventory.Wheels;
import model.inventory.WindowHandles;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Random;

public class InventoryControll {
    private  boolean idSetable = true;
    private String barID="bar";
    private  String wheelsID = "wheels";
    private  String whandlesID= "window";
    private  String dhandlesID = "door";
    private  ArrayList<Bars> bars = new ArrayList<>();
    private  ArrayList<Wheels> wheels = new ArrayList<>();
    private  ArrayList<WindowHandles> whandles = new ArrayList<>();
    private  ArrayList<DoorHandles> dhandles = new ArrayList<>();
    public  InventoryControll (){}


    public ArrayList<Bars> createBarsInventory (int amountOfBars, double inputLength,String inputColor, String inputStandard){
        ArrayList<Bars> barsToAdd = new ArrayList<>();



        return barsToAdd;
    }

    public int idGenerator(String material){
        Random randomID = new Random(); // This might be outside the function i will see.
        if (material == barID){
            int generatedBarId = randomID.nextInt(99);
            for (int i=0; i<bars.size();i++){
                if (bars.get(i).getId()==generatedBarId){
                    idSetable = false;
                }
            }
            if (idSetable == true){
                return generatedBarId;
            }else {
                idSetable =true;
                idGenerator(material);
            }
        }
        else if (material == wheelsID){
            int generatedWheelId = randomID.nextInt(99) + 100;
            for (int i=0; i<wheels.size();i++){
                if (wheels.get(i).getId()==generatedWheelId){
                    idSetable = false;
                }
            }
            if (idSetable == true){
                return generatedWheelId;
            }else {
                idSetable =true;
                idGenerator(material);
            }
        }
        else if (material == whandlesID){
            int generatedWhandleId = randomID.nextInt(99) + 200;
            for (int i=0; i<whandles.size();i++){
                if (whandles.get(i).getId()==generatedWhandleId){
                    idSetable = false;
                }
            }
            if (idSetable == true){
                return generatedWhandleId;
            }else {
                idSetable =true;
                idGenerator(material);
            }
        }
        else if (material == dhandlesID) {
            int generatedDhandleId = randomID.nextInt(99) + 300;
            for (int i=0; i<dhandles.size();i++){
                if (dhandles.get(i).getId()==generatedDhandleId){
                    idSetable = false;
                }
            }
            if (idSetable == true){
                return generatedDhandleId;
            }else {
                idSetable =true;
                idGenerator(material);
            }

        }

            throw new ArithmeticException("Could not Generate a random number !!");
    }
}
