package ua.pogodin.productgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.pogodin.productgroup.dao.DaoService;
import ua.pogodin.productgroup.dto.Group;
import ua.pogodin.productgroup.dto.Product;
import ua.pogodin.productgroup.dto.ProductList;
import ua.pogodin.productgroup.dto.Sort;

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
        ProductList productList = getProductList(groups, groupId, currentPage, sortColumn, asc);
        Sort sort = getSort(sortColumn, asc);

        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("groups", groups);
        model.put("productList", productList);
        model.put("sort", sort);
        return new ModelAndView("products", model);
    }

    private ProductList getProductList(List<Group> groups, long groupId, int currentPage, String sortColumn, boolean asc) {
        ProductList productList = new ProductList();
        productList.setList(getProductListFromDaoService(groupId, currentPage, sortColumn, asc));

        fillParams(productList, groupId, sortColumn, asc);
        fillPagerParams(productList, groupId, groups, currentPage);
        return productList;
    }

    private List<Product> getProductListFromDaoService(long groupId, int currentPage, String sortColumn, boolean asc) {
        int from = PRODUCTS_PER_PAGE * (currentPage - 1);
        int to = PRODUCTS_PER_PAGE * currentPage;

        return (sortColumn != null)
                ? daoService.findProductsByGroupId(groupId, from, to, sortColumn, asc)
                : daoService.findProductsByGroupId(groupId, from, to);
    }

    private void fillParams(ProductList productList, long groupId, String sortColumn, boolean asc) {
        productList.setGroupId(groupId);
        productList.setSortColumn(sortColumn);
        productList.setAsc(asc);
    }

    private void fillPagerParams(ProductList productList, long groupId, List<Group> groups, int currentPage) {
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

    private Sort getSort(String sortColumn, boolean asc) {
        Sort sort = new Sort();
        if ("name".equals(sortColumn)) {
            sort.setNameUrlSuffix(asc ? Sort.NAME_DESC_URL_SUFFIX : Sort.NAME_ASC_URL_SUFFIX);
            sort.setNameSign(asc ? Sort.SIGN_ASC : Sort.SIGN_DESC);
        } else if ("price".equals(sortColumn)) {
            sort.setPriceUrlSuffix(asc ? Sort.PRICE_DESC_URL_SUFFIX : Sort.PRICE_ASC_URL_SUFFIX);
            sort.setPriceSign(asc ? Sort.SIGN_ASC : Sort.SIGN_DESC);
        }
        return sort;
    }
}
