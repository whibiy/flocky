package ksmart.ks48team02.user.dto;



import ksmart.ks48team02.admin.dto.MemberCoupon;
import ksmart.ks48team02.admin.dto.Coupon;
import ksmart.ks48team02.user.dto.RewardCustomerRank;
import java.util.List;

public class Member {

    private String memberId;
    private String memberTypeCode;
    private String memberName;
    private String memberPw;
    private String memberRegDate;
    private String memberEmail;
    private String memberContactInfo;
    private String unRegDate;
    private String unRegStatus;
    private RewardCustomerRank rewardCustomerRank;
    private Customer customer;

    private List<Coupon> couponList;
    private List<MemberCoupon> memberCouponList;



    // member_type
    private String memberType;
    private String memberTypeDetail;

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberTypeDetail() {
        return memberTypeDetail;
    }

    public void setMemberTypeDetail(String memberTypeDetail) {
        this.memberTypeDetail = memberTypeDetail;
    }







    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", memberTypeCode='" + memberTypeCode + '\'' +
                ", memberTypeDetail='" + memberTypeDetail + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberPw='" + memberPw + '\'' +
                ", memberRegDate='" + memberRegDate + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberContactInfo='" + memberContactInfo + '\'' +
                ", unRegDate='" + unRegDate + '\'' +
                ", unRegStatus='" + unRegStatus + '\'' +
                ", rewardCustomerRank=" + rewardCustomerRank +
                ", customer=" + customer +
                ", couponList=" + couponList +
                ", memberCouponList=" + memberCouponList +

                '}';
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    public List<MemberCoupon> getMemberCouponList() {
        return memberCouponList;
    }

    public void setMemberCouponList(List<MemberCoupon> memberCouponList) {
        this.memberCouponList = memberCouponList;
    }

    public RewardCustomerRank getRewardCustomerRank() {
        return rewardCustomerRank;
    }

    public void setRewardCustomerRank(RewardCustomerRank rewardCustomerRank) {
        this.rewardCustomerRank = rewardCustomerRank;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberTypeCode() {
        return memberTypeCode;
    }

    public void setMemberTypeCode(String memberTypeCode) {
        this.memberTypeCode = memberTypeCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberRegDate() {
        return memberRegDate;
    }

    public void setMemberRegDate(String memberRegDate) {
        this.memberRegDate = memberRegDate;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberContactInfo() {
        return memberContactInfo;
    }

    public void setMemberContactInfo(String memberContactInfo) {
        this.memberContactInfo = memberContactInfo;
    }

    public String getUnRegDate() {
        return unRegDate;
    }

    public void setUnRegDate(String unRegDate) {
        this.unRegDate = unRegDate;
    }

    public String getUnRegStatus() {
        return unRegStatus;
    }

    public void setUnRegStatus(String unRegStatus) {
        this.unRegStatus = unRegStatus;
    }
}
