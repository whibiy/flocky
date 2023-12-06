package ksmart.ks48team02.common.dto;

import lombok.Data;

@Data
public class OrderConfirmationLog {
    private String orderConfirmationLogCode;
    private String memberId;
    private String projectPartition;
    private String orderCode;
    private String projectCode;
    private String orderConfirmationDate;
    private int orderPriceTotal;
    private int addReservePrice;
    private int addFlover;
    private String addReserveCode;
    private String addFloverCode;

    private OrderTotal orderTotal;
}
