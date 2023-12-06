package ksmart.ks48team02.admin.dto;

import ksmart.ks48team02.seller.dto.SellerInvestmentContent;
import ksmart.ks48team02.seller.dto.SellersecuritiesIssuanceStock;

public class AdminInvestment {

    private String investmentCode;
    private String memberId;
    private String storeCode;
    private String investmentRequestJudgeCode;
    private String totalCategoryCode;
    private String memberIdSeller;
    private String investmentSubject;
    private String investmentContent;
    private String investmentImage;
    private int investmentLike;
    private long investmentAmount;
    private long invInvestmentAchievementMoney;
    private int investAchievementPercent;
    private String investmentCompany;
    private int searchCount;
    private int investCount;
    private String securitiesClassification;
    private String investmentDisplayDate;
    private String investmentRegDate;
    private String investmentDeadline;
    private String investmentReport;
    private int basicFee;
    private float contractFeeRate;
    private String contractFile;
    private int investJudgeSituation;

    private AdminInvestmentRequestJudge adminInvestmentRequestJudge;

    private SellerInvestmentContent sellerInvestmentContent;

    private SellersecuritiesIssuanceStock sellersecuritiesIssuanceStock;

    public SellersecuritiesIssuanceStock getSellersecuritiesIssuanceStock() {
        return sellersecuritiesIssuanceStock;
    }

    public void setSellersecuritiesIssuanceStock(SellersecuritiesIssuanceStock sellersecuritiesIssuanceStock) {
        this.sellersecuritiesIssuanceStock = sellersecuritiesIssuanceStock;
    }

    public String getInvestmentCode() {
        return investmentCode;
    }

