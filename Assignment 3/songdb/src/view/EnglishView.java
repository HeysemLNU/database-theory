package view;


import model.CountryCode;
import model.dbElements.Album;
import model.dbElements.Artist;
import model.dbElements.Song;

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
            System.out.println("The country is: " + countryName + " with country code " + cc.toString());
            return cc;
        }

    }

    @Override
    public SelectedOption mainMenu() {
        System.out.println("Select an option to continue");
        printOptions();
        prompt();
        String input = sc.nextLine();

        try {
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


    public void welcomeMessage() {
        System.out.println("\n".length());
        System.out.println("Welcome to the music database!");
    }

    public Artist addNewArtist() {
        System.out.println("Adding artist to the database");
        System.out.println("Introduce the name of the artist");
        prompt();
        String artistName = sc.nextLine();
        CountryCode cc = getCC();
        if (artistName == null) {
            error(Errors.INVALIDARTIST);
        } else if (cc == null) {
            error(Errors.INVALIDCC);
        } else {
            System.out.println("The artist is " + artistName + " from: " + cc.toString());
            System.out.println("Proceed? y/N");
            prompt();
            String choice = sc.nextLine();
            if (choice.equals("y")) {
                return new Artist(artistName, cc);
            }
        }
        return null;

    }

    public Album addNewAlbum() {
        System.out.println("Adding album to the database");
        System.out.println("Introduce the name of the album");
        prompt();
        String name = sc.nextLine();
        System.out.println();
        System.out.println("Introduce the year of release");
        prompt();
        int yearOfRelease = -1; //it's -1 so that it triggers the catch by default
        try {
            yearOfRelease = Integer.parseInt(sc.nextLine());
            if (yearOfRelease < 0 || yearOfRelease > 10000) {
                error(Errors.INVALIDYEAR);
            }
        } catch (NumberFormatException nf) {
            error(Errors.INVALIDYEAR);
        }
        System.out.println("Introduce the name of the record label that released this album");
        prompt();
        String recordLabel = sc.nextLine();
        System.out.println("Introduce the ID of the artist who released this album");
        System.out.println("Don't know the artist? Press enter with no input to search artists by name!");
        int fetchIDresult = fetchID();

        if (fetchIDresult == -1) {
            return new Album(name, yearOfRelease, -1, recordLabel); //having the id as -1 will trigger
            //the controller to launch the thing that makes the ID search
        } else if(fetchIDresult == 0) {
            //something went wrong and they got to skip the validation
            error(Errors.INVALIDID);
        }else {

            System.out.println("The album name is " + name + " released in " + yearOfRelease +
                    " by " + recordLabel + " with artist ID " + fetchIDresult);
            System.out.println("Proceed? y/N");
            prompt();
            String choice = sc.nextLine();
            if (choice.equals("y")) {
                return new Album(name, yearOfRelease, fetchIDresult, recordLabel);
            }
        }

        return null;
    }


    public int fetchID() {
        String inputLineID = sc.nextLine();

        try {
           int result = Integer.parseInt(inputLineID);
            if (result < 1) {
                error(Errors.INVALIDID);
            }
            return result;
        } catch (NumberFormatException nf) {
            error(Errors.INVALIDID);
        }
        return 0;
    }

    public String searchArtistByName() {
        System.out.println("Introduce the name of the artist you want to search for");
        prompt();
        String name = sc.nextLine();
        return name;
    }

    public Song addNewSong() {
        System.out.println("Adding song to the database");
        //Song s = new Song()
        return null;
    }

    public void abort() {
        //perhaps make a better error management system with enums
        System.out.println("Aborting");
    }

    private void prompt() {
        System.out.print("\n:> ");
    }


    public void error(Errors err) {
        switch (err) {
            case DBERROR: {
                System.out.println("A database error occurred");
                return;
            }
            case INVALIDARTIST: {
                System.out.println("The artist introduced is not valid");
                return;
            }
            case INVALIDCC: {
                System.out.println("The country code does not exist or is invalid");
                return;
            }
            case INVALIDOPTION: {
                System.out.println("The option selected is not valid");
                return;
            }
            case CLEARERROR: {
                System.out.println("There was an error attempting to clear the screen");
                return;
            }
            case INVALIDYEAR: {
                System.out.println("The year introduced is not valid");
                return;
            }
            case INVALIDID: {
                System.out.println("The ID introduced is not valid");
                return;
            }
        }
    }

    public void success() {
        System.out.println("SUCCESS");
    }

    public void clear() {
        try {
            String os = System.getProperty("os.name");
            //System.out.println(os);
            if (os.contains("Windows")) {
                //for windows clear screen
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                //for unix/linux
                System.out.println("\033[H\033[2J");
            }
        } catch (Exception e) {
            error(Errors.CLEARERROR);
        }
    }

}

