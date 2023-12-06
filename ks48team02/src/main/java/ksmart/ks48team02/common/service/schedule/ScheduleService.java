package ksmart.ks48team02.common.service.schedule;

import ksmart.ks48team02.admin.dto.Donation;
import ksmart.ks48team02.admin.dto.DonationInfo;
import ksmart.ks48team02.common.dto.OrderTableList;
import ksmart.ks48team02.common.mapper.schedule.ScheduleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ScheduleService {
    ScheduleMapper scheduleMapper;

    // 프로젝트 7일 경과 시 12시 정각에 자동 주문 확정
    public List<OrderTableList> projectApproveCheck(){
        List<OrderTableList> orderTableList = scheduleMapper.projectApproveCheck();
        return orderTableList;
    }

    public void projectApprove(String orderCode){
        scheduleMapper.projectApprove(orderCode);
    }

    public void orderConfirm(String memberId, String orderCode, String goodsCode, String orderPriceTotal){
        scheduleMapper.orderConfirm(memberId, orderCode, goodsCode, orderPriceTotal);
    }

    public List<DonationInfo> getDonationList(){
        return scheduleMapper.getDonationList();
    }

    public void projectConditionUpdate(String donationCode, String condition){
        scheduleMapper.projectConditionUpdate(donationCode, condition);
    }

    public List<OrderTableList> getOrderTableByGoodsCode(String donationCode){
        return scheduleMapper.getOrderTableByGoodsCode(donationCode);
    }

}
