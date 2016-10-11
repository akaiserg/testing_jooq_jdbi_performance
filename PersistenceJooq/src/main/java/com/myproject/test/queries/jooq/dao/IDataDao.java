package com.myproject.test.queries.jooq.dao;

import java.util.List;
import java.util.Map;

public interface IDataDao {

    public List<Map<String, Object>> getData();
    public List<Map<String, Object>> getData(int limit);
}
