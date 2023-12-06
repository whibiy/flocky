package ksmart.ks48team02.user.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SecuritiesIssuanceStock {
    private String securitiesIssuanceStockCode;
    private String memberId;
    private String investmentCode;
    private Long corpValue;
    private int investMinCost;
    private int stockPrice;
    private String securitiesClassification;
    private int faceValue;
    private int stockNumber;
    private int issueStockNumber;
    private float issueAllotmentShareRatio;
    private String subscriptionAllocationRanking;
    private String stockType;
    private LocalDateTime subscriptionDate;
    private LocalDateTime subscriptionDeadline;
    private LocalDateTime paymentDate;
    private LocalDateTime estimatedIssueDate;
    private LocalDateTime allocationConfirmationDate;
    private LocalDateTime receivingDateOfSecurities;
    private LocalDateTime redemptionStartDate;
    private LocalDateTime redemptionEndDate;
    private float repaymentRate;
    private float minDividendRate;
    private LocalDateTime conversionStartDate;
    private LocalDateTime conversionEndDate;
    private String conversionCondition;
    private String votingRight;
}
