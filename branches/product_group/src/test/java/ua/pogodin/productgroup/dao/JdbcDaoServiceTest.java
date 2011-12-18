package ua.pogodin.productgroup.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.pogodin.productgroup.dto.Group;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Sergii Pogodin
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/dao-context.xml")
public class JdbcDaoServiceTest {
    @Autowired
    private DaoService daoService;

    @Test
    public void testName() throws Exception {
        List<Group> groups = daoService.findAllGroups();
        assertNotNull(groups);

        Map<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(1L, 4);
        map.put(2L, 13);
        map.put(3L, 4);
        map.put(4L, 3);
        map.put(5L, 0);
        map.put(6L, 22);
        map.put(7L, 0);
        map.put(8L, 5);
        map.put(9L, 6);

        for (Group group : groups) {
            assertEquals(map.get(group.getGroupId()).longValue(), group.getProductCount());
        }
    }
}
