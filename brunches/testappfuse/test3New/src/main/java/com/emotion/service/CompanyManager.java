package com.emotion.service;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.emotion.dao.CompanyDao;
import com.emotion.model.Company;
import com.emotion.model.User;

public interface CompanyManager extends GenericManager<Company, Long> {

	/**
	 * Convenience method for testing - allows you to mock the DAO and set it on
	 * an interface.
	 * 
	 * @param CompanyDao
	 *            the CompanyDao implementation to use
	 */
	void setCompanyDao(CompanyDao companyDao);

	/**
	 * Retrieves a Company by id. An exception is thrown if Company not found
	 * 
	 * @param companyId
	 *            the identifier for the Company
	 * @return Company
	 */
	Company getCompany(String companyId);

	/**
	 * Finds a Company by their name.
	 * 
	 * @param name
	 *            the Company's Companyname used to login
	 * @return company a populated Company object
	 * @throws org.springframework.security.core.Userdetails.UsernameNotFoundException
	 *             exception thrown when Company not found
	 */
	Company getCompanyByName(String name) throws UsernameNotFoundException;

	/**
	 * Retrieves a list of all Companies.
	 * 
	 * @return List
	 */
	List<Company> getCompanies();

	/**
	 * Saves a Company's information.
	 * 
	 * @param Company
	 *            the Company's information
	 * @throws CompanyExistsException
	 *             thrown when Company already exists
	 * @return Company the updated Company object
	 */
	Company saveCompany(Company Company) throws ModelExistsException;

	/**
	 * Removes a Company from the database by their CompanyId
	 * 
	 * @param CompanyId
	 *            the Company's id
	 */
	void removeCompany(String companyId);

	/**
	 * Search a Company for search terms.
	 * 
	 * @param searchTerm
	 *            the search terms.
	 * @return a list of matches, or all if no searchTerm.
	 */
	List<Company> search(String searchTerm);

	List<User> getAllCompanyUsers(Long id);
}
