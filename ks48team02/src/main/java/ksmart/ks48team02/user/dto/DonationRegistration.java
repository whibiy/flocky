package ksmart.ks48team02.user.dto;

import org.thymeleaf.spring6.processor.SpringObjectTagProcessor;

public class DonationRegistration {
    private String donationCode;
    private String storeCode;
    private String memberId;
    private String donationJudgementReasonCode;
    private String adminMemberId;
    private String totalCategoryCode;
    private String donationSubject;
    private String donationLike;
    private String donationContents;
    private String donationImage;
    private String donationRegDate;
    private String donationStartDate;
    private String donationEndDate;
    private int donationAchievementMoney;
    private int donationGoalMoney;
    private int donationAchievementPercent;
    private String donationJudgmentReasonDetail;
    private String donationJudgementDate;
    private int searchCount;
    private int donationCondition;

    private String storeName;
    private String categoryName;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DonationRegistration{");
        sb.append("donationCode='").append(donationCode).append('\'');
        sb.append(", storeCode='").append(storeCode).append('\'');
        sb.append(", memberId='").append(memberId).append('\'');
        sb.append(", donationJudgementReasonCode='").append(donationJudgementReasonCode).append('\'');
        sb.append(", adminMemberId='").append(adminMemberId).append('\'');
        sb.append(", totalCategoryCode='").append(totalCategoryCode).append('\'');
        sb.append(", donationSubject='").append(donationSubject).append('\'');
        sb.append(", donationLike='").append(donationLike).append('\'');
        sb.append(", donationContents='").append(donationContents).append('\'');
        sb.append(", donationImage='").append(donationImage).append('\'');
        sb.append(", donationRegDate='").append(donationRegDate).append('\'');
        sb.append(", donationStartDate='").append(donationStartDate).append('\'');
        sb.append(", donationEndDate='").append(donationEndDate).append('\'');
        sb.append(", donationAchievementMoney=").append(donationAchievementMoney);
        sb.append(", donationGoalMoney=").append(donationGoalMoney);
        sb.append(", donationAchievementPercent=").append(donationAchievementPercent);
        sb.append(", donationJudgmentReasonDetail='").append(donationJudgmentReasonDetail).append('\'');
        sb.append(", donationJudgementDate='").append(donationJudgementDate).append('\'');
        sb.append(", searchCount=").append(searchCount);
        sb.append(", donationCondition=").append(donationCondition);
        sb.append('}');
        return sb.toString();
    }

    public String getDonationCode() {
        return donationCode;
    }

    public void setDonationCode(String donationCode) {
        this.donationCode = donationCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getDonationJudgementReasonCode() {
        return donationJudgementReasonCode;
    }

    public void setDonationJudgementReasonCode(String donationJudgementReasonCode) {
        this.donationJudgementReasonCode = donationJudgementReasonCode;
    }

    public String getAdminMemberId() {
        return adminMemberId;
    }

    public void setAdminMemberId(String adminMemberId) {
        this.adminMemberId = adminMemberId;
    }

    public String getTotalCategoryCode() {
        return totalCategoryCode;
    }

    public void setTotalCategoryCode(String totalCategoryCode) {
        this.totalCategoryCode = totalCategoryCode;
    }

    public String getDonationSubject() {
        return donationSubject;
    }

    public void setDonationSubject(String donationSubject) {
        this.donationSubject = donationSubject;
    }

    public String getDonationLike() {
        return donationLike;
    }

    public void setDonationLike(String donationLike) {
        this.donationLike = donationLike;
    }

    public String getDonationContents() {
        return donationContents;
    }

    public void setDonationContents(String donationContents) {
        this.donationContents = donationContents;
    }

    public String getDonationImage() {
        return donationImage;
    }

    public void setDonationImage(String donationImage) {
        this.donationImage = donationImage;
    }

    public String getDonationRegDate() {
        return donationRegDate;
    }

    public void setDonationRegDate(String donationRegDate) {
        this.donationRegDate = donationRegDate;
    }

    public String getDonationStartDate() {
        return donationStartDate;
    }

    public void setDonationStartDate(String donationStartDate) {
        this.donationStartDate = donationStartDate;
    }

    public String getDonationEndDate() {
        return donationEndDate;
    }

    public void setDonationEndDate(String donationEndDate) {
        this.donationEndDate = donationEndDate;
    }

    public int getDonationAchievementMoney() {
        return donationAchievementMoney;
    }

    public void setDonationAchievementMoney(int donationAchievementMoney) {
        this.donationAchievementMoney = donationAchievementMoney;
    }

    public int getDonationGoalMoney() {
        return donationGoalMoney;
    }

    public void setDonationGoalMoney(int donationGoalMoney) {
        this.donationGoalMoney = donationGoalMoney;
    }

    public int getDonationAchievementPercent() {
        return donationAchievementPercent;
    }

    public void setDonationAchievementPercent(int donationAchievementPercent) {
        this.donationAchievementPercent = donationAchievementPercent;
    }

    public String getDonationJudgmentReasonDetail() {
        return donationJudgmentReasonDetail;
    }

    public void setDonationJudgmentReasonDetail(String donationJudgmentReasonDetail) {
        this.donationJudgmentReasonDetail = donationJudgmentReasonDetail;
    }

    public String getDonationJudgementDate() {
        return donationJudgementDate;
    }

    public void setDonationJudgementDate(String donationJudgementDate) {
        this.donationJudgementDate = donationJudgementDate;
    }

    public int getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }

    public int getDonationCondition() {
        return donationCondition;
    }

    public void setDonationCondition(int donationCondition) {
        this.donationCondition = donationCondition;
    }
}
