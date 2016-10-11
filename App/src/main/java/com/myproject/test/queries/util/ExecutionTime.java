package com.myproject.test.queries.util;


import lombok.Getter;

import java.util.Date;

public class ExecutionTime {

    @Getter
    private Long lStartDate;
    @Getter
    private long lTimeEnd;

    public void setStart(Date startDate){

        lStartDate = startDate.getTime();

    }

    public void setEnd(Date timeEnd) {

        lTimeEnd = timeEnd.getTime();

    }

    public Long differenceMilliseconds() {

        return lTimeEnd - lStartDate;

    }
}
