package controller;

import model.inventory.Bar;

import java.sql.*;

public class DatabaseOperations {
    Connection conn;

    // will start working on own branch to test communicaitons with sql database
    public DatabaseOperations() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/materials", "albert", "password1");
        initDB();
    }


    public void initDB() throws SQLException {
        Statement st = conn.createStatement();
        String query = "create table if not exists bars"
                + "(" +
                "id INT, inputlength DECIMAL, color VARCHAR(30), series VARCHAR(30)" +
                ")";
        String query2 = "create table if not exists doorhandles" +
                "(" +
                "id INT, color VARCHAR(30), style VARCHAR(30), series VARCHAR(30)" +
                ")";
        String query3 = "create table if not exists wheels" +
                "(" +
                "id INT, color VARCHAR(30), series VARCHAR(30)" +
                ")";
        String query4 = "create table if not exists windowhandles" +
                "(" +
                "id INT, color VARCHAR(30), series VARCHAR(30), material VARCHAR(30)" +
                ")";

        int result = st.executeUpdate(query);
        result = st.executeUpdate(query2);
        result = st.executeUpdate(query3);
        result = st.executeUpdate(query4);

        //cannot be named "type" in the db because apparently that's a sql keyword
        //some information might be removed
        //enums need to be done
        //There was something important I had to mention but I forgot, I think it had to
        //do with discussing the enums or something... idk
    }

    public Bar[] fetchAllBars() throws SQLException {
        //do fetch bar from db

        Statement st = conn.createStatement();
        ResultSet barsTable = st.executeQuery("select * from bars");

        while (barsTable.next()) {
            System.out.println(barsTable.getString("id"));

        }

        return new Bar[0];
    }
}

