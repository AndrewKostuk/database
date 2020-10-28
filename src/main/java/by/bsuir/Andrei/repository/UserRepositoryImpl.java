package by.bsuir.Andrei.repository;

import by.bsuir.Andrei.database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class UserRepositoryImpl implements UserRepository{
    Database database;

    public ResultSet getAllUsers() throws SQLException {
        Statement statement = database.getStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM web_user");
        return resultSet;
    }
    public boolean isUserExist(String name, String password) throws SQLException {
       ResultSet resultSet = getAllUsers();
        while (resultSet.next()) {
            if (resultSet.getString("name").equals(name) && resultSet.getString("password").equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean isNameTaken(String name) throws SQLException {
        ResultSet resultSet = getAllUsers();
        while (resultSet.next()) {
            if (resultSet.getString("name").equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void save(String name, String password, LocalDate birthDate) throws SQLException {
        Statement statement = database.getStatement();
        statement.executeUpdate("INSERT INTO web_user(name, password, birth_date) VALUES ('" + name + "', '" + password + "', '" + birthDate + "');");
    }
}
