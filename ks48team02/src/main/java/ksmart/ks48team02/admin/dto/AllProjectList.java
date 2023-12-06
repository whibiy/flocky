package ksmart.ks48team02.admin.dto;

import lombok.Data;

@Data
public class AllProjectList {
    private String projectCode;
    private String projectCondition;
    private String memberId;
    private String projectSubject;
    private String storeName;
    private String projectAchievementMoney;
    private String projectGoalMoney;
    private String projectRegDate;
    private String projectEndDate;
    private String adminId;

}
