package by.bsuir.Andrei.database;

import java.sql.*;

public class Database {
    private static Database db;
    private static Statement statement;

    static {
        db = new Database();
    }

    private Database() {
        String dbUser = "postgres";
        String password = "admin";
        String connectionUrl = "jdbc:postgresql://localhost:5432/db_example";

        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionUrl, dbUser, password);
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Statement getStatement() {
        return statement;
    }

    public static Database getDb() {
        return db;
    }
}



