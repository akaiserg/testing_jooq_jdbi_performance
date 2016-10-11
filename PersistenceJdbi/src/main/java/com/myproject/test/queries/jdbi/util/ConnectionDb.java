package com.myproject.test.queries.jdbi.util;

import org.skife.jdbi.v2.DBI;


 public  class ConnectionDb {

    private static DBI dbi = null;

    public static  DBI getConnection(Config config){

        //if(dbi == null){
            dbi = new DBI("jdbc:mysql://localhost:3306/"+config.getDatabase(), config.getUser(), config.getPass());
        //}
        return dbi;

    }



}
