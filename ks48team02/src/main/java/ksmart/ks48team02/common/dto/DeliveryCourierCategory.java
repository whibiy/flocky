package ksmart.ks48team02.common.dto;

public class DeliveryCourierCategory {
    private String deliveryCategoryCode;
    private String memberId;
    private String deliveryCourierName;
    private String addDate;
    private int categoryStatus;

    @Override
    public String toString() {
        return "DeliveryCourierCategory{" +
                "deliveryCategoryCode='" + deliveryCategoryCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", deliveryCourierName='" + deliveryCourierName + '\'' +
                ", addDate='" + addDate + '\'' +
                ", categoryStatus=" + categoryStatus +
                '}';
    }

    public String getDeliveryCategoryCode() {
        return deliveryCategoryCode;
    }

    public void setDeliveryCategoryCode(String deliveryCategoryCode) {
        this.deliveryCategoryCode = deliveryCategoryCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getDeliveryCourierName() {
        return deliveryCourierName;
    }

    public void setDeliveryCourierName(String deliveryCourierName) {
        this.deliveryCourierName = deliveryCourierName;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public int getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(int categoryStatus) {
        this.categoryStatus = categoryStatus;
    }
}
