package ksmart.ks48team02.user.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SecuritiesIssuanceBond {
    private String securitiesIssuanceBondCode;
    private String memberId;
    private String investmentCode;
    private String interestRate;
    private String investMinCost;
    private String bondPrice;
    private String securitiesClassification;
    private String maturity;
    private String subscriptionAllocationRanking;
    private String bondType;
    private LocalDateTime subscriptionDate;
    private LocalDateTime subscriptionDeadline;
    private LocalDateTime maturityDate;
    private LocalDateTime estimatedIssueDate;
    private LocalDateTime allocationConfirmationDate;
    private LocalDateTime paymentDate;
    private String accountToBeIssued;
}
