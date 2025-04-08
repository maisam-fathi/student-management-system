package singleton;

import java.sql.Connection;

/**
 * The DatabaseConnectionTest class is used to test the database connection.
 */
public class DatabaseConnectionTest {

    /**
     * Main method to test the database connection.
     * It attempts to establish a connection using the DatabaseConnection class
     * and prints a success or failure message based on the connection status.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();

        if (conn != null) {
            System.out.println("Connection test successful!");
        } else {
            System.out.println("Connection test failed!");
        }
    }
}
