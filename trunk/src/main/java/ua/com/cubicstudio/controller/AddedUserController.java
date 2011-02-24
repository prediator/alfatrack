package ua.com.cubicstudio.controller;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.cubicstudio.dao.UserDaoHibernate;
import ua.com.cubicstudio.domain.User;

/**
 * User Details Controller
 *
 * @author L
 *         ??.02.2011
 */
@Controller
public class AddedUserController {
    
    @RequestMapping(value = "/addUser/addedUser")
    public ModelAndView takeInfo() {
        return new ModelAndView("user", "user",AddUserController.ADDED_USER);
    }
}
