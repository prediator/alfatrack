package ua.pogodin.productgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.pogodin.productgroup.dao.DaoService;
import ua.pogodin.productgroup.dto.Group;
import ua.pogodin.productgroup.dto.ProductList;

import java.util.HashMap;
import java.util.List;

/**
 * @author Sergii Pogodin
 */
@Controller
public class ProductsController {
    public static final int PRODUCTS_PER_PAGE = 10;
    @Autowired
    private DaoService daoService;

    @RequestMapping("*")
    public ModelAndView showProducts() {
        return new ModelAndView("products", "groups", daoService.findAllGroups());
    }

    @RequestMapping("products/{groupId}")
    public ModelAndView showProducts(@PathVariable("groupId") long groupId) {
        return showProducts(groupId, 1);
    }

    @RequestMapping("products/{groupId}/{currentPage}")
    public ModelAndView showProducts(@PathVariable("groupId") long groupId,
                                     @PathVariable("currentPage") int currentPage) {
        return showProducts(groupId, currentPage, null);

    }

    @RequestMapping("products/{groupId}/{currentPage}/{sortColumn}")
    public ModelAndView showProducts(@PathVariable("groupId") long groupId,
                                     @PathVariable("currentPage") int currentPage,
                                     @PathVariable("sortColumn") String sortColumn) {
        return showProducts(groupId, currentPage, sortColumn, true);
    }

    @RequestMapping("products/{groupId}/{currentPage}/{sortColumn}/{asc}")
    public ModelAndView showProducts(@PathVariable("groupId") long groupId,
                                     @PathVariable("currentPage") int currentPage,
                                     @PathVariable("sortColumn") String sortColumn,
                                     @PathVariable("asc") boolean asc) {
        List<Group> groups = daoService.findAllGroups();

        ProductList productList = getProductList(groupId, currentPage, sortColumn, asc);
        fillPagerParams(groupId, groups, productList, currentPage);

        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("groups", groups);
        model.put("productList", productList);
        return new ModelAndView("products", model);
    }

    private ProductList getProductList(long groupId, int currentPage, String sortColumn, boolean asc) {
        int from = PRODUCTS_PER_PAGE * (currentPage - 1);
        int to = PRODUCTS_PER_PAGE * currentPage;
        return (sortColumn != null)
                ? daoService.findProductsByGroupId(groupId, from, to, sortColumn, asc)
                : daoService.findProductsByGroupId(groupId, from, to);
    }

    private void fillPagerParams(long groupId, List<Group> groups, ProductList productList, int currentPage) {
        for (Group group : groups) {
            if (group.getGroupId() == groupId) {
                if (group.getProductCount() > PRODUCTS_PER_PAGE) {
                    productList.setPageCount((group.getProductCount() - 1) / PRODUCTS_PER_PAGE + 1);
                    productList.setCurrentPage(currentPage);
                }
                return;
            }
        }
    }
}
