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
 * 
 * @author L ??.02.2011
 */
@Controller
public class AddUserController {

	private static final Logger log = Logger.getLogger(AddUserController.class);

	@RequestMapping(value = "adduser", method = RequestMethod.GET)
	public ModelAndView addUser() {
		return new ModelAndView("adduser");
	}

	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public ModelAndView addingUser(@RequestParam("name") String name,
			@RequestParam("login") String login,
			@RequestParam("pass") String pass) {

		User addedUser = new User(name, login, pass);
		log.info(addedUser);
		
		return new ModelAndView("/adduserreport", "user", addedUser);
	}
}
