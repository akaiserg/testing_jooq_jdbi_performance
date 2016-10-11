package com.myproject.test.queries.jooq.dao;


import com.myproject.test.queries.jooq.util.Config;
import com.myproject.test.queries.jooq.util.ConnectionDb;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class DataDaoImpl implements IDataDao {

    private boolean singletonConnection;
    private Connection con = null;
    private static final String QUERY_SQL = "Select * from info";

    public DataDaoImpl()  {

        singletonConnection = false;

    }

    public DataDaoImpl(boolean singleton){

        singletonConnection = singleton;

    }

    public List<Map<String, Object>> getData(int limit){

        return executeWithJooq(QUERY_SQL + " limit "+limit);

    }


    public List<Map<String, Object>> getData(){

        return executeWithJooq(QUERY_SQL);

    }

    private List<Map<String, Object>> executeWithJooq(String sql){

        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        try {
            new QueryRunner()
                .query(getConnection(), sql, new ArrayListHandler())
                // We can transform any Collection into a Stream
                    .stream().map(
                        array -> {
                            Map<String,Object> map = new HashMap<String, Object>();
                            map.put("id",array[0]);
                            map.put("name",array[1]);
                            return map;
                        }
                    )
                    // ... and then profit from the new Stream methods
                    .forEach(m->result.add(m));
        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection();
        }
        closeConnection();
        return result;

    }

    private Connection getConnection(){

        if(con == null)
        try {
            con = ConnectionDb.getConnection(new Config());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }

    private void closeConnection(){

        if(!singletonConnection){
            try {
                if(con.isClosed() == false){
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /*
        // normal way
    private List<Map<String, Object>> execute(String sql){

        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        try {
            con = ConnectionDb.getConnection(new Config());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("id",rs.getLong("id"));
                map.put("name",rs.getString("name"));
                result.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
     */


}


