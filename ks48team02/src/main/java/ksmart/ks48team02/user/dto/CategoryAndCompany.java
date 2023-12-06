package ksmart.ks48team02.user.dto;

public class CategoryAndCompany {
    private String categoryName;
    private String storeName;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CategoryAndCompany{");
        sb.append("categoryName='").append(categoryName).append('\'');
        sb.append(", storeName='").append(storeName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
