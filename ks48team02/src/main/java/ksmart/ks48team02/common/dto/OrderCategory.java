package ksmart.ks48team02.common.dto;

public class OrderCategory {
    private String rdOrderDetailCode;
    private String memberId;
    private String orderCategoryDescription;
    private String orderCategoryDetail;

    @Override
    public String toString() {
        return "OrderCategory{" +
                "rdOrderDetailCode='" + rdOrderDetailCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", orderCategoryDescription='" + orderCategoryDescription + '\'' +
                ", orderCategoryDetail='" + orderCategoryDetail + '\'' +
                '}';
    }

    public String getRdOrderDetailCode() {
        return rdOrderDetailCode;
    }

    public void setRdOrderDetailCode(String rdOrderDetailCode) {
        this.rdOrderDetailCode = rdOrderDetailCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOrderCategoryDescription() {
        return orderCategoryDescription;
    }

    public void setOrderCategoryDescription(String orderCategoryDescription) {
        this.orderCategoryDescription = orderCategoryDescription;
    }

    public String getOrderCategoryDetail() {
        return orderCategoryDetail;
    }

    public void setOrderCategoryDetail(String orderCategoryDetail) {
        this.orderCategoryDetail = orderCategoryDetail;
    }
}
