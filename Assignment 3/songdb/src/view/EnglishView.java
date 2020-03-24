package view;

import model.CountryCode;

import java.util.Scanner;

public class EnglishView implements ViewTemplate {

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
}
