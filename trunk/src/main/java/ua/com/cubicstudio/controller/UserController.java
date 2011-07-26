package ua.com.cubicstudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.com.cubicstudio.dao.UserDaoHibernate;
import ua.com.cubicstudio.domain.User;

/**
 * User Details Controller
 *
 * 
 */
@Controller
public class UserController {
    @Autowired
    private UserDaoHibernate userDao;

    @RequestMapping(value = "/user/{userId}")
    public ModelAndView findOwner(@PathVariable("userId") String userId, Model model) {
        User user = userDao.findById(Long.parseLong(userId));
        return new ModelAndView("user", "user", user);
    }
}
