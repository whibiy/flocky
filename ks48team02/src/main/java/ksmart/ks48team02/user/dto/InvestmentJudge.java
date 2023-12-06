package ksmart.ks48team02.user.dto;

import lombok.Data;

@Data
public class InvestmentJudge {
    private String investmentRequestJudgeCode;
    private String memberId;
    private String storeCode;
    private String lawSatistifyCode;
    private String incongruitySectorsCode;
    private String companyBusinessTypeCode;
    private String corporateValueEvaluationCode;
    private String memberIdSeller;
    private String investmentRequestSubject;
    private String investmentRequestContent;
    private String investmentCompany;
    private Long investmentAchievementMoney;
    private Long businessProfits;
    private Long depreciation;
    private Long netDebt;
    private int stockNumber;
    private int issueStockNumber;
    private int cashReserves;
    private String investmentRequestDate;
    private String investJudgeDate;
    private int investJudgeResult;




}
