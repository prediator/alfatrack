package com.emotion.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.emotion.model.Address;
import com.emotion.model.Company;
import com.emotion.model.User;

public class CompanyDaoTest extends BaseDaoTestCase {
	@Autowired
	private CompanyDao comDao;
	@Autowired
	private UserDao userDao;

	@Test
	public void getCompanyTest() {
		Company comp = comDao.get(1L);

		assertNotNull(comp);
	}
	
	@Test
	public void getUsersTest(){
		Company comp = comDao.get(1L);
		List<User> users = comp.getUsers();
		
		assertNotNull(users);
		assertNotNull(users.get(0));
		assertEquals("user", users.get(0).getUsername());
		
	}
	
	@Test
	public void setAndGetUsers(){
		User user = new User("testuser");
        user.setPassword("testpass");
        user.setFirstName("Test");
        user.setLastName("Last");
        Address address = new Address();
        address.setCity("Denver");
        address.setProvince("CO");
        address.setCountry("USA");
        address.setPostalCode("80210");
        user.setAddress(address);
        user.setEmail("testuser@appfuse.org");
        user.setWebsite("http://raibledesigns.com");
        
        Company comp = comDao.get(1L);
        List<User> usersInitial = comp.getUsers();
        usersInitial.add(user);
        comp.setUsers(usersInitial);
        comDao.save(comp);
        userDao.save(user);
        flush();
        
        Long id = user.getId();
        User userGet = userDao.get(id);
        assertEquals(user, userGet);
	}
}
