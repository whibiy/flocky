package ksmart.ks48team02.user.service.mypage;


import ksmart.ks48team02.user.dto.MypageReward;
import ksmart.ks48team02.user.dto.RewardProject;
import ksmart.ks48team02.user.mapper.mypage.MypageRewardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MypageRewardService {

    private final MypageRewardMapper mypageRewardMapper;

    //리워드 주문, 결제 정보 조회.
    public MypageReward rewardOrderInfo (String orderCode){
        MypageReward mypageReward = mypageRewardMapper.rewardOrderInfo(orderCode);

        return mypageReward;
    }

    //주문 취소
    public void orderCancel (MypageReward orderInfo){
        // 주문 테이블 업데이트
        mypageRewardMapper.orderCategoryChange(orderInfo);
        // 환불 테이블 인서트
        mypageRewardMapper.refundInsert(orderInfo);
        // 결제 테이블 업데이트
        mypageRewardMapper.paymentUpdate(orderInfo);

        //회원이 포인트를 사용하였다면 포인트 사용 로그 테이블에 기록 후, 포인트 돌려주기.
        String pointLogCode = orderInfo.getUseReserveCode();
        if(pointLogCode != null) {
            //포인트 사용 로그 업데이트
            mypageRewardMapper.returnPointLogInsert(orderInfo);
            //포인트 되돌려주기
            mypageRewardMapper.customerPoint(orderInfo);
        }

        //회원이 쿠폰을 사용하였다면 쿠폰 되돌려주기.
        int couponDiscountPrice = Integer.parseInt(orderInfo.getDiscountCouponPrice());
        if(couponDiscountPrice > 0) {
            mypageRewardMapper.couponReturn(orderInfo);
        }

        //프로젝트 달성 금액, 달성률 업데이트
        mypageRewardMapper.projectAchievementMoney(orderInfo);
    }

    // 주문 확정
    public void orderConfirm(MypageReward orderInfo) {

        //주문 테이블 카테고리 변경
        mypageRewardMapper.orderCategoryChange(orderInfo);

        //포인트, 플로버 적립률 계산
        double discountRate = orderInfo.getDiscountRate();
        double floverSavingRate = orderInfo.getFloverSavingRate();
        int orderPrice = orderInfo.getOrderPrice();
        int discountPrice = (int) (discountRate * orderPrice);
        int floverSavingPrice = (int) (floverSavingRate * orderPrice);
        orderInfo.setSavingPoint(discountPrice);
        orderInfo.setSavingFlover(floverSavingPrice);
        //포인트 적립.
        mypageRewardMapper.customerPoint(orderInfo);
        //플로버 적립
        mypageRewardMapper.cumstomerFolver(orderInfo);
        //주문 확정 테이블에 insert
        mypageRewardMapper.orderConfirmLogUpdate(orderInfo);
        //포인트 적립 내역 insert
        mypageRewardMapper.returnPointLogInsert(orderInfo);
        //플로버 적립 내역 insert
        mypageRewardMapper.savingFloverLogInsert(orderInfo);
    }

    //리워드 프로젝트 찜 목록 조회
    public List<RewardProject> rewardProjectGreatList(String loginMemberId) {
        return mypageRewardMapper.rewardProjectGreatList(loginMemberId);
    }



}
