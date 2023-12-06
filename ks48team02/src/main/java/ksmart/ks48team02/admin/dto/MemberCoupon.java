package ksmart.ks48team02.admin.dto;

public class MemberCoupon {

    private String couponIssueCode;
    private String couponMemberId;
    private String couponCode;
    private String couponRegDate;
    private String couponEndDate;
    private String couponUsed;

    @Override
    public String toString() {
        return "MemberCoupon{" +
                "couponIssueCode='" + couponIssueCode + '\'' +
                ", couponMemberId='" + couponMemberId + '\'' +
                ", couponCode='" + couponCode + '\'' +
                ", couponRegDate='" + couponRegDate + '\'' +
                ", couponEndDate='" + couponEndDate + '\'' +
                ", couponUsed='" + couponUsed + '\'' +
                '}';
    }

    public String getCouponIssueCode() {
        return couponIssueCode;
    }

    public void setCouponIssueCode(String couponIssueCode) {
        this.couponIssueCode = couponIssueCode;
    }

    public String getCouponMemberId() {
        return couponMemberId;
    }

    public void setCouponMemberId(String couponMemberId) {
        this.couponMemberId = couponMemberId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponRegDate() {
        return couponRegDate;
    }

    public void setCouponRegDate(String couponRegDate) {
        this.couponRegDate = couponRegDate;
    }

    public String getCouponEndDate() {
        return couponEndDate;
    }

    public void setCouponEndDate(String couponEndDate) {
        this.couponEndDate = couponEndDate;
    }

    public String getCouponUsed() {
        return couponUsed;
    }

    public void setCouponUsed(String couponUsed) {
        this.couponUsed = couponUsed;
    }
}
