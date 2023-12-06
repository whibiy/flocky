package ksmart.ks48team02.common.dto;

import lombok.Data;

@Data
public class OrderTableList {
    private String orderCode;
    private String memberId;
    private String orderCategoryCode;
    private String orderName;
    private String orderFundingName;
    private int orderTotalPrice;
    private String orderCategoryDetail;
    private String goodsCode;
    private String orderApplicationDate;
    private String orderConfirmDate;
    private String orderCancellDate;
}
