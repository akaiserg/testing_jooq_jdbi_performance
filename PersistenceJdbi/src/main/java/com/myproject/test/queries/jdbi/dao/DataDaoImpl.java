package com.myproject.test.queries.jdbi.dao;

import com.myproject.test.queries.jdbi.util.Config;
import com.myproject.test.queries.jdbi.util.ConnectionDb;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;

import java.util.List;
import java.util.Map;

public class DataDaoImpl implements IDataDao {

    private boolean singletonConnection;
    Handle handle = null;
    private static final String SQL = "Select * from info";

    public DataDaoImpl(){

        singletonConnection = false;

    }

    public DataDaoImpl(boolean singleton){

       singletonConnection = singleton;

    }

    public List<Map<String, Object>> getData(int limit){

        return execute(SQL + " limit "+limit);

    }

    public List<Map<String, Object>> getData(){

        return execute(SQL);

    }

    private List<Map<String, Object>> execute(String sql){

        List<Map<String, Object>> list=null;
        try{
            Query<Map<String, Object>> resultSet = getConnection().createQuery(sql);
            list = resultSet.list();
        }finally{
            closeConnection();
        }
        return list;

    }

    private Handle getConnection(){

        if(handle == null){
            DBI dbi = ConnectionDb.getConnection(new Config());
            handle = dbi.open();

        }
        return handle;

    }

    private void closeConnection(){

        if(!singletonConnection){
            if(handle != null){
                handle.close();
                handle = null;
            }
        }

    }

}
