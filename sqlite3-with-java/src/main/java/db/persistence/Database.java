package db.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    public static void getConnection(){
        try (
                Connection conn = DriverManager.getConnection("jdbc:sqlite:sqlite3-with-java\\src\\main\\resources\\myfirstdbinjava.db");
                Statement stm = conn.createStatement();
                ) {
            System.out.println("Connected to DB!");
            stm.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
        } catch (SQLException e) {
            System.out.println("Ops! Something went wrong " + e.getMessage());
        }
    }

}
