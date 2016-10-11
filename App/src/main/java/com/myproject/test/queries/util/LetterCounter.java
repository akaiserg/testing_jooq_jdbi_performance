package com.myproject.test.queries.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LetterCounter {

    public int count(List<Map<String, Object>> map, char letter){

        int count = 0;
        Iterator<Map<String, Object>> mapIterator = map.iterator();
        while(mapIterator.hasNext()){
            count= count + findLetter(mapIterator.next(),letter);
        }
        return count;

    }

    private int findLetter(Map<String, Object> values, char letter) {

        String name = (String)values.get("name");
        return (int)name.chars().filter(ch -> ch == letter).count();

    }

}
