package ua.pogodin.productgroup.dao;

import ua.pogodin.productgroup.dto.Group;
import ua.pogodin.productgroup.dto.Product;
import ua.pogodin.productgroup.dto.ProductList;

import java.util.List;

/**
 * @author Sergii Pogodin
 */
public interface DaoService {
    List<Group> findAllGroups();

    ProductList findProductsByGroupId(long groupId);

    ProductList findProductsByGroupId(long groupId, int from, int to);

    ProductList findProductsByGroupId(long groupId, int from, int to, String sortColumn, boolean asc);
}
