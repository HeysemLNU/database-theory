package controller.DataProcess;

import Enums.Color;
import Enums.Standard;
import Enums.Type;
import model.inventory.*;

import java.util.ArrayList;
import java.util.Random;

public class InventoryControll {

    private  ArrayList<Bar> bars = new ArrayList<>();
    private  ArrayList<Wheel> wheels = new ArrayList<>();
    private  ArrayList<WindowHandle> whandles = new ArrayList<>();
    private  ArrayList<DoorHandle> dhandles = new ArrayList<>();
    AddInventory functionsToAdd = new AddInventory();
    public  InventoryControll (){}


    public ArrayList<Bar> addInArraysBars (int amountOfBars, double inputLength, int inputColor, int inputStandard){
        // Your function handles the array bellow.
       return functionsToAdd.addBarsInventory(amountOfBars,inputLength,inputColor,inputStandard);
    }
    public ArrayList<Wheel>  addInArrayWheels (int amountOfWheels, int inputColor, int inputStandard){
        return functionsToAdd.addWheelsInventory(amountOfWheels,inputColor,inputStandard);
    }
    public ArrayList<DoorHandle> addInArrayDHandles (int amountOfDHandles, int inputType, int inputColor, int inputStandard){
        return functionsToAdd.addDHandlesInventory(amountOfDHandles,inputType,inputColor,inputStandard);
    }
    public ArrayList<WindowHandle> addInArrayWHandles (int amountOfWHandles, int inputType, int inputColor, int inputStandard){
        return functionsToAdd.addWHandlesInventory(amountOfWHandles,inputType,inputColor,inputStandard);
    }
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


    public  void editBarMain (double inputLengthUsed, Color inputColor, Standard inputStandard){
        for (int i=0; i<bars.size(); i++){
           if ((bars.get(i).getColor()==inputColor)&&(bars.get(i).getStandard()==inputStandard)){
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

        private void getArrays (Bar bars, Wheel wheels, WindowHandle windowHandles, DoorHandle doorHandles){
            // Albert i need a function from you to fill in these arrays
        }
    }

