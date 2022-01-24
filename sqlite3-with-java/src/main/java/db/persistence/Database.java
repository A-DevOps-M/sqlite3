package db.persistence;

import java.sql.*;

import static java.lang.System.*;

public class Database {

    public static void getConnection(){
        try (
                Connection conn = DriverManager.getConnection("jdbc:sqlite:sqlite3-with-java\\src\\main\\resources\\myfirstdbinjava.db");
                Statement stm = conn.createStatement()
        ) {
            out.println("Connected to DB!");
            String sqlCreateTable = "CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)";
            stm.execute(sqlCreateTable);
            String sqlInsertData = "INSERT INTO contacts (name, phone, email) VALUES ('Jan', 1111, 'J@gmail.nl')," +
                    "('Peter', 1111, 'p@gmail.nl')," +
                    "('Sara', 1111, 's@gmail.nl')," +
                    "('Sanne', 1111, 'sn@gmail.nl')";
            //stm.execute(sqlInsertData);
            //stm.execute("update contacts set phone = '4444' where name = 'Sanne'");

            // Get Data
            ResultSet results = stm.executeQuery("SELECT * FROM contacts");
            while (results.next()) {
                out.print(results.getString("name") + " -- ");
                out.print(results.getInt("phone") + " -- ");
                out.println(results.getString("email"));
            }
        } catch (SQLException e) {
            out.println("Ops! Something went wrong " + e.getMessage());
        }
    }

}
