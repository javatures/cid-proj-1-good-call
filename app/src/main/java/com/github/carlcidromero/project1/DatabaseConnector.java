package com.github.carlcidromero.project1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseConnector {

    private final Logger log = LogManager.getLogger(this.getClass());
    Properties properties = new Properties();
    Connection connection;
    String url;
    String username;
    String password;
    ThoughtDaoImpl thoughtDaoImpl;

    public void connectToDatabase() {

        try {
            log.info("Connecting to database");
            
            FileInputStream fileInputStream = new FileInputStream("app/src/main/resources/database.properties");
    
            Properties databaseProperties = new Properties();
            databaseProperties.load(fileInputStream);
    
            String url = databaseProperties.getProperty("url");
            String username = databaseProperties.getProperty("username");
            String password = databaseProperties.getProperty("password");
    
            Connection connection = DriverManager.getConnection(url, username, password);
            thoughtDaoImpl = new ThoughtDaoImpl(connection);
    
            log.info("Connected to database");
        } catch(FileNotFoundException e) {
            log.error("FileInputStream error: " + e.getMessage());
            e.printStackTrace();
        } catch(IOException e) {
            log.error("Properties.load error: " + e.getMessage());
        } catch(SQLException e) {
            log.error("getConnection error: " + e.getMessage());
        }

    }
    
}
