package ksmart.ks48team02.admin.dto;

public class Coupon {
    private String couponCode;
    private String couponSerialNumber;
    private String memberId;
    private String couponName;
    private int couponDiscountRate;
    private int couponDiscountAmount;
    private int couponStock;
    private int numberCouponsRemaining;
    private int couponValidPeriod;
    private String couponTermsUse;

    private MemberCoupon memberCoupon;

    @Override
    public String toString() {
        return "Coupon{" +
                "couponCode='" + couponCode + '\'' +
                ", couponSerialNumber='" + couponSerialNumber + '\'' +
                ", memberId='" + memberId + '\'' +
                ", couponName='" + couponName + '\'' +
                ", couponDiscountRate=" + couponDiscountRate +
                ", couponDiscountAmount=" + couponDiscountAmount +
                ", couponStock=" + couponStock +
                ", numberCouponsRemaining=" + numberCouponsRemaining +
                ", couponValidPeriod=" + couponValidPeriod +
                ", couponTermsUse='" + couponTermsUse + '\'' +
                ", memberCoupon=" + memberCoupon +
                '}';
    }

    public MemberCoupon getMemberCoupon() {
        return memberCoupon;
    }

    public void setMemberCoupon(MemberCoupon memberCoupon) {
        this.memberCoupon = memberCoupon;
    }


    public String getCouponCode() {
        return couponCode;
    }

    public Coupon setCouponCode(String couponCode) {
        this.couponCode = couponCode;
        return this;
    }

    public String getCouponSerialNumber() {
        return couponSerialNumber;
    }

    public Coupon setCouponSerialNumber(String couponSerialNumber) {
        this.couponSerialNumber = couponSerialNumber;
        return this;
    }

    public String getCouponName() {
        return couponName;
    }

    public Coupon setCouponName(String couponName) {
        this.couponName = couponName;
        return this;
    }

    public int getCouponDiscountRate() {
        return couponDiscountRate;
    }

    public Coupon setCouponDiscountRate(int couponDiscountRate) {
        this.couponDiscountRate = couponDiscountRate;
        return this;
    }

    public int getCouponDiscountAmount() {
        return couponDiscountAmount;
    }

    public Coupon setCouponDiscountAmount(int couponDiscountAmount) {
        this.couponDiscountAmount = couponDiscountAmount;
        return this;
    }

    public int getCouponStock() {
        return couponStock;
    }

    public Coupon setCouponStock(int couponStock) {
        this.couponStock = couponStock;
        return this;
    }

    public int getNumberCouponsRemaining() {
        return numberCouponsRemaining;
    }

    public Coupon setNumberCouponsRemaining(int numberCouponsRemaining) {
        this.numberCouponsRemaining = numberCouponsRemaining;
        return this;
    }

    public int getCouponValidPeriod() {
        return couponValidPeriod;
    }

    public Coupon setCouponValidPeriod(int couponValidPeriod) {
        this.couponValidPeriod = couponValidPeriod;
        return this;
    }

    public String getCouponTermsUse() {
        return couponTermsUse;
    }

    public Coupon setCouponTermsUse(String couponTermsUse) {
        this.couponTermsUse = couponTermsUse;
        return this;
    }

    public String getMemberId() {
        return memberId;
    }

    public Coupon setMemberId(String memberId) {
        this.memberId = memberId;
        return this;
    }

}
