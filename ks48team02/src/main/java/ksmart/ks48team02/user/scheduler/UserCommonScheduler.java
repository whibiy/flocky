package ksmart.ks48team02.user.scheduler;


import ksmart.ks48team02.admin.dto.Donation;
import ksmart.ks48team02.admin.dto.DonationInfo;
import ksmart.ks48team02.admin.service.donation.AdminDonationService;
import ksmart.ks48team02.common.dto.OrderTableList;
import ksmart.ks48team02.common.service.schedule.ScheduleService;
import ksmart.ks48team02.user.service.donation.DonationService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Component
@AllArgsConstructor
public class UserCommonScheduler {

    ScheduleService scheduleService;
    /**
     * ("0 0 0 * * *") : 매일 0시 0분 0초 정각
     * ("* /10 * * * * *") : 0, 10, 20, 30, 40, 50 초
     * ("0 0 8-10 * * *") : 매일 8시, 9시, 10시 정각
     * ("0 0/30 8-10 * * *") : 매일 8시, 8시 30분, 9시, 9시 30분, 10시
     * ("0 0 9-18 * * 1-5") : 매주 월요일부터 금요일의 9시부터 오후 6시까지 매시
     */
    @Scheduled(cron = "0 0 0 * * ?") // 초, 분, 시, 일, 월, 년 // 매일 정각에 실행 되게 해놓음
    public void alertScheduledCron(){
        // System.out.println("기부 프로젝트 기부 후 7일 경과 시 자동 확정 코드");
        List<OrderTableList> orderTableList = scheduleService.projectApproveCheck();
        for (int i = 0; i < orderTableList.size(); i++) {
            String givenDateString = orderTableList.get(i).getOrderApplicationDate();
            String currentDateString = getCurrentDate();
            int differenceInDays = calculateDateDifference(givenDateString, currentDateString);
            if(differenceInDays >= 7){
                scheduleService.projectApprove(orderTableList.get(i).getOrderCode());
                scheduleService.orderConfirm(orderTableList.get(i).getMemberId(), orderTableList.get(i).getOrderCode(), orderTableList.get(i).getGoodsCode(), Integer.toString(orderTableList.get(i).getOrderTotalPrice()));
            }
        }
        // System.out.println("기부 프로젝트 기부 마감 후 현황 변경 및 자동 확정 코드");
        List<DonationInfo> donationList = scheduleService.getDonationList();
        for (int i = 0; i < donationList.size(); i++) {
            String givenDateString = donationList.get(i).getDonationEndDate();
            LocalDateTime givenDate = LocalDateTime.parse(givenDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            LocalDateTime currentDate = LocalDateTime.now();
            if (currentDate.isAfter(givenDate) || currentDate.isEqual(givenDate)) {
                if (donationList.get(i).getDonationAchievementPercent() > 100){
                    scheduleService.projectConditionUpdate(donationList.get(i).getDonationCode(), "4");
                }else{
                    scheduleService.projectConditionUpdate(donationList.get(i).getDonationCode(), "5");
                }
                List<OrderTableList> orderTableListByGoodsCode = scheduleService.getOrderTableByGoodsCode(donationList.get(i).getDonationCode());
                if (orderTableListByGoodsCode.size() != 0){
                    for (int j = 0; j < orderTableListByGoodsCode.size(); j++) {
                        scheduleService.projectApprove(orderTableListByGoodsCode.get(j).getOrderCode());
                        scheduleService.orderConfirm(orderTableListByGoodsCode.get(j).getMemberId(), orderTableListByGoodsCode.get(j).getOrderCode(), orderTableListByGoodsCode.get(j).getGoodsCode(), Integer.toString(orderTableListByGoodsCode.get(j).getOrderTotalPrice()));
                    }
                }
            }
        }

    }

    // 현재 날짜와 시간을 가져오는 메서드
    public static String getCurrentDate() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(currentDateTime);
    }

    // 두 날짜 사이의 일 수 차이를 계산하는 메서드
    public static int calculateDateDifference(String date1, String date2) {
        LocalDate givenDate = LocalDate.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDate currentDate = LocalDate.parse(date2, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return Math.abs((int) (currentDate.toEpochDay() - givenDate.toEpochDay()));
    }

}
