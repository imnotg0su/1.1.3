package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private final String url = "jdbc:mysql://localhost:3306/1.1.3";
    private final String userName = "tratata";
    private final String password = "tratata";
    private Connection connection;

    public Util () {
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Соединение установлено.");
        } catch (SQLException e) {
            System.err.println("Ошибка соединения.");
        }
    }

    public Connection getConnection () {
        return connection;
    }
}
