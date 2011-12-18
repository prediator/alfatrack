package ua.pogodin.productgroup.dao;

import ua.pogodin.productgroup.dto.Group;
import ua.pogodin.productgroup.dto.Product;

import java.util.List;

/**
 * @author Sergii Pogodin
 */
public interface DaoService {
    List<Group> findAllGroups();

    List<Product> findProductsByGroupId(long groupId, int from, int to);

    List<Product> findProductsByGroupId(long groupId, int from, int to, String sortColumn, boolean asc);
}
