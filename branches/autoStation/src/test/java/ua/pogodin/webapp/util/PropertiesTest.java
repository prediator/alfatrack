package ua.pogodin.webapp.util;

import org.junit.Assert;
import org.junit.Test;

public class PropertiesTest {
    @Test
    public void projectPropertiesShouldBeLoaded() throws Exception {
        Properties properties = Properties.get();
        Assert.assertNotNull(properties);
        Assert.assertEquals("com.mysql.jdbc.Driver", properties.getProperty("database.driverClassName"));
    }
}
