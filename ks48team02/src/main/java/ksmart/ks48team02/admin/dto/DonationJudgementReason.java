package ksmart.ks48team02.admin.dto;

public class DonationJudgementReason {
    private String donationJudgementReasonCode;
    private String adminMemberId;
    private String donationJudgementReason;
    private String judgementReasonRegDate;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DonationJudgementReason{");
        sb.append("donationJudgementReasonCode='").append(donationJudgementReasonCode).append('\'');
        sb.append(", adminMemberId='").append(adminMemberId).append('\'');
        sb.append(", donationJudgementReason='").append(donationJudgementReason).append('\'');
        sb.append(", judgementReasonRegDate='").append(judgementReasonRegDate).append('\'');
        sb.append('}');
        return sb.toString();
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

    public String getDonationJudgementReason() {
        return donationJudgementReason;
    }

    public void setDonationJudgementReason(String donationJudgementReason) {
        this.donationJudgementReason = donationJudgementReason;
    }

    public String getJudgementReasonRegDate() {
        return judgementReasonRegDate;
    }

    public void setJudgementReasonRegDate(String judgementReasonRegDate) {
        this.judgementReasonRegDate = judgementReasonRegDate;
    }
}
