package ksmart.ks48team02.common.dto;

public class InvestPayments {
    public String paymentCode;
    public String orderCode;
    public String investmentCode;
    public String memberId;
    public String refundCode;
    public String securitiesIssuanceCode;
    public int buyStockCount;
    public int buyStockPrice;
    public int orderPrice;
    public int paymentPrice;
    public int paymentStatus;
    public String subscriptionPaymentDate;
    public String subscriptionState;
    public String investorsBankName;
    public String investorsAccount;
    public String securitiesName;
    public String securitiesAccount;
    public String depositBankName;
    public String depositAccount;
    public String paymentDeadlineDate;

    @Override
    public String toString() {
        return "investPayments{" +
                "paymentCode='" + paymentCode + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", investmentCode='" + investmentCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", refundCode='" + refundCode + '\'' +
                ", securitiesIssuanceCode='" + securitiesIssuanceCode + '\'' +
                ", buyStockCount=" + buyStockCount +
                ", buyStockPrice=" + buyStockPrice +
                ", orderPrice=" + orderPrice +
                ", paymentPrice=" + paymentPrice +
                ", paymentStatus=" + paymentStatus +
                ", subscriptionPaymentDate='" + subscriptionPaymentDate + '\'' +
                ", subscriptionState='" + subscriptionState + '\'' +
                ", investorsBankName='" + investorsBankName + '\'' +
                ", investorsAccount='" + investorsAccount + '\'' +
                ", securitiesName='" + securitiesName + '\'' +
                ", securitiesAccount='" + securitiesAccount + '\'' +
                ", depositBankName='" + depositBankName + '\'' +
                ", depositAccount='" + depositAccount + '\'' +
                ", paymentDeadlineDate='" + paymentDeadlineDate + '\'' +
                '}';
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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

    public String getRefundCode() {
        return refundCode;
    }

    public void setRefundCode(String refundCode) {
        this.refundCode = refundCode;
    }

    public String getSecuritiesIssuanceCode() {
        return securitiesIssuanceCode;
    }

    public void setSecuritiesIssuanceCode(String securitiesIssuanceCode) {
        this.securitiesIssuanceCode = securitiesIssuanceCode;
    }

    public int getBuyStockCount() {
        return buyStockCount;
    }

    public void setBuyStockCount(int buyStockCount) {
        this.buyStockCount = buyStockCount;
    }

    public int getBuyStockPrice() {
        return buyStockPrice;
    }

    public void setBuyStockPrice(int buyStockPrice) {
        this.buyStockPrice = buyStockPrice;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(int paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getSubscriptionPaymentDate() {
        return subscriptionPaymentDate;
    }

    public void setSubscriptionPaymentDate(String subscriptionPaymentDate) {
        this.subscriptionPaymentDate = subscriptionPaymentDate;
    }

    public String getSubscriptionState() {
        return subscriptionState;
    }

    public void setSubscriptionState(String subscriptionState) {
        this.subscriptionState = subscriptionState;
    }

    public String getInvestorsBankName() {
        return investorsBankName;
    }

    public void setInvestorsBankName(String investorsBankName) {
        this.investorsBankName = investorsBankName;
    }

    public String getInvestorsAccount() {
        return investorsAccount;
    }

    public void setInvestorsAccount(String investorsAccount) {
        this.investorsAccount = investorsAccount;
    }

    public String getSecuritiesName() {
        return securitiesName;
    }

    public void setSecuritiesName(String securitiesName) {
        this.securitiesName = securitiesName;
    }

    public String getSecuritiesAccount() {
        return securitiesAccount;
    }

    public void setSecuritiesAccount(String securitiesAccount) {
        this.securitiesAccount = securitiesAccount;
    }

    public String getDepositBankName() {
        return depositBankName;
    }

    public void setDepositBankName(String depositBankName) {
        this.depositBankName = depositBankName;
    }

    public String getDepositAccount() {
        return depositAccount;
    }

    public void setDepositAccount(String depositAccount) {
        this.depositAccount = depositAccount;
    }

    public String getPaymentDeadlineDate() {
        return paymentDeadlineDate;
    }

    public void setPaymentDeadlineDate(String paymentDeadlineDate) {
        this.paymentDeadlineDate = paymentDeadlineDate;
    }
}
