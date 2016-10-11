package com.myproject.test.queries.jooq.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public  class ConnectionDb {

    private static Connection con=null;

   public static  Connection getConnection(Config config) throws SQLException {

       //if(con == null){
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+config.getDatabase(), config.getUser(), config.getPass());
       //}
       return con;


   }



}
