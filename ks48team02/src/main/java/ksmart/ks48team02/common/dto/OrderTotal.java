package ksmart.ks48team02.common.dto;

import ksmart.ks48team02.user.dto.Member;
import java.util.List;

import lombok.Data;

@Data
public class OrderTotal {
    private String orderCode;
    private String memberId;
    private String orderCategoryCode;
    private String orderName;
    private String orderFundingName;
    private int orderTotalPrice;
    private String orderCategoryDetail;
    private String goodsCode;
    private String goodsPartition;
    private String orderApplicationDate;
    private String orderConfirmDate;
    private String orderCancellDate;
    private String rewardOrderDetailCode;
    private String rewardPaymentCode;
    private String projectThumbnailImage;
    List<RewardOrderDetail> rewardOrderDetailList;

    public List<RewardOrderDetail> getRewardOrderDetailList() {
        return rewardOrderDetailList;
    }

    public void setRewardOrderDetailList(List<RewardOrderDetail> rewardOrderDetailList) {
        this.rewardOrderDetailList = rewardOrderDetailList;
    }

    public String getProjectThumbnailImage() {
        return projectThumbnailImage;
    }

    public void setProjectThumbnailImage(String projectThumbnailImage) {
        this.projectThumbnailImage = projectThumbnailImage;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderTotal{");
        sb.append("orderCode='").append(orderCode).append('\'');
        sb.append(", memberId='").append(memberId).append('\'');
        sb.append(", orderCategoryCode='").append(orderCategoryCode).append('\'');
        sb.append(", orderName='").append(orderName).append('\'');
        sb.append(", orderFundingName='").append(orderFundingName).append('\'');
        sb.append(", orderTotalPrice=").append(orderTotalPrice);
        sb.append(", orderCategoryDetail='").append(orderCategoryDetail).append('\'');
        sb.append(", goodsCode='").append(goodsCode).append('\'');
        sb.append(", goodsPartition='").append(goodsPartition).append('\'');
        sb.append(", orderApplicationDate='").append(orderApplicationDate).append('\'');
        sb.append(", orderConfirmDate='").append(orderConfirmDate).append('\'');
        sb.append(", orderCancellDate='").append(orderCancellDate).append('\'');
        sb.append(", rewardOrderDetailCode='").append(rewardOrderDetailCode).append('\'');
        sb.append(", rewardPaymentCode='").append(rewardPaymentCode).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
