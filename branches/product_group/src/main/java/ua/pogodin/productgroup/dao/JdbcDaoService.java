package ua.pogodin.productgroup.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import ua.pogodin.productgroup.dto.Group;
import ua.pogodin.productgroup.dto.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Sergii Pogodin
 */
public class JdbcDaoService implements DaoService {

    @Autowired
    private SimpleJdbcTemplate jdbcTemplate;

    @Override
    public List<Group> findAllGroups() {
        RowMapper<Group> mapper = new RowMapper<Group>() {
            public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Group(rs.getLong("group_id"), rs.getString("group_name"), rs.getInt("product_count"));
            }
        };
        return jdbcTemplate.query(
                "select g.group_id, g.group_name, count(p.product_id) product_count " +
                        "from T_GROUP g " +
                        "left join T_PRODUCT p on p.group_id = g.group_id " +
                        "group by group_id, group_name",
                mapper);
    }

    @Override
    public List<Product> findProductsByGroupId(long groupId, int from, int to) {
        return jdbcTemplate.query(
                "select product_name, product_price " +
                        "from T_PRODUCT " +
                        "where group_id = ? " +
                        "limit ?,?",
                getProductMapper(), groupId, from, to - from);
    }

    @Override
    public List<Product> findProductsByGroupId(long groupId, int from, int to, String sortColumn, boolean asc) {
        return (sortColumn == null)
                ? findProductsByGroupId(groupId, from, to)
                : jdbcTemplate.query(
                "select product_name, product_price " +
                        "from T_PRODUCT " +
                        "where group_id = ? " +
                        "order by " + getSortingColumn(sortColumn, asc) + " " +
                        "limit ?,? ",
                getProductMapper(), groupId, from, to - from);
    }

    private String getSortingColumn(String sortColumn, boolean asc) {
        if ("name".equals(sortColumn)) {
            sortColumn = "product_name";
        } else if ("price".equals(sortColumn)) {
            sortColumn = "product_price";
        }
        if (!asc) {
            sortColumn += " desc";
        }
        return sortColumn;
    }

    private RowMapper<Product> getProductMapper() {
        return new RowMapper<Product>() {
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Product(rs.getString("product_name"), rs.getBigDecimal("product_price"));
            }
        };
    }
}
