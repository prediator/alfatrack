package com.emotion.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emotion.dao.CompanyDao;
import com.emotion.model.Company;
import com.emotion.model.User;

@Service("companyDao")
public class CompanyDaoHibernate extends GenericDaoHibernate<Company, Long>
		implements CompanyDao {

	public CompanyDaoHibernate() {
		super(Company.class);
	}

	@SuppressWarnings("unchecked")
	public List<Company> getCompanies() {
		return getHibernateTemplate().find(
				"from Company c order by upper(c.name)");
	}

	public Company saveCompany(Company company) {
		return this.save(company);
	}

	public Company getCompanyByName(String companyName) throws UsernameNotFoundException {
		List comps = getHibernateTemplate().find("from Company where name =?",
				companyName);
		if(comps == null || comps.isEmpty()){
			throw new UsernameNotFoundException("no such companyname :" + companyName);
		}
		return (Company)comps.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllCompanyUsers(Long id) {
		return getHibernateTemplate().find("from User u where u.company.id = ?", id);
	}
	

}
