package ksmart.ks48team02.seller.dto;

import lombok.Data;

@Data
public class NewsList {
    private String newsCode;
    private String projectCode;
    private String newsSubject;
    private String newsContent;
    private String newsDatetime;
    private String newsModifyDatetime;
    private String newsDeleteDatetime;
    private int newsDisplay;
}
