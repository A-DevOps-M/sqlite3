package db;

import db.persistence.Database;

public class MainApp {

    public static void main(String[] args) {

        Database.getConnection();
    }
}
