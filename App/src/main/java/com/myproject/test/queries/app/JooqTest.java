package com.myproject.test.queries.app;

import com.myproject.test.queries.jooq.repository.DataRepositoryFactory;
import com.myproject.test.queries.jooq.repository.IDataRepository;
import com.myproject.test.queries.util.ExecutionTime;
import com.myproject.test.queries.util.LetterCounter;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class JooqTest {

    private  ExecutionTime time= new ExecutionTime();

    public  String getMessage(char letter){

        time.setStart(new Date());
        LetterCounter lC = new LetterCounter();
        int amount = lC.count(getData(),letter);
        time.setEnd(new Date());
        return generateMsg(amount,time.differenceMilliseconds(),letter);

    }

    private String generateMsg(int amount, Long differenceMilliseconds, char letter) {

        return " JOOQ: The letter "+letter+" was found "+amount+" times and took "+differenceMilliseconds+" milliseconds";
    }

    private List<Map<String, Object>> getData(){

        IDataRepository repository = DataRepositoryFactory.getRepository();
        return repository.getData();

    }

}
