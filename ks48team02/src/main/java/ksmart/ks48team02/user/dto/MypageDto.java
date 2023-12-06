package ksmart.ks48team02.user.dto;

import ksmart.ks48team02.admin.dto.Coupon;
import ksmart.ks48team02.admin.dto.MemberCoupon;
import lombok.Data;

import java.util.List;

@Data
public class MypageDto {

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

    private String profileCode;
    private int rewardGreatCount;
    private int donationGreatCount;
    private int investmentGreatCount;
    private int follower;
    private int following;
    private String profileImage;
    private String memberCompany;
    private String memberSchool;
    private String memberIntroduction;
}
