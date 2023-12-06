package ksmart.ks48team02.common.dto;

import lombok.Data;

@Data
public class SettlementPrjList {
    private String projectCode;
    private String subject;
    private String storeCode;
    private String storeName;
    private String projectPartition;
    private int projectGoalMoney;
    private int projectAchievementMoney;
    private int projectAchievementPercent;
    private String projectEndDate;
    private String memberId;
}
