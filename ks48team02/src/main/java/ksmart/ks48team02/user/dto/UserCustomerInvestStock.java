package ksmart.ks48team02.user.dto;

import lombok.Data;

@Data
public class UserCustomerInvestStock {

    private String customerInvestStockCode;
    private String memberId;
    private String investmentCode;
    private String investmentOrderCode;
    private String afterFundRevenueStockCode;
    private long totalEarnings;
    private long stockEarning;
    private float stockEarningRate;
    private int dividendIncome;
    private float dividendIncomeRate;
    private int earningsPerShare;
    private int stockNumber;
    private int stockPrice;
    private int paymentAmount;
    private String revenueDate;
}
