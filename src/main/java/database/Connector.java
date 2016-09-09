package database;
import java.sql.*;

public class Connector {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:8081/clouderdb";
    private static final String USER = "admin";
    private static final String PASS = "1234";
    private static Connection connection;
    private static boolean started;

    public static void execute(String sql) throws SQLException {
        if (!started) start();
        connection.createStatement().execute(sql);
    }
    public static ResultSet getSet(String sql) throws SQLException {
        if (!started) start();
        return connection.createStatement().executeQuery(sql);
    }

    private static void start(){
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
            started = true;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
