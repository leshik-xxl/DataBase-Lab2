package app.model.sql;

import constant.Configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection extends Configs {

    private static SqlConnection instance;

    private Connection connection;

    private SqlConnection() {
        String connectionString = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        } catch (Exception ignored) {

        }


    }

    public static SqlConnection getInstance() {
        if (instance == null) {
            instance = new SqlConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
