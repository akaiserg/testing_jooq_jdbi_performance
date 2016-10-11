# Testing JOOQ and JDNI performance


These two libraries are good options when you don't want to use Hibernate  to handle  the communication with your DB.

[http://jdbi.org/](http://jdbi.org/)

[http://www.jooq.org/](http://www.jooq.org/)


Although you can convert normal queries into arrays with both, JOOQ uses ResultSet Stream(http://www.jooq.org/java-8-and-sql) which  improves the performance.


A single query which has 1000 rows:

![image](https://github.com/akaiserg/testing_jooq_jdbi_performance/blob/master/pics/1000.png?raw=true)

A single query which has 10000 rows:

![image](https://github.com/akaiserg/testing_jooq_jdbi_performance/blob/master/pics/10000.png?raw=true)

A single query which has 100000 rows:

![image](https://github.com/akaiserg/testing_jooq_jdbi_performance/blob/master/pics/100000.png?raw=true)


You see see a slight difference  on the times. For the example with JOOQ was used   [Apache DbUtils](http://commons.apache.org/proper/commons-dbutils/)  and  [java8 streams](https://www.tutorialspoint.com/java8/java8_streams.htm).



### Resources:

 * [https://blog.jooq.org/tag/entity-framework/](https://blog.jooq.org/tag/entity-framework/) 
 * [http://www.hibernate-alternative.com/](http://www.hibernate-alternative.com/) 
 * [http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/](http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/)
