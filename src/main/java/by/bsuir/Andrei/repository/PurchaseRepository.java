package by.bsuir.Andrei.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public interface PurchaseRepository {
    void save(String name, String color, int cost, String userName) throws SQLException;
}
