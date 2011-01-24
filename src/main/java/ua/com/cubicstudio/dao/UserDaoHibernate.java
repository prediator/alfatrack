package ua.com.cubicstudio.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import ua.com.cubicstudio.domain.User;

import java.util.List;

/**
 * @author Sergii Pogodin
 *         21.01.2011
 */
@Transactional
public class UserDaoHibernate extends HibernateDaoSupport {
    @Autowired
    public UserDaoHibernate(@Qualifier("sessionFactory") SessionFactory factory) {
        setSessionFactory(factory);
    }

    public User findById(Long id) {
        return (User) getSession().get(User.class, id);
    }

    public void saveOrUpdate(User user) {
        getSession().saveOrUpdate(user);
    }

    public void delete(User user) {
        getSession().delete(user);
    }

    public void delete(Long id) {
        Session session = getSession();
        User userProxy = (User) session.load(User.class, id);
        session.delete(userProxy);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return getSession().createCriteria(User.class).list();
    }

    /**
     * delete all Users
     * @return count of users deleted
     */
    public int deleteAll() {
        Number count = (Number) getSession().createQuery("select count(distinct id) from User").uniqueResult();
        getSession().createQuery("delete from User").executeUpdate();
        return count.intValue();
    }
}
