package ksmart.ks48team02.common.dto;

import lombok.Data;

@Data
public class projectSettlementApplication {
    private String projectSalesCode;
    private String memberId;
    private String projectCode;
    private String projectPartition;
    private int consumerAmount;
    private int totalFundingPrice;
    private int chargePercent;
    private int chargePrice;
    private int netProfit;
    private String projectSalesDate;
    private int projectTargetAmount;
    private String goodsStartDate;
    private String goodsEndDate;
    private String processingApproved;
    private String processingDate;
    private String reason;
    private int state;
    private String processedDate;
    private String adminId;
}
