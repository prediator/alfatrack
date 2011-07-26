package ua.com.cubicstudio.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ua.com.cubicstudio.domain.Dispatcher;
import ua.com.cubicstudio.domain.Driver;
import ua.com.cubicstudio.domain.User;

/**
 * Adding User Controller
 * 
 * @author L ??.02.2011
 */
@Controller
public class AddUserController {

	private static final Logger LOG = Logger.getLogger(AddUserController.class);

	@RequestMapping(value = "adduser", method = RequestMethod.GET)
	public ModelAndView addUser() {
		return new ModelAndView("adduser");
	}

	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public String addingUser(@RequestParam("name") String name,
			@RequestParam("login") String login,
			@RequestParam("pass") String pass,
			@RequestParam("isDispatcher") boolean isDispatcher) {
		
		User addedUser;
		if (isDispatcher) {
			addedUser = new Dispatcher(name, login, pass);
		} else {
			addedUser = new Driver(name, login, pass);
		}

		/*
		 * //TODO: can't get isDispacher value from Dispacher + it dnt want to
		 * work from 1:40 am
		 */

		LOG.info("User added:" + addedUser);

		return "redirect:users.htm";
	}
}
