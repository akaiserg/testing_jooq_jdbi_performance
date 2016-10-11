package com.myproject.test.queries.jooq.repository;


import com.myproject.test.queries.jooq.dao.DataDaoImpl;
import com.myproject.test.queries.jooq.dao.IDataDao;

public class DataRepositoryFactory {

    public static IDataDao dao = null;

    static public DataRepositoryImpl getRepository(){

        if(dao  == null ){
            dao = new DataDaoImpl();
        }
        return new DataRepositoryImpl(dao);

    }
}
