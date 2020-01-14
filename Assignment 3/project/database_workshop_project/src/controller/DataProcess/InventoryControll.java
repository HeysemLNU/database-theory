package controller.DataProcess;

import model.inventory.*;

import java.util.ArrayList;

public class InventoryControll {

    private  ArrayList<Bar> bars = new ArrayList<>(); // There are multiple Bars array list the other one at the AddRemoveInventorytt but its up to your implementation

    AddRemoveInventory functionsToAdd = new AddRemoveInventory();
    public  InventoryControll (){}


    public void addInArraysBars (int amountOfBars, double inputLength, int inputColor, int inputStandard){
        // Your function handles the array bellow. I will make this a void
        functionsToAdd.addBarsInventory(amountOfBars,inputLength,inputColor,inputStandard);
    }
    public void addInArrayWheels (int amountOfWheels, int inputColor, int inputStandard){
        functionsToAdd.addWheelsInventory(amountOfWheels,inputColor,inputStandard);
    }
    public void addInArrayDHandles (int amountOfDHandles, int inputType, int inputColor, int inputStandard){
      functionsToAdd.addDHandlesInventory(amountOfDHandles,inputType,inputColor,inputStandard);
    }
    public void addInArrayWHandles (int amountOfWHandles, int inputType, int inputColor, int inputStandard){
        functionsToAdd.addWHandlesInventory(amountOfWHandles,inputType,inputColor,inputStandard);
    }
    private   void removeFromInvetoryBar(int idToRemove){
        // The user will input the id of the bar that he wants to remove from the table
    }
    public  void removeFromInventoryWheels(int amountOfWheels, String inputColor, String inputStandard, int inputType){

    }
    public  void removeFromInventoryWHandles(int amountOfWHandles, String inputType, String inputColor, String inputStandard ){

    }
    public void removeFromInventoryDHandles (String inputType, String inputColor, String inputStandard){
        // I dont think we need to specifie the amount since it would probably be one at a time
    }



    public ArrayList <Bar> editBarMain (double inputLengthUsed, int inputColor, int inputStandard){
        ArrayList <Bar> toBeEdited = new ArrayList();

        for (int i=0; i<bars.size(); i++){
           if ((bars.get(i).getColor()==functionsToAdd.assighnColorSwitch(inputColor))&&(bars.get(i).getStandard()==functionsToAdd.assighnStandardSwitch(inputStandard))){
               if (bars.get(i).getLength()>=inputLengthUsed){
                   bars.get(i).setLength(bars.get(i).getLength()-inputLengthUsed);
                   if (bars.get(i).getLength()==0.0){
                       removeFromInvetoryBar(bars.get(i).getId());
                       // function to remove that bar from database
                   }else {
                       toBeEdited.add( bars.get(i));
                   }
                   break;
               }
           }
        }
        return toBeEdited;
    }

    }

