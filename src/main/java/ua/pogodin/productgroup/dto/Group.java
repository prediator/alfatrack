package ua.pogodin.productgroup.dto;

/**
 * @author Sergii Pogodin
 */
public class Group {
    private long groupId;
    private String name;
    private int productCount;

    public Group(long groupId, String name, int productCount) {
        this.groupId = groupId;
        this.name = name;
        this.productCount = productCount;
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

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}
