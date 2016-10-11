package com.myproject.test.queries.jdbi.repository;

import com.myproject.test.queries.jdbi.dao.IDataDao;

import java.util.List;
import java.util.Map;

public class DataRepositoryImpl  implements  IDataRepository{

    private IDataDao dao;

    public DataRepositoryImpl(IDataDao dao){

        this.dao = dao;

    }

    public List<Map<String, Object>> getData() {

        return dao.getData();

    }
}
