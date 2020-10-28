package by.bsuir.Andrei.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public interface UserRepository {
    boolean isUserExist(String name, String password) throws SQLException;

    ResultSet getAllUsers() throws SQLException;

    boolean isNameTaken(String name) throws SQLException;

    void save(String name, String password, LocalDate birthDate) throws SQLException;
}
