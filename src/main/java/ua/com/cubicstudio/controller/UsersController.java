package ua.com.cubicstudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.com.cubicstudio.dao.UserDaoHibernate;
import ua.com.cubicstudio.domain.User;

import java.util.List;

/**
 * User List Controller
 * 
 */
@Controller
public class UsersController {

    @Autowired
    private UserDaoHibernate userDao;

    @RequestMapping("users")
    public ModelAndView usersModelAndView() {
        List<User> userList = userDao.findAll();
        return new ModelAndView("users", "userList", userList);
    }
}
