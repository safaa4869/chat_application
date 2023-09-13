package com.pfa.connection;



import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }
    private DatabaseConnection(){
        
    }

    public void connectionToDatabase() throws SQLException, ClassNotFoundException{
        String server = "localhost";
        String port = "3306";
        String database ="chat_application";
        String userName = "root";
        String password = "Ok123456";
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+database, userName, password);
        if(connection != null){
            System.out.println("Connected successfully");
        }
        

        
        
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
