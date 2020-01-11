package controller;
import java.sql.*;

public class DatabaseOperations {
    // will start working on own branch to test communicaitons with sql database
    public DatabaseOperations() {
    }

    Connection conn;
    public void connect() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reddit2restricted", "albert", "password1");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from comments");

        while (rs.next()) {
            System.out.println(rs.getString("id"));
        }

    }

    public Bar fetchBar(int pos) {
        //do fetch bar from db

    }
}
