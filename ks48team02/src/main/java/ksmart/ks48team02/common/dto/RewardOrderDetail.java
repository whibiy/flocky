package ksmart.ks48team02.common.dto;


import lombok.Data;

@Data
public class RewardOrderDetail {
    private String rewardOrderDetailCode;
    private String rewardOptionCode;
    private String orderCode;
    private int orderOptionAmount;
    private int optionPrice;
    private int optionTotalPrice;
    private String optionName;
    private String optionContents;

}
