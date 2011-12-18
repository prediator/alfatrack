package ua.pogodin.productgroup.dao;

import ua.pogodin.productgroup.dto.Group;
import ua.pogodin.productgroup.dto.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.reverseOrder;

/**
 * @author Sergii Pogodin
 */
@Deprecated
public class MockDaoService implements DaoService {
    private static final Comparator<Product> NAME_COMPARATOR = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return p2.getName().compareTo(p1.getName());
        }
    };
    public static final Comparator<Product> PRICE_COMPARATOR = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return p2.getPrice().compareTo(p1.getPrice());
        }
    };

    private static final List<Product> PRODUCTS_1;
    private static final List<Product> PRODUCTS_3;
    public static final ArrayList<Group> GROUPS = new ArrayList<Group>();

    static {
        PRODUCTS_1 = new ArrayList<Product>();
        PRODUCTS_1.add(new Product("Product11", new BigDecimal(1.1)));
        PRODUCTS_1.add(new Product("Product12", new BigDecimal(1.2)));
        PRODUCTS_1.add(new Product("Product13", new BigDecimal(1.3)));
        PRODUCTS_1.add(new Product("Product14", new BigDecimal(1.4)));
        PRODUCTS_1.add(new Product("Product15", new BigDecimal(1.5)));
        PRODUCTS_1.add(new Product("Product16", new BigDecimal(1.6)));
        PRODUCTS_1.add(new Product("Product17", new BigDecimal(1.7)));

        PRODUCTS_3 = new ArrayList<Product>();
        PRODUCTS_3.add(new Product("Product301", new BigDecimal(3.01)));
        PRODUCTS_3.add(new Product("Product302", new BigDecimal(3.02)));
        PRODUCTS_3.add(new Product("Product303", new BigDecimal(3.03)));
        PRODUCTS_3.add(new Product("Product304", new BigDecimal(3.04)));
        PRODUCTS_3.add(new Product("Product305", new BigDecimal(3.05)));
        PRODUCTS_3.add(new Product("Product306", new BigDecimal(3.06)));
        PRODUCTS_3.add(new Product("Product307", new BigDecimal(3.07)));
        PRODUCTS_3.add(new Product("Product308", new BigDecimal(3.08)));
        PRODUCTS_3.add(new Product("Product309", new BigDecimal(3.09)));
        PRODUCTS_3.add(new Product("Product310", new BigDecimal(3.10)));
        PRODUCTS_3.add(new Product("Product311", new BigDecimal(3.11)));
        PRODUCTS_3.add(new Product("Product312", new BigDecimal(3.12)));

        GROUPS.add(new Group(1, "Group1", 7));
        GROUPS.add(new Group(2, "Group2", 0));
        GROUPS.add(new Group(3, "Group3", 12));
    }

    @Override
    public List<Group> findAllGroups() {
        return GROUPS;
    }

    @Override
    public List<Product> findProductsByGroupId(long groupId, int from, int to) {
        return findProductsByGroupId(groupId, from, to, null, false);
    }

    @Override
    public List<Product> findProductsByGroupId(long groupId, int from, int to, String sortColumn, boolean asc) {
        List<Product> list = new ArrayList<Product>();
        if (groupId == 1) {
            list.addAll(PRODUCTS_1);
        }
        if (groupId == 3) {
            list.addAll(PRODUCTS_3.subList(from, Math.min(to, PRODUCTS_3.size())));
        }

        sortIfNeeded(list, sortColumn, asc);
        return list;
    }

    private void sortIfNeeded(List<Product> list, String sortColumn, boolean asc) {
        Comparator<Product> comparator = getComparator(sortColumn, asc);

        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private Comparator<Product> getComparator(String sortColumn, boolean asc) {
        Comparator<Product> comparator;
        if ("name".equals(sortColumn)) {
            comparator = NAME_COMPARATOR;
        } else if ("price".equals(sortColumn)) {
            comparator = PRICE_COMPARATOR;
        } else {
            return null;
        }
        return asc ? comparator : reverseOrder(comparator);
    }
}
