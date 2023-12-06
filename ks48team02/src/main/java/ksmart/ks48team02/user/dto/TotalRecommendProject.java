package ksmart.ks48team02.user.dto;

import lombok.Data;

@Data
public class TotalRecommendProject {
    private String projectCode;
    private String categoryCode;
    private String projectImage;
    private String subject;
    private String storeCode;
    private String projectType;
    private int achievementPercent;
    private String storeName;
    private String categoryName;
}
