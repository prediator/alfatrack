package ua.pogodin.productgroup.dao;

import ua.pogodin.productgroup.dto.Group;
import ua.pogodin.productgroup.dto.ProductList;

import java.util.List;

/**
 * @author Sergii Pogodin
 */
public class JdbcDaoService implements DaoService {
    @Override
    public List<Group> findAllGroups() {
        return null;  //todo pogodin
    }

    @Override
    public ProductList findProductsByGroupId(long groupId) {
        return null;  //todo pogodin
    }

    @Override
    public ProductList findProductsByGroupId(long groupId, String sortColumn, boolean asc) {
        return null;  //todo pogodin
    }

    @Override
    public ProductList findProductsByGroupId(long groupId, int from, int to, String sortColumn, boolean asc) {
        return null;  //todo pogodin
    }
}
