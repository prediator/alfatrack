package com.emotion.webapp.controller;

import org.apache.commons.lang.StringUtils;
import com.emotion.Constants;
import com.emotion.model.Company;
import com.emotion.model.Role;
import com.emotion.model.User;
import com.emotion.service.CompanyManager;
import com.emotion.service.RoleManager;
import com.emotion.service.ModelExistsException;
import com.emotion.service.UserManager;
import com.emotion.webapp.util.RequestUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

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

		String companyId = request.getParameter("id");
		Long id = 1L;
		try {
			id = new Long("id");
		} catch (NumberFormatException ex) {
			log.info("set as first company info");
		}
		return comMan.getCompany("1");
	}

	private boolean isFormSubmission(HttpServletRequest request) {
		return request.getMethod().equalsIgnoreCase("post");
	}

	protected boolean isAdd(HttpServletRequest request) {
		String method = request.getParameter("method");
		return (method != null && method.equalsIgnoreCase("add"));
	}
}
