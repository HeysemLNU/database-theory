import controller.*;
import controller.DataProcess.InventoryControll;
import model.inventory.Bar;
import model.inventory.DoorHandle;
import model.inventory.WindowHandle;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // create own branch to start working separately
    public static void main(String[] args) {
        InventoryControll newIC = new InventoryControll();
        Scanner sc1 = new Scanner(System.in);
        int amount;
        int length;
        int color;
        int stand;
        System.out.println("Please enter the Amount");
        amount = sc1.nextInt();
        System.out.println("Please enter the Length");
        length= sc1.nextInt();
        System.out.println("Please enter the Color");
        color = sc1.nextInt();
        System.out.println("Please enter the Standard");
        stand = sc1.nextInt();

        ArrayList<DoorHandle> example = newIC.addInArrayDHandles(amount,length,color,stand);
        for (int i=0; i<example.size();i++){
            System.out.println(example.get(i).getId()+"  "+example.get(i).getType()+"  "+example.get(i).getColor()+"  "+example.get(i).getStandard());
        }


    }
}
