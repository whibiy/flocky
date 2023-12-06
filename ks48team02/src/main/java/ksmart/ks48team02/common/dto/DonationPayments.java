package ksmart.ks48team02.common.dto;

public class DonationPayments {
    private String paymentCode;
    private String orderCode;
    private int donationGoods;
    private int donationPrice;
    private String donationName;
    private String donationSecurityNumber;

    @Override
    public String toString() {
        return "DonationPayments{" +
                "paymentCode='" + paymentCode + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", donationGoods=" + donationGoods +
                ", donationPrice=" + donationPrice +
                ", donationName='" + donationName + '\'' +
                ", donationSecurityNumber='" + donationSecurityNumber + '\'' +
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

    public int getDonationGoods() {
        return donationGoods;
    }

    public void setDonationGoods(int donationGoods) {
        this.donationGoods = donationGoods;
    }

    public int getDonationPrice() {
        return donationPrice;
    }

    public void setDonationPrice(int donationPrice) {
        this.donationPrice = donationPrice;
    }

    public String getDonationName() {
        return donationName;
    }

    public void setDonationName(String donationName) {
        this.donationName = donationName;
    }

    public String getDonationSecurityNumber() {
        return donationSecurityNumber;
    }

    public void setDonationSecurityNumber(String securityNumber) {
        this.donationSecurityNumber = securityNumber;
    }
}