    public void setInvestmentCode(String investmentCode) {
        this.investmentCode = investmentCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getInvestmentRequestJudgeCode() {
        return investmentRequestJudgeCode;
    }

    public void setInvestmentRequestJudgeCode(String investmentRequestJudgeCode) {
        this.investmentRequestJudgeCode = investmentRequestJudgeCode;
    }

    public String getTotalCategoryCode() {
        return totalCategoryCode;
    }

    public void setTotalCategoryCode(String totalCategoryCode) {
        this.totalCategoryCode = totalCategoryCode;
    }

    public String getMemberIdSeller() {
        return memberIdSeller;
    }

    public void setMemberIdSeller(String memberIdSeller) {
        this.memberIdSeller = memberIdSeller;
    }

    public String getInvestmentSubject() {
        return investmentSubject;
    }

    public void setInvestmentSubject(String investmentSubject) {
        this.investmentSubject = investmentSubject;
    }

    public String getInvestmentContent() {
        return investmentContent;
    }

    public void setInvestmentContent(String investmentContent) {
        this.investmentContent = investmentContent;
    }

    public String getInvestmentImage() {
        return investmentImage;
    }

    public void setInvestmentImage(String investmentImage) {
        this.investmentImage = investmentImage;
    }

    public int getInvestmentLike() {
        return investmentLike;
    }

    public void setInvestmentLike(int investmentLike) {
        this.investmentLike = investmentLike;
    }

    public long getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(long investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public long getInvInvestmentAchievementMoney() {
        return invInvestmentAchievementMoney;
    }

    public void setInvInvestmentAchievementMoney(long invInvestmentAchievementMoney) {
        this.invInvestmentAchievementMoney = invInvestmentAchievementMoney;
    }

    public int getInvestAchievementPercent() {
        return investAchievementPercent;
    }

    public void setInvestAchievementPercent(int investAchievementPercent) {
        this.investAchievementPercent = investAchievementPercent;
    }

    public String getInvestmentCompany() {
        return investmentCompany;
    }

    public void setInvestmentCompany(String investmentCompany) {
        this.investmentCompany = investmentCompany;
    }

    public int getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }

    public int getInvestCount() {
        return investCount;
    }

    public void setInvestCount(int investCount) {
        this.investCount = investCount;
    }

    public String getSecuritiesClassification() {
        return securitiesClassification;
    }

    public void setSecuritiesClassification(String securitiesClassification) {
        this.securitiesClassification = securitiesClassification;
    }

    public String getInvestmentDisplayDate() {
        return investmentDisplayDate;
    }

    public void setInvestmentDisplayDate(String investmentDisplayDate) {
        this.investmentDisplayDate = investmentDisplayDate;
    }

    public String getInvestmentRegDate() {
        return investmentRegDate;
    }

    public void setInvestmentRegDate(String investmentRegDate) {
        this.investmentRegDate = investmentRegDate;
    }

    public String getInvestmentDeadline() {
        return investmentDeadline;
    }

    public void setInvestmentDeadline(String investmentDeadline) {
        this.investmentDeadline = investmentDeadline;
    }

    public String getInvestmentReport() {
        return investmentReport;
    }

    public void setInvestmentReport(String investmentReport) {
        this.investmentReport = investmentReport;
    }

    public int getBasicFee() {
        return basicFee;
    }

    public void setBasicFee(int basicFee) {
        this.basicFee = basicFee;
    }

    public float getContractFeeRate() {
        return contractFeeRate;
    }

    public void setContractFeeRate(float contractFeeRate) {
        this.contractFeeRate = contractFeeRate;
    }

    public String getContractFile() {
        return contractFile;
    }

    public void setContractFile(String contractFile) {
        this.contractFile = contractFile;
    }

    public int getInvestJudgeSituation() {
        return investJudgeSituation;
    }

    public void setInvestJudgeSituation(int investJudgeSituation) {
        this.investJudgeSituation = investJudgeSituation;
    }

    public AdminInvestmentRequestJudge getAdminInvestmentRequestJudge() {
        return adminInvestmentRequestJudge;
    }

    public void setAdminInvestmentRequestJudge(AdminInvestmentRequestJudge adminInvestmentRequestJudge) {
        this.adminInvestmentRequestJudge = adminInvestmentRequestJudge;
    }

    public SellerInvestmentContent getSellerInvestmentContent() {
        return sellerInvestmentContent;
    }

    public void setSellerInvestmentContent(SellerInvestmentContent sellerInvestmentContent) {
        this.sellerInvestmentContent = sellerInvestmentContent;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AdminInvestment{");
        sb.append("investmentCode='").append(investmentCode).append('\'');
        sb.append(", memberId='").append(memberId).append('\'');
        sb.append(", storeCode='").append(storeCode).append('\'');
        sb.append(", investmentRequestJudgeCode='").append(investmentRequestJudgeCode).append('\'');
        sb.append(", totalCategoryCode='").append(totalCategoryCode).append('\'');
        sb.append(", memberIdSeller='").append(memberIdSeller).append('\'');
        sb.append(", investmentSubject='").append(investmentSubject).append('\'');
        sb.append(", investmentContent='").append(investmentContent).append('\'');
        sb.append(", investmentImage='").append(investmentImage).append('\'');
        sb.append(", investmentLike=").append(investmentLike);
        sb.append(", investmentAmount=").append(investmentAmount);
        sb.append(", invInvestmentAchievementMoney=").append(invInvestmentAchievementMoney);
        sb.append(", investAchievementPercent=").append(investAchievementPercent);
        sb.append(", investmentCompany='").append(investmentCompany).append('\'');
        sb.append(", searchCount=").append(searchCount);
        sb.append(", investCount=").append(investCount);
        sb.append(", securitiesClassification='").append(securitiesClassification).append('\'');
        sb.append(", investmentDisplayDate='").append(investmentDisplayDate).append('\'');
        sb.append(", investmentRegDate='").append(investmentRegDate).append('\'');
        sb.append(", investmentDeadline='").append(investmentDeadline).append('\'');
        sb.append(", investmentReport='").append(investmentReport).append('\'');
        sb.append(", basicFee=").append(basicFee);
        sb.append(", contractFeeRate=").append(contractFeeRate);
        sb.append(", contractFile='").append(contractFile).append('\'');
        sb.append(", investJudgeSituation=").append(investJudgeSituation);
        sb.append(", adminInvestmentRequestJudge=").append(adminInvestmentRequestJudge);
        sb.append(", sellerInvestmentContent=").append(sellerInvestmentContent);
        sb.append(", sellersecuritiesIssuanceStock=").append(sellersecuritiesIssuanceStock);
        sb.append('}');
        return sb.toString();
    }

}