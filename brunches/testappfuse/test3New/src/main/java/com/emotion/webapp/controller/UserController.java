package com.emotion.webapp.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javassist.bytecode.Mnemonic;

import com.emotion.Constants;
import com.emotion.model.User;
import com.emotion.service.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Simple class to retrieve a list of users from the database.
 * <p/>
 * <p>
 * <a href="UserController.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Controller
@RequestMapping("/admin/users*")
public class UserController {
	private UserManager mgr = null;

	@Autowired
	public void setUserManager(UserManager userManager) {
		this.mgr = userManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(
			@RequestParam(required = false, value = "q") String query,
			@RequestParam(required = false, value = "f") String field)
			throws Exception {
		ModelAndView listUserModel = new ModelAndView("admin/userList");
		listUserModel.addObject(Constants.USER_LIST, mgr.search(query, field));
		listUserModel
				.addObject(Constants.USER_ATTRIBUTES, unusingFields(field));
		if (field != null && !field.equals("")) {
			listUserModel.addObject("currentField", field);
		}
		return listUserModel;
	}

	private List<String> unusingFields(String fieldName) {
		List<String> fieldsList = new ArrayList<String>(Constants.USER_FIELDS);
		fieldsList.remove(fieldName);

		return fieldsList;
	}
}
