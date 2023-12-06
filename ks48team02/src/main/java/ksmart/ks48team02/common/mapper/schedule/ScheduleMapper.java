package ksmart.ks48team02.common.mapper.schedule;

import ksmart.ks48team02.admin.dto.Donation;
import ksmart.ks48team02.admin.dto.DonationInfo;
import ksmart.ks48team02.common.dto.OrderTableList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    public List<OrderTableList> projectApproveCheck();
    public void projectApprove(String orderCode);
    public void orderConfirm(String memberId, String orderCode, String goodsCode, String orderPriceTotal);
    public List<DonationInfo> getDonationList();

    public void projectConditionUpdate(String donationCode, String condition);
    public List<OrderTableList> getOrderTableByGoodsCode(String donationCode);

}
