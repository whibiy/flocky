package ksmart.ks48team02.seller.dto;

public class SellerAfterFundRevenueBond {

    private String afterFundRevenueBondCode;
    private String memberId;
    private String investmentCode;
    private String securitiesIssuanceBondCode;
    private long afterInvestmentAmount;
    private long investmentAmount;
    private long take;
    private long profit;
    private long cost;
    private long netIncome;
    private int visitorsNumber;
    private int accountPrice;
    private float interestRate;
    private int totalBondNumber;
    private int earningsPerAccount;
    private String revenuePeriodStart;
    private String revenuePeriodEnd;
    private String uploadDate;

    public String getAfterFundRevenueBondCode() {
        return afterFundRevenueBondCode;
    }

    public void setAfterFundRevenueBondCode(String afterFundRevenueBondCode) {
        this.afterFundRevenueBondCode = afterFundRevenueBondCode;
    }

    public int getTotalBondNumber() {
        return totalBondNumber;
    }

    public void setTotalBondNumber(int totalBondNumber) {
        this.totalBondNumber = totalBondNumber;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SellerAfterFundRevenueBond{");
        sb.append("afterFundRevenueBondCode='").append(afterFundRevenueBondCode).append('\'');
        sb.append(", memberId='").append(memberId).append('\'');
        sb.append(", investmentCode='").append(investmentCode).append('\'');
        sb.append(", securitiesIssuanceBondCode='").append(securitiesIssuanceBondCode).append('\'');
        sb.append(", afterInvestmentAmount=").append(afterInvestmentAmount);
        sb.append(", investmentAmount=").append(investmentAmount);
        sb.append(", take=").append(take);
        sb.append(", profit=").append(profit);
        sb.append(", cost=").append(cost);
        sb.append(", netIncome=").append(netIncome);
        sb.append(", visitorsNumber=").append(visitorsNumber);
        sb.append(", accountPrice=").append(accountPrice);
        sb.append(", interestRate=").append(interestRate);
        sb.append(", totalBondNumber=").append(totalBondNumber);
        sb.append(", earningsPerAccount=").append(earningsPerAccount);
        sb.append(", revenuePeriodStart='").append(revenuePeriodStart).append('\'');
        sb.append(", revenuePeriodEnd='").append(revenuePeriodEnd).append('\'');
        sb.append(", uploadDate='").append(uploadDate).append('\'');
        sb.append('}');
        return sb.toString();
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

    public String getSecuritiesIssuanceBondCode() {
        return securitiesIssuanceBondCode;
    }

    public void setSecuritiesIssuanceBondCode(String securitiesIssuanceBondCode) {
        this.securitiesIssuanceBondCode = securitiesIssuanceBondCode;
    }

    public long getAfterInvestmentAmount() {
        return afterInvestmentAmount;
    }

    public void setAfterInvestmentAmount(long afterInvestmentAmount) {
        this.afterInvestmentAmount = afterInvestmentAmount;
    }

    public long getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(long investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public long getTake() {
        return take;
    }

    public void setTake(long take) {
        this.take = take;
    }

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(long netIncome) {
        this.netIncome = netIncome;
    }

    public int getVisitorsNumber() {
        return visitorsNumber;
    }

    public void setVisitorsNumber(int visitorsNumber) {
        this.visitorsNumber = visitorsNumber;
    }

    public int getAccountPrice() {
        return accountPrice;
    }

    public void setAccountPrice(int accountPrice) {
        this.accountPrice = accountPrice;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public int getEarningsPerAccount() {
        return earningsPerAccount;
    }

    public void setEarningsPerAccount(int earningsPerAccount) {
        this.earningsPerAccount = earningsPerAccount;
    }

    public String getRevenuePeriodStart() {
        return revenuePeriodStart;
    }

    public void setRevenuePeriodStart(String revenuePeriodStart) {
        this.revenuePeriodStart = revenuePeriodStart;
    }

    public String getRevenuePeriodEnd() {
        return revenuePeriodEnd;
    }

    public void setRevenuePeriodEnd(String revenuePeriodEnd) {
        this.revenuePeriodEnd = revenuePeriodEnd;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

}
