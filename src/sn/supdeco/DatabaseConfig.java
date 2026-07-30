package sn.supdeco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/supdeco_db";
    private static final String USER = "root";
    private static final String PASSWORD = "rootroot";

    // Pattern Singleton pour la connexion
    private static Connection connexion = null;

    public static Connection getConnexion() throws SQLException {
        if (connexion == null || connexion.isClosed()) {
            connexion = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connexion;
    }

}
