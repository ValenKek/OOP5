package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

    private static ConnectionFactory instance = new ConnectionFactory();
    public static String URL = "jdbc:sqlite:myDB.sqlite";
    public static String DRIVER_CLASS = "org.sqlite.JDBC";

    private ConnectionFactory(){

    }
    public Connection createConnection()
    {
        Connection connection;
        try {
           connection = DriverManager.getConnection(URL);
        }
        catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
        return connection;
    }
    public static Connection  getConnection(){
        return instance.createConnection();
    }
;}