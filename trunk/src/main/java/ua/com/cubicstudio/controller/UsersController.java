package ua.com.cubicstudio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sergii Pogodin
 *         23.01.2011
 */
@Controller
public class UsersController {

    @RequestMapping("users")
    public ModelAndView usersModelAndView() {
        String message = "No users found yet!";
        return new ModelAndView("users", "message", message);
    }
}
