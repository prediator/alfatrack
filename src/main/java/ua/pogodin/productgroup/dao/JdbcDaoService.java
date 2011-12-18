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
        String sql = "select g.group_id, g.group_name, count(p.product_id) product_count " +
                "from T_GROUP g " +
                "left join T_PRODUCT p on p.group_id = g.group_id " +
                "group by group_id, group_name";

        RowMapper<Group> mapper = new RowMapper<Group>() {
            public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Group(rs.getLong("group_id"), rs.getString("group_name"), rs.getInt("product_count"));
            }
        };
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public List<Product> findProductsByGroupId(long groupId, int from, int to) {
        return null;  //todo pogodin
    }

    @Override
    public List<Product> findProductsByGroupId(long groupId, int from, int to, String sortColumn, boolean asc) {
        return null;  //todo pogodin
    }
}
