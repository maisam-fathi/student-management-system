package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The DatabaseConnection class implements a Singleton pattern
 * to provide a single instance of a database connection.
 */
public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/schulmanagmentsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "3556";

    private static Connection connection;

    /**
     * Private constructor to prevent instantiation of this class.
     */
    private DatabaseConnection() {}

    /**
     * Returns a single instance of the database connection.
     * If no connection exists, it initializes a new one.
     *
     * @return A Connection object to the database.
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully!");
            } catch (SQLException e) {
                System.err.println("Database connection failed: " + e.getMessage());
            }
        }
        return connection;
    }
}
