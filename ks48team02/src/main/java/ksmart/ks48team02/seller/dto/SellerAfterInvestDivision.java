package ksmart.ks48team02.seller.dto;

import lombok.Data;

@Data
public class SellerAfterInvestDivision {

    private String afterInvestDivisionCode;
    private String memberId;
    private String investmentCode;
    private String memberIdCustomer;
    private long investCost;
    private long afterOperateDivision;
    private long afterOperateDivisionAccumulate;
    private int round;
    private String divisionDate;
}
