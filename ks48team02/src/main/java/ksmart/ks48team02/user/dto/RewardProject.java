package ksmart.ks48team02.user.dto;


import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.user.dto.RewardOption;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RewardProject {

    private String rewardProjectCode;
    private String rewardCategoryCode;
    private String projectJudgementReasonCode;
    private String regMemberId;
    private String adminMemberId;
    private String storeCode;
    private String projectSubject;
    private String projectContents;
    private int rewardLike;
    private String projectThumbnailImage;
    private int projectAchievementMoney;
    private int projectGoalMoney;
    private int projectAchievementPercent;
    private String regCompany;
    private String projectRegDate;
    private int searchCount;
    private String projectJudgmentReason;
    private String projectJudgementDate;
    private String projectStartDate;
    private String projectEndDate;
    private int projectCondition;
    private String storeImage;
    private int storeLike;
    private String storeMobile;
    private String categoryName;
    private int totalJoinNumber;
    private String rewardGreatDate;


    private List<NewsList> newsLists;
    private List<RewardOption> rewardOptionList;

}
