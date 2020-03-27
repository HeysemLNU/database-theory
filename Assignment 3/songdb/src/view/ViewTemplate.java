package view;

import model.*;

public interface ViewTemplate {

    CountryCode getCC();

    SelectedOption mainMenu();

    enum SelectedOption {
        DEFAULT, ADDARTIST, REMOVEARTIST, ADDSONG,
        REMOVESONG, ADDALBUM, REMOVEALBUM,
        EXIT, SEARCHSONGNAME, SEARCHSONGLYRICS, SEARCHALBUMBYNAME;
    }

    enum Errors {
        DBERROR, INVALIDARTIST,INVALIDCC,INVALIDOPTION,CLEARERROR, INVALIDYEAR, INVALIDID, INVALIDLENGTH;
    }

    enum InputRequests {
        ASKID;
    }
}
