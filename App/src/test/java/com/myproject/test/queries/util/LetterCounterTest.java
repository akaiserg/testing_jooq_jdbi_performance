package com.myproject.test.queries.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LetterCounterTest {

    LetterCounter lC;

    @Before
    public void setUp(){

        lC = new LetterCounter();

    }

    @Test
    public void checkInstance(){

        Assert.assertTrue(lC instanceof  LetterCounter);

    }

    @Test
    public void checkCountLetterWithTheLetter(){


        int amount=lC.count(getList(),'a');
        Assert.assertEquals(amount,2);

    }

    @Test
    public void checkCountLetterWithOutTheLetter(){


        int amount=lC.count(getListNotA(),'a');
        Assert.assertEquals(amount,0);

    }

    private List<Map<String, Object>> getList(){

        List<Map<String, Object>> list= new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("id",1);
        map1.put("name","name 1");
        list.add(map1);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id",2);
        map2.put("name","name 2");
        list.add(map2);
        return list;

    }

    private List<Map<String, Object>> getListNotA(){

        List<Map<String, Object>> list= new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("id",1);
        map1.put("name","n-me 1");
        list.add(map1);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id",2);
        map2.put("name","n-me 2");
        list.add(map2);
        return list;

    }


}