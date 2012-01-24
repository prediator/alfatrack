package com.emotion.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.emotion.Constants;
import com.emotion.model.Company;
import com.emotion.model.User;
import com.emotion.service.CompanyManager;

@Controller
@RequestMapping("/companies*")
public class CompanyFindController extends BaseFormController {
	private CompanyManager comMan;

	@Autowired
	public void setComMan(CompanyManager comMan) {
		this.comMan = comMan;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm(
			@RequestParam(required = false, value = "com") String id) {
		Long longId = 1l;
		if (id != null) {
			longId = Long.valueOf(id);
		}
		Map<String, Object> companyAndUsers = new HashMap<String, Object>();

		List<Company> comps = comMan.getCompanies();
	
		companyAndUsers.put(Constants.COMPANY_LIST, comps);
		companyAndUsers.put("users", comMan.getAllCompanyUsers(longId));
		companyAndUsers.put("companyName", comMan.get(longId).getName());

		return new ModelAndView("companyList", companyAndUsers);
	}
}
