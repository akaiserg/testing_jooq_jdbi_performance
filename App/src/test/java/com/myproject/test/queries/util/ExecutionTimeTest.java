package com.myproject.test.queries.util;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Andres_2 on 09/10/2016.
 */
public class ExecutionTimeTest {

    private ExecutionTime time;

    @Before
    public void setUp() throws Exception {

        time = new ExecutionTime();

    }

    @Test
    public void checkInstance(){

        Assert.assertTrue(time instanceof  ExecutionTime);

    }

    @Test
    public void setStartTime(){

        Calendar cal = getCalendar(30);
        Date timeStart = cal.getTime();
        time.setStart(timeStart);
        Assert.assertTrue(time.getLStartDate() == timeStart.getTime());

    }

    @Test
    public void setEndTime(){

        Calendar cal = getCalendar(32);
        Date timeEnd = cal.getTime();
        time.setEnd(timeEnd);
        Assert.assertEquals(time.getLTimeEnd(),timeEnd.getTime());

    }

    @Test
    public void getDifference(){

        Calendar calStart = getCalendar(29);
        Date timeStart = calStart.getTime();
        time.setStart(timeStart);
        Calendar calEnd = getCalendar(32);
        Date timeEnd = calEnd.getTime();
        time.setEnd(timeEnd);
        Long differenceMilliseconds = timeEnd.getTime() - timeStart.getTime();
        Assert.assertEquals(differenceMilliseconds, time.differenceMilliseconds());

    }



    private Calendar getCalendar(int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2016);
        cal.set(Calendar.MONTH, 10);
        cal.set(Calendar.DAY_OF_MONTH, 12);
        cal.set(Calendar.HOUR_OF_DAY, 17);
        cal.set(Calendar.MINUTE, minutes);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal;
    }

}