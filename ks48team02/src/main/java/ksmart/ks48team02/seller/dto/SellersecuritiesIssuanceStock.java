package ksmart.ks48team02.seller.dto;

public class SellersecuritiesIssuanceStock {

    private String securitiesIssuanceStockCode;
    private String investmentCode;
    private long corpValue;
    private int stockPrice;
    private float minDividendRate;

    public float getMinDividendRate() {
        return minDividendRate;
    }

    public void setMinDividendRate(float minDividendRate) {
        this.minDividendRate = minDividendRate;
    }

    public String getSecuritiesIssuanceStockCode() {
        return securitiesIssuanceStockCode;
    }

    public void setSecuritiesIssuanceStockCode(String securitiesIssuanceStockCode) {
        this.securitiesIssuanceStockCode = securitiesIssuanceStockCode;
    }

    public String getInvestmentCode() {
        return investmentCode;
    }

    public void setInvestmentCode(String investmentCode) {
        this.investmentCode = investmentCode;
    }

    public long getCorpValue() {
        return corpValue;
    }

    public void setCorpValue(long corpValue) {
        this.corpValue = corpValue;
    }

    public int getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(int stockPrice) {
        this.stockPrice = stockPrice;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SellersecuritiesIssuanceStock{");
        sb.append("securitiesIssuanceStockCode='").append(securitiesIssuanceStockCode).append('\'');
        sb.append(", investmentCode='").append(investmentCode).append('\'');
        sb.append(", corpValue=").append(corpValue);
        sb.append(", stockPrice=").append(stockPrice);
        sb.append(", minDividendRate=").append(minDividendRate);
        sb.append('}');
        return sb.toString();
    }
}
