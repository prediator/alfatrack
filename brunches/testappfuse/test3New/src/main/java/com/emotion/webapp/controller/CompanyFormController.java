package com.emotion.webapp.controller;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emotion.model.Company;
import com.emotion.service.CompanyManager;

@Controller
@RequestMapping("/companyform*")
public class CompanyFormController extends BaseFormController {
	private CompanyManager comMan;

	@Autowired
	public void setComMan(CompanyManager comMan) {
		this.comMan = comMan;
	}

	public CompanyFormController() {
		setCancelView("redirect:/mainMenu");
		setSuccessView("redirect:/companies");
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(Company company, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		if (request.getParameter("cancel") != null) {
			return getSuccessView();

		}
		if (validator != null) { // validator is null during testing
			validator.validate(company, errors);
			if (errors.hasErrors()) { // don't
				return getSuccessView();
			}
		}
		log.debug("entering 'onSubmit' method...");
		try {
			company.setUpdateDate(new Date());
			company.setDate(new Date(new Random().nextInt(Integer.MAX_VALUE)));
			comMan.save(company);
		} catch (AccessDeniedException ade) {
			// thrown by UserSecurityAdvice configured in aop:advisor
			// userManagerSecurity
			log.warn(ade.getMessage());
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}

		return getSuccessView();
	}

	@ModelAttribute
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	protected Company showForm(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (isAdd(request)) {
			return new Company();
		}

		log.info("<--" + request.getParameter("id") + "-->");
		Company company = comMan.getCompany(request.getParameter("id"));
		if(company == null){
			log.info("we'll dive you your company to change");
			return getUserManager().getUserByUsername(request.getRemoteUser()).getCompany();
		}
		return company;
	}

	private boolean isFormSubmission(HttpServletRequest request) {
		return request.getMethod().equalsIgnoreCase("post");
	}

	protected boolean isAdd(HttpServletRequest request) {
		String method = request.getParameter("method");
		return (method != null && method.equalsIgnoreCase("add"));
	}
}
