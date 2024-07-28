package src.eMart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
    private static final String DB_URL = "jdbc:sqlite:eMartInventory.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createTables() {
        String createItemsTable = "CREATE TABLE IF NOT EXISTS items (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "quantity INTEGER," +
                "price REAL" +
                ");";

        try (Connection conn = connect();
                Statement stmt = conn.createStatement()) {
            stmt.execute(createItemsTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
