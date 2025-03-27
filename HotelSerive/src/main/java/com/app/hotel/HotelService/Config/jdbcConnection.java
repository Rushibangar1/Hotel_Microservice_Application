package com.app.hotel.HotelService.Config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class jdbcConnection {

    private static final Logger log = LoggerFactory.getLogger(jdbcConnection.class);

    public Connection getConn(){
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/HotelService?createDatabaseIfNotExist=true";
            String userName = "root";
            String password = "root";
            connection = DriverManager.getConnection(url,userName,password);
            log.info("Made connection to the data base using jdbc");
        } catch (SQLException e) {
            log.error("Error connecting to Database {}",e.getMessage());
        }
        return connection;
    }
    }
