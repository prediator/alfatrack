package ua.pogodin.productgroup.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.pogodin.productgroup.dto.Group;
import ua.pogodin.productgroup.dto.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Sergii Pogodin
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/dao-context.xml")
public class JdbcDaoServiceTest {
    @Autowired
    private DaoService daoService;

    @Test
    public void allGroupsShouldBeFoundWithProperProductCount() throws Exception {
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

    @Test
    public void productsShouldBeFoundByGroupIdFrom0to10() throws Exception {
        List<Product> products = daoService.findProductsByGroupId(1L, 0, 10);
        assertNotNull(products);
        assertEquals(4, products.size());

        Set<Product> expectedProducts = new HashSet<Product>();
        expectedProducts.add(new Product("7-Function Classic Chic - Mini G Vibrattor", new BigDecimal("18.95")));
        expectedProducts.add(new Product("Ultra 6.5\" Waterproof Vibrator", new BigDecimal("25.95")));
        expectedProducts.add(new Product("Heart of Hearts Micro Vibe", new BigDecimal("17.95")));
        expectedProducts.add(new Product("Monica Mayhem's Temptation Kit", new BigDecimal("39.95")));

        expectedProducts.removeAll(products);
        assertTrue(expectedProducts.isEmpty());
    }


    @Test
    public void emptyListShouldBeFoundFrom0to0() throws Exception {
        List<Product> products = daoService.findProductsByGroupId(1L, 0, 0);
        assertNotNull(products);
        assertTrue(products.isEmpty());
    }


}
