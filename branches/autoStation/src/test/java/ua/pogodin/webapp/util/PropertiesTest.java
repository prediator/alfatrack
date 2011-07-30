package ua.pogodin.webapp.util;

import org.junit.Assert;
import org.junit.Test;

public class PropertiesTest {
    @Test
    public void projectPropertiesShouldBeLoaded() throws Exception {
        Assert.assertEquals("com.mysql.jdbc.Driver", Properties.get("database.driverClassName"));
    }
}
