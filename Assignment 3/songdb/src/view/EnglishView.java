package view;

import model.CountryCode;

import java.util.Scanner;

public class EnglishView implements ViewTemplate {


    //Add artist
    //add song
    //add album
    //edit artist
    //edit song
    //edit album
    //remove artist
    //remove song
    //remove album
    //show table artist
    //show table song
    //show table album
    //search by song name
    //search by artist name
    //search by album by year
    //search song by year
    //order songs by length min-max and max-min
    //order songs by year min-max and max-min
    //show song table join artist table
    //show artist table join with album table
    //search song by name with join artist table and album table
    public EnglishView() {

    }

    @Override
    public CountryCode getCC() {
        EnglishCC countryCodeFunction = new EnglishCC();
        Scanner sc =  new Scanner(System.in);

        System.out.println("Introduce the country name or the country code if you know it");
        System.out.println("Type UNKNOWN if you don't know the country of origin.");
        String countryName = sc.nextLine();


        //if this returns null then the country code was not found
        CountryCode cc = countryCodeFunction.getEnglishCC(countryName);
        if(cc == null) {
            System.out.println("The CC does not exist");
            return null;
        } else {
            System.out.println("The country code: " + cc.toString());
        }

        return null;
    }

    @Override
    public void mainMenu() {


    }
}
