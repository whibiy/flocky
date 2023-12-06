package ksmart.ks48team02.admin.dto;

public class AdminCorporateValueEvaluation {

    private String corporateValueEvaluationCode;
    private String memberId;
    private long operatingProfit;
    private long depreciation;
    private long ebitda;
    private float evEbitda;
    private long convertEv;
    private long netDebt;
    private long evaluatedCorpValue;
    private int stockNumber;
    private int stockPrice;
    private int corpValueFulfill;
    private String corpValueEvaluateDay;

    public AdminInvestmentRequestJudge adminInvestmentRequestJudge;

    public String getCorporateValueEvaluationCode() {
        return corporateValueEvaluationCode;
    }

    public void setCorporateValueEvaluationCode(String corporateValueEvaluationCode) {
        this.corporateValueEvaluationCode = corporateValueEvaluationCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public long getOperatingProfit() {
        return operatingProfit;
    }

    public void setOperatingProfit(long operatingProfit) {
        this.operatingProfit = operatingProfit;
    }

    public long getDepreciation() {
        return depreciation;
    }

    public void setDepreciation(long depreciation) {
        this.depreciation = depreciation;
    }

    public long getEbitda() {
        return ebitda;
    }

    public void setEbitda(long ebitda) {
        this.ebitda = ebitda;
    }

    public float getEvEbitda() {
        return evEbitda;
    }

    public void setEvEbitda(float evEbitda) {
        this.evEbitda = evEbitda;
    }

    public long getConvertEv() {
        return convertEv;
    }

    public void setConvertEv(long convertEv) {
        this.convertEv = convertEv;
    }

    public long getNetDebt() {
        return netDebt;
    }

    public void setNetDebt(long netDebt) {
        this.netDebt = netDebt;
    }

    public long getEvaluatedCorpValue() {
        return evaluatedCorpValue;
    }

    public void setEvaluatedCorpValue(long evaluatedCorpValue) {
        this.evaluatedCorpValue = evaluatedCorpValue;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public int getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(int stockPrice) {
        this.stockPrice = stockPrice;
    }

    public int getCorpValueFulfill() {
        return corpValueFulfill;
    }

    public void setCorpValueFulfill(int corpValueFulfill) {
        this.corpValueFulfill = corpValueFulfill;
    }

    public String getCorpValueEvaluateDay() {
        return corpValueEvaluateDay;
    }

    public void setCorpValueEvaluateDay(String corpValueEvaluateDay) {
        this.corpValueEvaluateDay = corpValueEvaluateDay;
    }

    public AdminInvestmentRequestJudge getAdminInvestmentRequestJudge() {
        return adminInvestmentRequestJudge;
    }

    public void setAdminInvestmentRequestJudge(AdminInvestmentRequestJudge adminInvestmentRequestJudge) {
        this.adminInvestmentRequestJudge = adminInvestmentRequestJudge;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AdminCorporateValueEvaluation [corporateValueEvaluationCode=");
        builder.append(corporateValueEvaluationCode);
        builder.append(", memberId=");
        builder.append(memberId);
        builder.append(", operatingProfit=");
        builder.append(operatingProfit);
        builder.append(", depreciation=");
        builder.append(depreciation);
        builder.append(", ebitda=");
        builder.append(ebitda);
        builder.append(", evEbitda=");
        builder.append(evEbitda);
        builder.append(", convertEv=");
        builder.append(convertEv);
        builder.append(", netDebt=");
        builder.append(netDebt);
        builder.append(", evaluatedCorpValue=");
        builder.append(evaluatedCorpValue);
        builder.append(", stockNumber=");
        builder.append(stockNumber);
        builder.append(", stockPrice=");
        builder.append(stockPrice);
        builder.append(", corpValueFulfill=");
        builder.append(corpValueFulfill);
        builder.append(", corpValueEvaluateDay=");
        builder.append(corpValueEvaluateDay);
        builder.append(", adminInvestmentRequestJudge=");
        builder.append(adminInvestmentRequestJudge);
        builder.append("]");
        return builder.toString();
    }

}