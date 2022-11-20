/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

/**
 *
 * @author DELL
 */

import java.sql.*;
public class DBcontext {
    private final String serverName = "localhost";
    private final String dbName = "WebBanHang";
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "sa";
    private final String password = "123";
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlserver://"+ serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
        if(instance == null || instance.trim().isEmpty()){
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" +dbName;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, userID, password);
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    
    public static void main(String[] args) {
        try{
            System.out.println(new DBcontext().getConnection());
        }
        catch(Exception e){
            
        }
    }
}
