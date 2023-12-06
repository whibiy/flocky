package ksmart.ks48team02.seller.dto;

public class SellerInvestmentContent {

    private String investmentContentCode;
    private String memberId;
    private String investmentCode;
    private String memberIdAdmin;
    private String projectIntroduction;
    private String investmentIntroductionImage;
    private String marketAnalysis;
    private String marketAnalysisImage;
    private String majorFinancialInformation;
    private String majorFinancialInformationImage;
    private String risk;
    private String riskImage;
    private String majorManpower;
    private String majorManpowerImage;
    private String patentAwardDetails;
    private String patentAwardDetailsImage;
    private String etcInvestContent;
    private String etcInvestContentImage;
    private String registrationDate;

    public String getInvestmentContentCode() {
        return investmentContentCode;
    }
    public void setInvestmentContentCode(String investmentContentCode) {
        this.investmentContentCode = investmentContentCode;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getInvestmentCode() {
        return investmentCode;
    }
    public void setInvestmentCode(String investmentCode) {
        this.investmentCode = investmentCode;
    }
    public String getMemberIdAdmin() {
        return memberIdAdmin;
    }
    public void setMemberIdAdmin(String memberIdAdmin) {
        this.memberIdAdmin = memberIdAdmin;
    }
    public String getProjectIntroduction() {
        return projectIntroduction;
    }
    public void setProjectIntroduction(String projectIntroduction) {
        this.projectIntroduction = projectIntroduction;
    }
    public String getInvestmentIntroductionImage() {
        return investmentIntroductionImage;
    }
    public void setInvestmentIntroductionImage(String investmentIntroductionImage) {
        this.investmentIntroductionImage = investmentIntroductionImage;
    }
    public String getMarketAnalysis() {
        return marketAnalysis;
    }
    public void setMarketAnalysis(String marketAnalysis) {
        this.marketAnalysis = marketAnalysis;
    }
    public String getMarketAnalysisImage() {
        return marketAnalysisImage;
    }
    public void setMarketAnalysisImage(String marketAnalysisImage) {
        this.marketAnalysisImage = marketAnalysisImage;
    }
    public String getMajorFinancialInformation() {
        return majorFinancialInformation;
    }
    public void setMajorFinancialInformation(String majorFinancialInformation) {
        this.majorFinancialInformation = majorFinancialInformation;
    }
    public String getMajorFinancialInformationImage() {
        return majorFinancialInformationImage;
    }
    public void setMajorFinancialInformationImage(String majorFinancialInformationImage) {
        this.majorFinancialInformationImage = majorFinancialInformationImage;
    }
    public String getRisk() {
        return risk;
    }
    public void setRisk(String risk) {
        this.risk = risk;
    }
    public String getRiskImage() {
        return riskImage;
    }
    public void setRiskImage(String riskImage) {
        this.riskImage = riskImage;
    }
    public String getMajorManpower() {
        return majorManpower;
    }
    public void setMajorManpower(String majorManpower) {
        this.majorManpower = majorManpower;
    }
    public String getMajorManpowerImage() {
        return majorManpowerImage;
    }
    public void setMajorManpowerImage(String majorManpowerImage) {
        this.majorManpowerImage = majorManpowerImage;
    }
    public String getPatentAwardDetails() {
        return patentAwardDetails;
    }
    public void setPatentAwardDetails(String patentAwardDetails) {
        this.patentAwardDetails = patentAwardDetails;
    }
    public String getPatentAwardDetailsImage() {
        return patentAwardDetailsImage;
    }
    public void setPatentAwardDetailsImage(String patentAwardDetailsImage) {
        this.patentAwardDetailsImage = patentAwardDetailsImage;
    }
    public String getEtcInvestContent() {
        return etcInvestContent;
    }
    public void setEtcInvestContent(String etcInvestContent) {
        this.etcInvestContent = etcInvestContent;
    }
    public String getEtcInvestContentImage() {
        return etcInvestContentImage;
    }
    public void setEtcInvestContentImage(String etcInvestContentImage) {
        this.etcInvestContentImage = etcInvestContentImage;
    }
    public String getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SellerInvestmentContent [investmentContentCode=");
        builder.append(investmentContentCode);
        builder.append(", memberId=");
        builder.append(memberId);
        builder.append(", investmentCode=");
        builder.append(investmentCode);
        builder.append(", memberIdAdmin=");
        builder.append(memberIdAdmin);
        builder.append(", projectIntroduction=");
        builder.append(projectIntroduction);
        builder.append(", investmentIntroductionImage=");
        builder.append(investmentIntroductionImage);
        builder.append(", marketAnalysis=");
        builder.append(marketAnalysis);
        builder.append(", marketAnalysisImage=");
        builder.append(marketAnalysisImage);
        builder.append(", majorFinancialInformation=");
        builder.append(majorFinancialInformation);
        builder.append(", majorFinancialInformationImage=");
        builder.append(majorFinancialInformationImage);
        builder.append(", risk=");
        builder.append(risk);
        builder.append(", riskImage=");
        builder.append(riskImage);
        builder.append(", majorManpower=");
        builder.append(majorManpower);
        builder.append(", majorManpowerImage=");
        builder.append(majorManpowerImage);
        builder.append(", patentAwardDetails=");
        builder.append(patentAwardDetails);
        builder.append(", patentAwardDetailsImage=");
        builder.append(patentAwardDetailsImage);
        builder.append(", etcInvestContent=");
        builder.append(etcInvestContent);
        builder.append(", etcInvestContentImage=");
        builder.append(etcInvestContentImage);
        builder.append(", registrationDate=");
        builder.append(registrationDate);
        builder.append("]");
        return builder.toString();
    }

}