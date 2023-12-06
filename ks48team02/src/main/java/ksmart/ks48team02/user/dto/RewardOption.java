package ksmart.ks48team02.user.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RewardOption {

    private String rewardOptionCode;
    private String rewardOrderDetailCode;
    private String rewardProjectCode;
    private String optionContents;
    private int optionPrice;
    private int optionLimitQuantity;
    private String optionName;
    private int optionDeliveryPrice;
    private String optionEstimatedDeliveryDate;
    private String orderCode;
    private int orderQuantity;
    private int pricePerOption;
    private int totalOrderQuantity;

}
