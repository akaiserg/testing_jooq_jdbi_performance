package integration.connection;


import com.myproject.test.queries.jooq.util.Config;
import com.myproject.test.queries.jooq.util.ConnectionDb;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDbTest {

    @Test
    public void checkConnection() throws SQLException {

        Connection connection = ConnectionDb.getConnection(new Config());
        Assert.assertFalse(connection.isClosed());


    }


}
