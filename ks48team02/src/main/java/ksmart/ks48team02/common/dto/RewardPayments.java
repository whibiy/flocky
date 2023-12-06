package ksmart.ks48team02.common.dto;

public class RewardPayments {
    private String paymentCode;
    private String orderCode;
    private String memberId;
    private String rewardRefundCode;
    private String switchingCode;
    private int orderPrice;
    private int deliveryPrice;
    private int orderTotalPrice;
    private int useReservePrice;
    private String useReserveCode;
    private int discountRankPrice;
    private String discountCouponPrice;
    private int paymentScheduledPrice;
    private String paymentMethod;
    private String depositName;
    private String depositAccount;
    private String refundAccount;
    private int depositPrice;
    private String paymentState;
    private String paymentDeadlineDate;
    private String paymentCompletedDate;

    @Override
    public String toString() {
        return "RewardPayments{" +
                "paymentCode='" + paymentCode + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", rewardRefundCode='" + rewardRefundCode + '\'' +
                ", switchingCode='" + switchingCode + '\'' +
                ", orderPrice=" + orderPrice +
                ", deliveryPrice=" + deliveryPrice +
                ", orderTotalPrice=" + orderTotalPrice +
                ", useReservePrice=" + useReservePrice +
                ", useReserveCode='" + useReserveCode + '\'' +
                ", discountRankPrice=" + discountRankPrice +
                ", discountCouponPrice='" + discountCouponPrice + '\'' +
                ", paymentScheduledPrice=" + paymentScheduledPrice +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", depositName='" + depositName + '\'' +
                ", depositAccount='" + depositAccount + '\'' +
                ", refundAccount='" + refundAccount + '\'' +
                ", depositPrice=" + depositPrice +
                ", paymentState='" + paymentState + '\'' +
                ", paymentDeadlineDate='" + paymentDeadlineDate + '\'' +
                ", paymentCompletedDate='" + paymentCompletedDate + '\'' +
                '}';
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getRewardRefundCode() {
        return rewardRefundCode;
    }

    public void setRewardRefundCode(String rewardRefundCode) {
        this.rewardRefundCode = rewardRefundCode;
    }

    public String getSwitchingCode() {
        return switchingCode;
    }

    public void setSwitchingCode(String switchingCode) {
        this.switchingCode = switchingCode;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(int deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public int getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(int orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public int getUseReservePrice() {
        return useReservePrice;
    }

    public void setUseReservePrice(int useReservePrice) {
        this.useReservePrice = useReservePrice;
    }

    public String getUseReserveCode() {
        return useReserveCode;
    }

    public void setUseReserveCode(String useReserveCode) {
        this.useReserveCode = useReserveCode;
    }

    public int getDiscountRankPrice() {
        return discountRankPrice;
    }

    public void setDiscountRankPrice(int discountRankPrice) {
        this.discountRankPrice = discountRankPrice;
    }

    public String getDiscountCouponPrice() {
        return discountCouponPrice;
    }

    public void setDiscountCouponPrice(String discountCouponPrice) {
        this.discountCouponPrice = discountCouponPrice;
    }

    public int getPaymentScheduledPrice() {
        return paymentScheduledPrice;
    }

    public void setPaymentScheduledPrice(int paymentScheduledPrice) {
        this.paymentScheduledPrice = paymentScheduledPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDepositName() {
        return depositName;
    }

    public void setDepositName(String depositName) {
        this.depositName = depositName;
    }

    public String getDepositAccount() {
        return depositAccount;
    }

    public void setDepositAccount(String depositAccount) {
        this.depositAccount = depositAccount;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public void setRefundAccount(String refundAccount) {
        this.refundAccount = refundAccount;
    }

    public int getDepositPrice() {
        return depositPrice;
    }

    public void setDepositPrice(int depositPrice) {
        this.depositPrice = depositPrice;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    public String getPaymentDeadlineDate() {
        return paymentDeadlineDate;
    }

    public void setPaymentDeadlineDate(String paymentDeadlineDate) {
        this.paymentDeadlineDate = paymentDeadlineDate;
    }

    public String getPaymentCompletedDate() {
        return paymentCompletedDate;
    }

    public void setPaymentCompletedDate(String paymentCompletedDate) {
        this.paymentCompletedDate = paymentCompletedDate;
    }
}
