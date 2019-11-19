package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection getConnection(){
        Connection cons = null;
        String url = "jdbc:jtds:sqlserver://localhost:1433/NHANSU";
        String user = "sa";
        String password = "abc123!";
        try {
            cons = DriverManager.getConnection(url, user, password);
        return cons;
    }
    catch (Exception e){
        e.printStackTrace();
    }
    return null;
}
    public static void main(String[] args) throws SQLException {
        Connection c = getConnection();
        System.out.println(c.toString());
        c.close();
    }
}
