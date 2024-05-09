package DB;



import java.sql.Connection;
import java.sql.DriverManager;

public class Myconnection {
    private static final String username = "admin";
    private static final long password = 35987521456L;
    private static final String dataConn = "jdbc:sqlserver://localhost:1433;databaseName=AirLine;encrypt=true;trustServerCertificate=true;";
    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dataConn, username, String.valueOf(password));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}
