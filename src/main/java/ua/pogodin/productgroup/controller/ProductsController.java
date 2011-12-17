package ua.pogodin.productgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.pogodin.productgroup.dao.DaoService;
import ua.pogodin.productgroup.dto.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Sergii Pogodin
 */
@Controller
public class ProductsController {
    @Autowired
    private DaoService daoService;

    @RequestMapping("*")
    public ModelAndView showProducts() {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("groups", daoService.findAllGroups());

        ArrayList<Product> prs = new ArrayList<Product>();
        prs.add(new Product("hz", new BigDecimal(3.4)));
        model.put("products", prs);

        return new ModelAndView("products", model);
    }
}
