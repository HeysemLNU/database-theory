package view;

import model.*;

public interface ViewTemplate {

    CountryCode getCC();

    SelectedOption mainMenu();

    enum SelectedOption {
        DEFAULT, ADDARTIST, REMOVEARTIST, EDITARTIST, ADDSONG,
        REMOVESONG, EDITSONG, ADDALBUM, REMOVEALBUM, EDITALBUM,
        EXIT;
    }



}
