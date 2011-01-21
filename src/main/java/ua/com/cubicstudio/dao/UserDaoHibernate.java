package ua.com.cubicstudio.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import ua.com.cubicstudio.domain.User;

import java.util.List;

/**
 * @author Sergii Pogodin
 *         21.01.2011
 */
public class UserDaoHibernate extends HibernateDaoSupport {
    @Autowired
    public UserDaoHibernate(@Qualifier("sessionFactory") SessionFactory factory) {
        setSessionFactory(factory);
    }


    public void saveOrUpdate(User user) {
        getSession().saveOrUpdate(user);
    }

    public void delete(User user) {
        getSession().delete(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return getSession().createCriteria(User.class).list();
    }
}
