package ua.pogodin.productgroup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sergii Pogodin
 */
@Controller
public class ProductsController {

    @RequestMapping("*")
    public ModelAndView showProducts() {
        return new ModelAndView("products", "productsNumber", 3);
    }
}
