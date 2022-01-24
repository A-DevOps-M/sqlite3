package db.persistence;

import java.sql.*;

import static java.lang.System.*;

public class Database {

    public static final String DB_NAME = "myfirstdbinjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:sqlite3-with-java\\src\\main\\resources\\" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void getConnection(){

        try (
                Connection conn = DriverManager.getConnection(CONNECTION_STRING);
                Statement stm = conn.createStatement()
        ) {
            out.println("Connected to DB!");
            String sqlCreateTable = "CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + "(" +
                    COLUMN_NAME + "TEXT, " + COLUMN_PHONE + "INTEGER, " + COLUMN_EMAIL + " TEXT)";
            stm.execute(sqlCreateTable);
            //stm.execute("update contacts set phone = '4444' where name = 'Sanne'");

            // Insert data
            insertStatement(stm,"AA", 1234, "a@gmail.nl");

            // Get Data
            ResultSet results = stm.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while (results.next()) {
                out.print(results.getString(COLUMN_NAME) + " -- ");
                out.print(results.getInt(COLUMN_PHONE) + " -- ");
                out.println(results.getString(COLUMN_EMAIL));
            }
        } catch (SQLException e) {
            out.println("Ops! Something went wrong " + e.getMessage());
        }
    }

    public static void insertStatement(Statement stm, String name, int phone, String email) throws SQLException {
        String sqlInsertData = "INSERT INTO " + TABLE_CONTACTS + "(" +
                COLUMN_NAME + ", " + COLUMN_PHONE + ", " + COLUMN_EMAIL + ")" +
                "VALUES (" + "'" + name + "'" + ", " + "'" + phone + "'" + ", " + "'" + email + "'" + ")";
        stm.execute(sqlInsertData);
    }

}
