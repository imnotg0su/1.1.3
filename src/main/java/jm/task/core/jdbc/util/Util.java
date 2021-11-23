package jm.task.core.jdbc.util;

import com.mysql.jdbc.Driver;
import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.DRIVER;

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

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory () {
        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();
                properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/1.1.3");
                properties.setProperty(Environment.USER, "tratata");
                properties.setProperty(Environment.PASS, "tratata");
                properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.setProperty(Environment.HBM2DDL_AUTO,"update");
                Configuration cfg = new Configuration();
                cfg.setProperties(properties);
                cfg.addAnnotatedClass(User.class);
                StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure(String.valueOf(cfg)).build();


            } catch (Exception e) {
                System.err.println(e);
            }
        }
        return sessionFactory;
    }
}


