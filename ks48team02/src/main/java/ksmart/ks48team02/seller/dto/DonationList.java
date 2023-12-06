package ksmart.ks48team02.seller.dto;

import lombok.Data;

@Data
public class DonationList {
    private String donationCode;
    private String memberId;
    private String donationCondition;
    private String donationSubject;
    private int donationAchievementMoney;
    private int donationAchievementPercent;
    private int donationGoalMoney;
    private String donationRegDate;
    private String donationEndDate;
    private String donationStartDate;
    private String donationJudgmentReasonDetail;
    private String adminMemberId;
}
