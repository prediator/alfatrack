package ua.com.cubicstudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.cubicstudio.dao.UserDaoHibernate;
import ua.com.cubicstudio.domain.User;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Adding User Controller
 * @author L
 *         ??.02.2011
 */
@Controller


public class AddUserController {
    
	//user with inputing data
	static User ADDED_USER;
	/*
	//to output in console
	private static final Logger logger = Logger.getLogger(AddUserController.class);
	*/
	
	
    @Autowired
    private UserDaoHibernate userDao;
	
	@RequestMapping(value = "addUser", method = RequestMethod.GET)
    public ModelAndView addUser() {
        return new ModelAndView("adduser");
	}
	

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public String addingUser(@RequestParam("name") String name,
    		@RequestParam("name") String login,
    		@RequestParam("name") String pass){
    	//
    	ADDED_USER = new User(name,login,pass);
    	Long lastUser = new Long(userDao.findAll().size() + 1);
    	ADDED_USER.setId(lastUser);
    	
    	/*
    	//make file loging.log in c:\ - with log of inputting data
    	if(logger.isDebugEnabled()){
			logger.debug(name);
			logger.debug(login);
			logger.debug(pass);
		}*/
 
    	

    	return "redirect:http://localhost:8080/alfatrack/addUser/addedUser.html";
    
    }
}
