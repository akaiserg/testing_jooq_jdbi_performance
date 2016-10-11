package com.myproject.test.queries.jooq.util;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class Config {

    private String pass;
    private String user;
    private String database;

    public Config(){

        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = Config.class.getResourceAsStream("/config.properties");
            //input = new FileInputStream("src/main/Resources/config.properties");
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            //System.out.println(prop.getProperty("database"));
            //System.out.println(prop.getProperty("dbuser"));
            //System.out.println(prop.getProperty("dbpassword"));
            this.pass=prop.getProperty("dbpassword");
            this.user=prop.getProperty("dbuser");
            this.database=prop.getProperty("database");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
