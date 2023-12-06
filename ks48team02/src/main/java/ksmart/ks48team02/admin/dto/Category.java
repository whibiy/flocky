package ksmart.ks48team02.admin.dto;

public class Category {

    private String totalCategoryCode;
    private String memberId;
    private String projectPatition;
    private String categoryName;
    private String categoryComment;
    private int categoryUsageStatus;
    private String categoryRegDate;


    @Override
    public String toString() {
        return "Category{" +
                "totalCategoryCode='" + totalCategoryCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", projectPatition='" + projectPatition + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", categoryComment='" + categoryComment + '\'' +
                ", categoryUsageStatus=" + categoryUsageStatus +
                ", categoryRegDate='" + categoryRegDate + '\'' +
                '}';
    }

    public String getTotalCategoryCode() {
        return totalCategoryCode;
    }

    public Category setTotalCategoryCode(String totalCategoryCode) {
        this.totalCategoryCode = totalCategoryCode;
        return this;
    }

    public String getMemberId() {
        return memberId;
    }

    public Category setMemberId(String memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getProjectPatition() {
        return projectPatition;
    }

    public Category setProjectPatition(String projectPatition) {
        this.projectPatition = projectPatition;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Category setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public String getCategoryComment() {
        return categoryComment;
    }

    public Category setCategoryComment(String categoryComment) {
        this.categoryComment = categoryComment;
        return this;
    }

    public int getCategoryUsageStatus() {
        return categoryUsageStatus;
    }

    public Category setCategoryUsageStatus(int categoryUsageStatus) {
        this.categoryUsageStatus = categoryUsageStatus;
        return this;
    }

    public String getCategoryRegDate() {
        return categoryRegDate;
    }

    public Category setCategoryRegDate(String categoryRegDate) {
        this.categoryRegDate = categoryRegDate;
        return this;
    }

}
