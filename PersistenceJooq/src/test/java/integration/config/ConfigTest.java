package integration.config;


import com.myproject.test.queries.jooq.util.Config;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigTest {

    private Config config;

    @Before
    public void setUp(){

        config = new Config();

    }

    @Test
    public void checkInstance(){

        Assert.assertTrue(config instanceof Config);

    }

    @Test
    public void checkValue(){

        String user = config.getUser();
        String pass = config.getPass();
        String bd = config.getDatabase();
        Assert.assertNotNull(user);
        Assert.assertNotNull(pass);
        Assert.assertNotNull(bd);

    }


}
