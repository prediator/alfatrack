package com.emotion.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.emotion.model.Company;
import com.emotion.model.User;

public interface CompanyDao extends GenericDao<Company, Long>  {

	/**
     * Gets a list of company ordered by the uppercase version of their name.
     *
     * @return List populated list of companies
     */
	List<Company> getCompanies();
	
	 /**
     * Saves a company's information.
     * @param company the object to be saved
     * @return the persisted Company object
     */
    Company saveCompany(Company company);
	
    /**
     * Gets the company with inputed name
     * @param companyName name of the company
     * @return the Company object with this name
     */
    Company getCompanyByName(String companyName)throws UsernameNotFoundException;
    
    List<User> getAllCompanyUsers(Long id);
}
