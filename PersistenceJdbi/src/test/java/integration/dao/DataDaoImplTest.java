package integration.dao;

import com.myproject.test.queries.jdbi.dao.DataDaoImpl;
import com.myproject.test.queries.jdbi.dao.IDataDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;


public class DataDaoImplTest {

    private IDataDao dataDaoImpl;


    @Before
    public void setUp(){

        dataDaoImpl = new DataDaoImpl();

    }

    @Test
    public void checkInstance(){

        Assert.assertTrue(dataDaoImpl instanceof  IDataDao);

    }

    @Test
    public void checkData(){

        List<Map<String, Object>> list = dataDaoImpl.getData(1);
        Assert.assertNotSame(list.size(),0);

    }

    @Test
    public void checkFormat(){

        List<Map<String, Object>> list = dataDaoImpl.getData(1);
        Assert.assertTrue((Long)list.get(0).get("id")>=0L);
        Assert.assertTrue(list.get(0).get("name") instanceof  String);

    }

}