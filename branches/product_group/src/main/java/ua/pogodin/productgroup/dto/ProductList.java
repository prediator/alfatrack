package ua.pogodin.productgroup.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergii Pogodin
 */
public class ProductList {
    private int pages = 1;
    private int currentPage = 1;
    private String sorting;
    private boolean asc = true;
    private List<Product> list = new ArrayList<Product>();

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getSorting() {
        return sorting;
    }

    public void setSorting(String sorting) {
        this.sorting = sorting;
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
