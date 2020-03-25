package view;



import model.CountryCode;
import model.dbElements.Album;
import model.dbElements.Artist;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
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

    Scanner sc;

    public EnglishView() {
        sc = new Scanner(System.in);
    }

    @Override
    public CountryCode getCC() {
        EnglishCC countryCodeFunction = new EnglishCC();

        System.out.println("Introduce the country name or the country code if you know it");
        System.out.println("Type UNKNOWN if you don't know the country of origin.");
        String countryName = sc.nextLine();


        //if this returns null then the country code was not found
        CountryCode cc = countryCodeFunction.getEnglishCC(countryName);
        if (cc == null) {
            System.out.println("The CC does not exist");
            return null;
        } else {
            System.out.println("The country is: " +countryName+ " with country code " + cc.toString());
            return cc;
        }

    }

    @Override
    public SelectedOption mainMenu() {
            System.out.println("Select an option to continue");
            printOptions();
            prompt();
            String input = sc.nextLine();

            try{
                int selection = Integer.parseInt(input);
                switch (selection) {
                    case 1: {
                        return SelectedOption.ADDARTIST;
                    }
                    case 2: {
                        return SelectedOption.REMOVEARTIST;
                    }
                    case 3: {
                        return SelectedOption.EDITARTIST;
                    }
                    case 4: {
                        return SelectedOption.ADDALBUM;
                    }
                    case 5: {
                        return SelectedOption.REMOVEALBUM;
                    }
                    case 6: {
                        return SelectedOption.EDITALBUM;
                    }
                    case 7: {
                        return SelectedOption.ADDSONG;
                    }
                    case 8: {
                        return SelectedOption.REMOVESONG;
                    }
                    case 9: {
                        return SelectedOption.EDITSONG;
                    }
                    case 0: {
                        return SelectedOption.EXIT;
                    }
                    default: {
                        return SelectedOption.DEFAULT;
                    }

                }

            } catch (NumberFormatException n) {
                return SelectedOption.DEFAULT;
            }


        }


        private void printOptions() {
            System.out.println("1: Add Artist");
            System.out.println("2: Remove Artist");
            System.out.println("3: Edit Artist");
            System.out.println("4: Add Album");
            System.out.println("5: Remove Album");
            System.out.println("6: Edit Album");
            System.out.println("7: Add Song");
            System.out.println("8: Remove Song");
            System.out.println("9: Edit Song");
            System.out.println("0: exit");
        }
        public void invalidOption() {
            System.out.println("The option is not valid");
        }

        public void welcomeMessage() {
            System.out.println("Welcome to the music database!");
        }

        public Artist addNewArtist() {
            System.out.println("Adding artist to the database");
            System.out.println("Introduce the name of the artist");
            prompt();
            String artistName = sc.nextLine();
            CountryCode cc = getCC();
            if(artistName == null || cc == null) {
                System.out.println("The country code or the artist name are invalid");
                return null;
            } else {
                System.out.println("The artist is " + artistName + " from: " +cc.toString());
                System.out.println("Proceed? y/N");
                prompt();
                String choice = sc.nextLine();
                if (choice.equals("y")) {
                    return new Artist(artistName, cc);
                }
                return null;
            }
        }

        public Album addNewAlbum() {
            System.out.println("Adding album to the database");
            //add the rest of the album here

            return null;
        }

        public void abort() {
            //perhaps make a better error management system with enums
            System.out.println("Aborting");
        }

        private void prompt() {
            System.out.print("\n:> ");
        }



}

