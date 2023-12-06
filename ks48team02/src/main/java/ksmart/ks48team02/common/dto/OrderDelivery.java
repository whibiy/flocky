package ksmart.ks48team02.common.dto;

public class OrderDelivery {

    private String orderDeliveryCode;
    private String orderCode;
    private String deliveryCategoryCode;
    private String switchingCode;
    private String rewardRefundCode;
    private String deliveryCategory;
    private String memberId;
    private String deliveryName;
    private String deliveryPhone;
    private String deliveryAddress;
    private String deliveryMessageCode;
    private String deliveryMessage;
    private String numberInvoice;
    private String deliveryCourier;
    private String deliveryState;
    private String deliveryStartDate;
    private String deliveryEndDate;


    private String dueDateArrival;


    @Override
    public String toString() {
        return "OrderDelivery{" +
                "orderDeliveryCode='" + orderDeliveryCode + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", deliveryCategoryCode='" + deliveryCategoryCode + '\'' +
                ", switchingCode='" + switchingCode + '\'' +
                ", rewardRefundCode='" + rewardRefundCode + '\'' +
                ", deliveryCategory='" + deliveryCategory + '\'' +
                ", memberId='" + memberId + '\'' +
                ", deliveryName='" + deliveryName + '\'' +
                ", deliveryPhone='" + deliveryPhone + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", deliveryMessageCode='" + deliveryMessageCode + '\'' +
                ", deliveryMessage='" + deliveryMessage + '\'' +
                ", numberInvoice='" + numberInvoice + '\'' +
                ", deliveryCourier='" + deliveryCourier + '\'' +
                ", deliveryState='" + deliveryState + '\'' +
                ", deliveryStartDate='" + deliveryStartDate + '\'' +
                ", deliveryEndDate='" + deliveryEndDate + '\'' +
                ", dueDateArrival='" + dueDateArrival + '\'' +
                '}';
    }

    public String getOrderDeliveryCode() {
        return orderDeliveryCode;
    }

    public void setOrderDeliveryCode(String orderDeliveryCode) {
        this.orderDeliveryCode = orderDeliveryCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getDeliveryCategoryCode() {
        return deliveryCategoryCode;
    }

    public void setDeliveryCategoryCode(String deliveryCategoryCode) {
        this.deliveryCategoryCode = deliveryCategoryCode;
    }

    public String getSwitchingCode() {
        return switchingCode;
    }

    public void setSwitchingCode(String switchingCode) {
        this.switchingCode = switchingCode;
    }

    public String getRewardRefundCode() {
        return rewardRefundCode;
    }

    public void setRewardRefundCode(String rewardRefundCode) {
        this.rewardRefundCode = rewardRefundCode;
    }

    public String getDeliveryCategory() {
        return deliveryCategory;
    }

    public void setDeliveryCategory(String deliveryCategory) {
        this.deliveryCategory = deliveryCategory;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getDeliveryPhone() {
        return deliveryPhone;
    }

    public void setDeliveryPhone(String deliveryPhone) {
        this.deliveryPhone = deliveryPhone;
    }

    public String getDeliveryMessageCode() {
        return deliveryMessageCode;
    }

    public void setDeliveryMessageCode(String deliveryMessageCode) {
        this.deliveryMessageCode = deliveryMessageCode;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryMessage() {
        return deliveryMessage;
    }

    public void setDeliveryMessage(String deliveryMessage) {
        this.deliveryMessage = deliveryMessage;
    }

    public String getNumberInvoice() {
        return numberInvoice;
    }

    public void setNumberInvoice(String numberInvoice) {
        this.numberInvoice = numberInvoice;
    }

    public String getDeliveryCourier() {
        return deliveryCourier;
    }

    public void setDeliveryCourier(String deliveryCourier) {
        this.deliveryCourier = deliveryCourier;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState;
    }

    public String getDeliveryStartDate() {
        return deliveryStartDate;
    }

    public void setDeliveryStartDate(String deliveryStartDate) {
        this.deliveryStartDate = deliveryStartDate;
    }

    public String getDeliveryEndDate() {
        return deliveryEndDate;
    }

    public void setDeliveryEndDate(String deliveryEndDate) {
        this.deliveryEndDate = deliveryEndDate;
    }

    public String getDueDateArrival() {
        return dueDateArrival;
    }

    public void setDueDateArrival(String dueDateArrival) {
        this.dueDateArrival = dueDateArrival;
    }

}
