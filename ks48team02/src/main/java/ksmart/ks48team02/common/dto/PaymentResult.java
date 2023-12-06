package ksmart.ks48team02.common.dto;

import ksmart.ks48team02.user.dto.DeliveryMemberInfo;
import ksmart.ks48team02.user.dto.RewardOption;
import lombok.Data;

import java.util.List;
@Data
public class PaymentResult {

    private String paymentKey;
    private String orderId;
    private String amount;
    private String orderCode;
    private String paymentCode;
    private String rewardOrderDetailCode;
    private int usePoint;
    private int deliveryPrice;
    private String useCouponCode;
    private int couponDiscountPrice;
    private int memberRankDiscount;
    private int memberSavePoint;
    private int orderPrice;
    private int totalPayPrice;
    private String rewardProjectcode;
    private String rewardProjectSubject;
    private String orderMemberName;
    private String orderMemberId;
    private String paymentMethod;
    private String useReserveCode;
    private String couponIssueCode;
    private String couponUseLogCode;
    private String pointLogCode;
    private String orderDeliveryCode;

    private DeliveryMemberInfo deliveryMemberInfo;
    private List<RewardOption> rewardOptionList;
}
