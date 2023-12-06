package ksmart.ks48team02.user.dto;

public class Customer {

    private String customerCode;
    private String customerMemberId;
    private String rewardRankCode;
    private String donationRankCode;
    private String customerGender;
    private String customerBirth;
    private String customerAddr;
    private String customerAddrDetail;
    private int customerPoint;
    private int customerFlover;
    private int customerCoupon;

    @Override
    public String toString() {
        return "Customer{" +
                "customerCode='" + customerCode + '\'' +
                ", memberId='" + customerMemberId + '\'' +
                ", rewardRankCode='" + rewardRankCode + '\'' +
                ", donationRankCode='" + donationRankCode + '\'' +
                ", customerGender='" + customerGender + '\'' +
                ", customerBirth='" + customerBirth + '\'' +
                ", customerAddr='" + customerAddr + '\'' +
                ", customerAddrDetail='" + customerAddrDetail + '\'' +
                ", customerPoint=" + customerPoint +
                ", customerFlover=" + customerFlover +
                ", customerCoupon=" + customerCoupon +
                '}';
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getMemberId() {
        return customerMemberId;
    }

    public void setMemberId(String customerMemberId) {
        this.customerMemberId = customerMemberId;
    }

    public String getRewardRankCode() {
        return rewardRankCode;
    }

    public void setRewardRankCode(String rewardRankCode) {
        this.rewardRankCode = rewardRankCode;
    }

    public String getDonationRankCode() {
        return donationRankCode;
    }

    public void setDonationRankCode(String donationRankCode) {
        this.donationRankCode = donationRankCode;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerBirth() {
        return customerBirth;
    }

    public void setCustomerBirth(String customerBirth) {
        this.customerBirth = customerBirth;
    }

    public String getCustomerAddr() {
        return customerAddr;
    }

    public void setCustomerAddr(String customerAddr) {
        this.customerAddr = customerAddr;
    }

    public String getCustomerAddrDetail() {
        return customerAddrDetail;
    }

    public void setCustomerAddrDetail(String customerAddrDetail) {
        this.customerAddrDetail = customerAddrDetail;
    }

    public int getCustomerPoint() {
        return customerPoint;
    }

    public void setCustomerPoint(int customerPoint) {
        this.customerPoint = customerPoint;
    }

    public int getCustomerFlover() {
        return customerFlover;
    }

    public void setCustomerFlover(int customerFlover) {
        this.customerFlover = customerFlover;
    }

    public int getCustomerCoupon() {
        return customerCoupon;
    }

    public void setCustomerCoupon(int customerCoupon) {
        this.customerCoupon = customerCoupon;
    }
}
