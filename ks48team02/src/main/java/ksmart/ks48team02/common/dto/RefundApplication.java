package ksmart.ks48team02.common.dto;

import ksmart.ks48team02.user.dto.Member;
import lombok.Data;

@Data
public class RefundApplication {
    private String apcCode;
    private String orderCode;
    private String orderPartition;
    private int optionPrice;
    private int apcAmount;
    private int totalPrice;
    private String apcSubject;
    private String apcTitle;
    private String apcContents;
    private String apcDate;
    private String processingStatus;
    private String processingStatusReason;
    private String processingDate;
    private String adminId;
    private int apcState;
    private String completedDate;


    // order dto
    private OrderTotal orderTotal;

}
