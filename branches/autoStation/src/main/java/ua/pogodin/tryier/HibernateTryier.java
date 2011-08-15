package ua.pogodin.tryier;

import javax.persistence.EntityManager;

import ua.pogodin.webapp.dao.DbConnection;
import ua.pogodin.webapp.dao.impl.BaseHiberDao;
import ua.pogodin.webapp.dao.impl.HiberJPADao;
import ua.pogodin.webapp.dao.impl.HibernateUtil;
import ua.pogodin.webapp.domain.User;

public class HibernateTryier {

	public static void main (String [] args){
		
		System.out.println("start");
		User user ;//= new User("try", "try", "name");
		DbConnection db = new HiberJPADao();
		BaseHiberDao bh = new BaseHiberDao();
	
		
		
		
		
	}
}
