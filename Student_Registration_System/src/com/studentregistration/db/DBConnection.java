
package com.studentregistration.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection connection; // Singleton Design Pattern

    public static Connection createConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "jay";
            String pass = "Vakhariya@2002";
            String url = "jdbc:mysql://localhost:3306/new_db?autoReconnect=true&useSSL=false";

            connection = DriverManager.getConnection(url,user,pass);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return connection;
    }

}