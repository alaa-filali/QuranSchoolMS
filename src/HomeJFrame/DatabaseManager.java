
package HomeJFrame;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseManager {

    private static final String DB_PATH = "database/my_database.db";

    // Initialize the database and create tables if not exists
    public static void initializeDatabase() {
        try {
            File dbFile = new File(DB_PATH);

            // Check if database file exists
            if (!dbFile.exists()) {
                // Ensure directory exists
                File parentDir = dbFile.getParentFile();
                if (!parentDir.exists()) {
                    parentDir.mkdirs();
                }

                // Connect to SQLite and create the database file
                Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbFile.getPath());
                Statement stmt = conn.createStatement();

                // Create a sample table (e.g., students)
                stmt.execute("""
                    CREATE TABLE IF NOT EXISTS students (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        name TEXT NOT NULL,
                        age TEXT NOT NULL,
                        class TEXT NOT NULL,
                        absences INTEGER DEFAULT 0
                    )
                """);

                stmt.close();
                conn.close();
                System.out.println("Database created and initialized.");
            } else {
                System.out.println("Database already exists.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to get a connection to the SQLite database
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

