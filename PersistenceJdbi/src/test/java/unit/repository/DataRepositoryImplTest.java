package unit.repository;


import com.myproject.test.queries.jdbi.dao.DataDaoImpl;
import com.myproject.test.queries.jdbi.dao.IDataDao;
import com.myproject.test.queries.jdbi.repository.DataRepositoryFactory;
import com.myproject.test.queries.jdbi.repository.IDataRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Map;

import static org.mockito.Mockito.when;

public class DataRepositoryImplTest {


    @Test
    public void checkInstance(){

        IDataDao daoMock = Mockito.mock(DataDaoImpl.class);
        DataRepositoryFactory.dao=daoMock;
        Assert.assertTrue(DataRepositoryFactory.getRepository() instanceof IDataRepository);

    }


    @Test
    public void checkDataReturn(){

        IDataDao daoMock = Mockito.mock(DataDaoImpl.class);
        when(daoMock.getData()).thenReturn(new ArrayList<Map<String, Object>>());
        DataRepositoryFactory.dao=daoMock;
        Assert.assertTrue(DataRepositoryFactory.getRepository().getData().size() == 0);

    }

}
