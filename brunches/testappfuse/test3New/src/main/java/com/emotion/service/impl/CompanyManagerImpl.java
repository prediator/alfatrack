package com.emotion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emotion.dao.CompanyDao;
import com.emotion.model.Company;
import com.emotion.model.User;
import com.emotion.service.CompanyManager;

@Service("companyManager")
public class CompanyManagerImpl extends GenericManagerImpl<Company, Long> implements CompanyManager {

	CompanyDao companyDao;
	
	@Autowired
	public void setCompanyDao(CompanyDao companyDao) {
		this.dao = companyDao;
		this.companyDao = companyDao;
	}

	public Company getCompany(String companyId) {
		return companyDao.get(new Long(companyId));
	}

	public Company getCompanyByName(String name)
			throws UsernameNotFoundException {
		return companyDao.getCompanyByName(name);
	}

	public List<Company> getCompanies() {
		return companyDao.getAllDistinct();
	}

	public Company saveCompany(Company company) {
		return companyDao.saveCompany(company);	
	}

	public void removeCompany(String companyId) {
		 log.debug("removing company: " + companyId);
	        companyDao.remove(new Long(companyId));
	}

	public List<Company> search(String searchTerm) {
		return super.search(searchTerm, Company.class);
	}

	public List<User> getAllCompanyUsers(Long id) {
		return companyDao.getAllCompanyUsers(id);
	}

}
