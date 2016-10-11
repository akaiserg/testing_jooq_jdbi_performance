package com.myproject.test.queries.jooq.repository;


import java.util.List;
import java.util.Map;

public interface IDataRepository {

    public List<Map<String, Object>> getData();
}
