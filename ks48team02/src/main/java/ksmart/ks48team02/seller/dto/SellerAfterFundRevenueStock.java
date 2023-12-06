package ksmart.ks48team02.seller.dto;

public class SellerAfterFundRevenueStock {

    private String afterFundRevenueStockCode;
    private String memberId;
    private String investmentCode;
    private String securitiesIssuanceStockCode;
    private long afterInvestmentAmount;
    private long investmentAmount;
    private long take;
    private long costOfSales;
    private long grossProfit;
    private long operatingProfit;
    private long operatingCost;
    private long netIncome;
    private long salesDateEnterpriseValue;
    private long subscriptionEnterpriseValue;
    private int salesBaseStockPrice;
    private int issuePrice;
    private int totalStockNumber;
    private int dividendAmount;
    private float dividendRate;
    private int dividendPerStock;
    private int earningsPerShare;
    private String revenuePeriodStart;
    private String revenuePeriodEnd;
    private String uploadDate;

    public String getAfterFundRevenueStockCode() {
        return afterFundRevenueStockCode;
    }

    public void setAfterFundRevenueStockCode(String afterFundRevenueStockCode) {
        this.afterFundRevenueStockCode = afterFundRevenueStockCode;
    }

    public int getTotalStockNumber() {
        return totalStockNumber;
    }

    public void setTotalStockNumber(int totalStockNumber) {
        this.totalStockNumber = totalStockNumber;
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

    public String getSecuritiesIssuanceStockCode() {
        return securitiesIssuanceStockCode;
    }

    public void setSecuritiesIssuanceStockCode(String securitiesIssuanceStockCode) {
        this.securitiesIssuanceStockCode = securitiesIssuanceStockCode;
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

    public long getCostOfSales() {
        return costOfSales;
    }

    public void setCostOfSales(long costOfSales) {
        this.costOfSales = costOfSales;
    }

    public long getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(long grossProfit) {
        this.grossProfit = grossProfit;
    }

    public long getOperatingProfit() {
        return operatingProfit;
    }

    public void setOperatingProfit(long operatingProfit) {
        this.operatingProfit = operatingProfit;
    }

    public long getOperatingCost() {
        return operatingCost;
    }

    public void setOperatingCost(long operatingCost) {
        this.operatingCost = operatingCost;
    }

    public long getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(long netIncome) {
        this.netIncome = netIncome;
    }

    public long getSalesDateEnterpriseValue() {
        return salesDateEnterpriseValue;
    }

    public void setSalesDateEnterpriseValue(long salesDateEnterpriseValue) {
        this.salesDateEnterpriseValue = salesDateEnterpriseValue;
    }

    public long getSubscriptionEnterpriseValue() {
        return subscriptionEnterpriseValue;
    }

    public void setSubscriptionEnterpriseValue(long subscriptionEnterpriseValue) {
        this.subscriptionEnterpriseValue = subscriptionEnterpriseValue;
    }

    public int getSalesBaseStockPrice() {
        return salesBaseStockPrice;
    }

    public void setSalesBaseStockPrice(int salesBaseStockPrice) {
        this.salesBaseStockPrice = salesBaseStockPrice;
    }

    public int getIssuePrice() {
        return issuePrice;
    }

    public void setIssuePrice(int issuePrice) {
        this.issuePrice = issuePrice;
    }

    public int getDividendAmount() {
        return dividendAmount;
    }

    public void setDividendAmount(int dividendAmount) {
        this.dividendAmount = dividendAmount;
    }

    public float getDividendRate() {
        return dividendRate;
    }

    public void setDividendRate(float dividendRate) {
        this.dividendRate = dividendRate;
    }

    public int getDividendPerStock() {
        return dividendPerStock;
    }

    public void setDividendPerStock(int dividendPerStock) {
        this.dividendPerStock = dividendPerStock;
    }

    public int getEarningsPerShare() {
        return earningsPerShare;
    }

    public void setEarningsPerShare(int earningsPerShare) {
        this.earningsPerShare = earningsPerShare;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SellerAfterFundRevenueStock{");
        sb.append("afterFundRevenueStockCode='").append(afterFundRevenueStockCode).append('\'');
        sb.append(", memberId='").append(memberId).append('\'');
        sb.append(", investmentCode='").append(investmentCode).append('\'');
        sb.append(", securitiesIssuanceStockCode='").append(securitiesIssuanceStockCode).append('\'');
        sb.append(", afterInvestmentAmount=").append(afterInvestmentAmount);
        sb.append(", investmentAmount=").append(investmentAmount);
        sb.append(", take=").append(take);
        sb.append(", costOfSales=").append(costOfSales);
        sb.append(", grossProfit=").append(grossProfit);
        sb.append(", operatingProfit=").append(operatingProfit);
        sb.append(", operatingCost=").append(operatingCost);
        sb.append(", netIncome=").append(netIncome);
        sb.append(", salesDateEnterpriseValue=").append(salesDateEnterpriseValue);
        sb.append(", subscriptionEnterpriseValue=").append(subscriptionEnterpriseValue);
        sb.append(", salesBaseStockPrice=").append(salesBaseStockPrice);
        sb.append(", issuePrice=").append(issuePrice);
        sb.append(", totalStockNumber=").append(totalStockNumber);
        sb.append(", dividendAmount=").append(dividendAmount);
        sb.append(", dividendRate=").append(dividendRate);
        sb.append(", dividendPerStock=").append(dividendPerStock);
        sb.append(", earningsPerShare=").append(earningsPerShare);
        sb.append(", revenuePeriodStart='").append(revenuePeriodStart).append('\'');
        sb.append(", revenuePeriodEnd='").append(revenuePeriodEnd).append('\'');
        sb.append(", uploadDate='").append(uploadDate).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
