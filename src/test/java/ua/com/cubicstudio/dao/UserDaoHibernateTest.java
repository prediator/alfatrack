package ua.com.cubicstudio.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Sergii Pogodin
 *         21.01.2011
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/application-context.xml")
public class UserDaoHibernateTest {
    @Autowired
    @Qualifier("userDaoHibernate")
    private UserDaoHibernate userDaoHibernate;

    @Test
    public void testFindAll() throws Exception {
        Assert.assertEquals(0, userDaoHibernate.findAll().size());
    }

    public void setUserDaoHibernate(UserDaoHibernate userDaoHibernate) {
        this.userDaoHibernate = userDaoHibernate;
    }
}
