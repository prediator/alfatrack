package ua.pogodin.productgroup.dto;

/**
 * @author Sergii Pogodin
 */
public class Group {
    private long groupId;
    private String name;
    private int productsCount;

    public Group(long groupId, String name, int productsCount) {
        this.groupId = groupId;
        this.name = name;
        this.productsCount = productsCount;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }
}
