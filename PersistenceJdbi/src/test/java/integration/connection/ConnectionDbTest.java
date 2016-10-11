package integration.connection;

import com.myproject.test.queries.jdbi.util.Config;
import com.myproject.test.queries.jdbi.util.ConnectionDb;
import org.junit.Test;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

public class ConnectionDbTest {

    @Test
    public void checkConnection(){

        DBI dbi= ConnectionDb.getConnection(new Config());
        Handle handle = dbi.open();
        handle.close();


    }


}
