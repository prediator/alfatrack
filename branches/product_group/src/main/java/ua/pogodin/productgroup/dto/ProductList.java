package ua.pogodin.productgroup.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergii Pogodin
 */
public class ProductList {
    private int pageCount = 1;
    private int currentPage = 1;
    private String sortColumn;
    private boolean asc = true;
    private List<Product> list = new ArrayList<Product>();

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }

    public List<Product> getList() {
        return list;
    }

    public void addProduct(Product product) {
        list.add(product);
    }

    public void addProducts(List<Product> products) {
        list.addAll(products);
    }
}
