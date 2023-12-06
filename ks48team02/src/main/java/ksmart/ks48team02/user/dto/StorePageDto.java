package ksmart.ks48team02.user.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StorePageDto {
    private String storeNewsCode;
    private String storeCode;
    private String storeNewsTitle;
    private String storeNewsContents;
    private LocalDateTime createdDatetime;
    private LocalDateTime updatedDatetime;
    private LocalDateTime deletedDatetime;
    private int storeNewsDisplay;

    // 모든 프로젝트


}
