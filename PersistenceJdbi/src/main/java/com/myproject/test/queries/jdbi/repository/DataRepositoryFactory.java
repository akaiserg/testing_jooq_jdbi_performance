package com.myproject.test.queries.jdbi.repository;

import com.myproject.test.queries.jdbi.dao.DataDaoImpl;
import com.myproject.test.queries.jdbi.dao.IDataDao;


public class DataRepositoryFactory {

    public static  IDataDao dao = null;

    static public IDataRepository getRepository(){

        if(dao  == null ){
            dao = new DataDaoImpl();
        }
        return new DataRepositoryImpl(dao);

    }
}
