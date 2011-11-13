package ua.com.cubicstudio.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ua.com.cubicstudio.domain.Dispatcher;
import ua.com.cubicstudio.domain.Driver;
import ua.com.cubicstudio.domain.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/application-context.xml")
@TransactionConfiguration(transactionManager = "txManager"/*, defaultRollback = false*/)
@Transactional
public class UserDaoHibernateTest {
	@Autowired
	@Qualifier("userDaoHibernate")
	private UserDaoHibernate dao;
	private User user;

	@Before
	public void setUp() {
		user = createAndSaveUser("James Bond", "jbond", "vermut", false);
	}

	@Test
	public void saveNewUser() {
		assertNotNull(user.getId());
	}

	@Test
	public void updatePersistentUser() {
		user.setFullName("Lara Croft");
		user.setLogin("lcroft");
		user.setPassword("joly");

		dao.saveOrUpdate(user);
		user = dao.findById(user.getId());

		assertEquals("Lara Croft", user.getFullName());
		assertEquals("lcroft", user.getLogin());
		assertEquals("joly", user.getPassword());
	}

	@Test
	public void testFindById() {
		User user = dao.findById(this.user.getId());
		assertSame(user, this.user);
	}

	@Test
	public void testFindAll() {
		user = createAndSaveUser("James Bond Jr", "jbondjr", "vermut", false);
		assertEquals(2, dao.findAll().size());
	}

	@Test
	public void testDelete() {
		dao.delete(user);
		assertNull(dao.findById(user.getId()));
	}

	@Test
	public void testDeleteById() {
		dao.delete(user.getId());
		assertNull(dao.findById(user.getId()));
	}

	@Test
	public void testDeleteAll() {
		user = createAndSaveUser("James Bond Jr", "jbondjr", "vermut", false);
		assertEquals(2, dao.deleteAll());
		assertEquals(0, dao.deleteAll());
	}

	private User createAndSaveUser(String username, String login, String password, boolean isDispatcher) {
		User user;
//		if (isDispatcher) {
			user = new Dispatcher(username, login, password);
//		} else {
//			user = new Driver(username, login, password);
//		}
		assertNull(user.getId());
		dao.saveOrUpdate(user);
		return user;
	}
}
