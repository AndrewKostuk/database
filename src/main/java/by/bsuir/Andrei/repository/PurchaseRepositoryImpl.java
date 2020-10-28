package by.bsuir.Andrei.repository;

import by.bsuir.Andrei.database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class PurchaseRepositoryImpl implements PurchaseRepository{
    Database database;

    public void save(String name, String color, int cost, String userName) throws SQLException {
        Statement statement = database.getStatement();
        statement.executeUpdate("INSERT INTO purchase(name, color, cost, user_name) VALUES ('" + name + "', '" + color + "', '" + cost + "', '" + userName + "');");
    }
}
