package controller;

import java.sql.Connection;

public class Controller {
    DatabaseOperations database = new DatabaseOperations();
    public Controller() {
        try {
            database.connect();
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }

    }

}
