package ksmart.ks48team02.user.service.reward;


import ksmart.ks48team02.common.dto.DeliveryMessage;
import ksmart.ks48team02.common.dto.OrderTotal;
import ksmart.ks48team02.common.dto.PaymentResult;
import ksmart.ks48team02.user.dto.*;
import ksmart.ks48team02.user.mapper.reward.RewardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class RewardService {

    //DI 의존성 추가
    private final RewardMapper rewardMapper;

    public RewardService(RewardMapper rewardMapper){
        this.rewardMapper =rewardMapper;
    }

    //주문 회원 정보 조회
    public Member getOrderMemberInfo (String memberId){
        Member orderMemberInfo = rewardMapper.getOrderMemberInfo(memberId);

        return orderMemberInfo;
    }
    //배송 메세지 조회
    public List<DeliveryMessage> deliveryMessage(){
        List<DeliveryMessage> deliveryMessageList = rewardMapper.deliveryMessage();
        return deliveryMessageList;
    }

    //리워드 등록 하기
    public void addRewardProject (RewardProject rewardProject){
        int addReward = rewardMapper.addRewardProject(rewardProject);
        String rewardProjectCode = rewardProject.getRewardProjectCode();
        List<RewardOption> optionList = rewardProject.getRewardOptionList();

        optionList.forEach(option -> {

            option.setRewardProjectCode(rewardProjectCode);
            rewardMapper.rewardOptionAdd(option);
        });

    }

    //리워드프로젝트 전체 조회.
    public List<RewardProject> rewardProjectList (String projectStatus, String projectArrange, String category){
        List<RewardProject> projectList = rewardMapper.rewardProjectList(projectStatus, projectArrange, category);

        return projectList;
    }

    //리워드 프로젝트 상세 페이지
     public RewardProject rewardProjectDetail(String rewardProjectCode){

        RewardProject rewardProject =rewardMapper.rewardProjectDetail(rewardProjectCode);
        List<RewardOption> rewardOptionList = rewardProject.getRewardOptionList();
        int totalJoinNumber = rewardMapper.rewardProjectJoinNumber(rewardProjectCode);
         rewardProject.setTotalJoinNumber(totalJoinNumber);

        //리워드 옵션 당 주문 갯수 조회.
        rewardOptionList.forEach(option->{
            String optionCode = option.getRewardOptionCode();
            int totalOrderQuantity = rewardMapper.optionTotalOrderQuantity(optionCode);
            option.setTotalOrderQuantity(totalOrderQuantity);
        });
        return rewardProject;
     }

    //상세 페이지 진입 시 조회수 증가
    public void searchCnt(String rewardProjectCode){
        rewardMapper.searchCnt(rewardProjectCode);
    };

     //주문번호, 주문상세번호, 결제번호 생성
    public OrderTotal getOrderAndPaymentCode(){
        OrderTotal orderAndPaymentCode = rewardMapper.getOrderAndPaymentCode();

        return orderAndPaymentCode;
    }

    //주문 진행
    public void rewardProjectPay(PaymentResult paymentResult){
        String orderCode = paymentResult.getOrderCode();
        String rewardProjectCode = paymentResult.getRewardProjectcode();
        List<RewardOption> rewardOptionList = paymentResult.getRewardOptionList();


        //통합 주문 테이블 인서트
        rewardMapper.orderTableInsert(paymentResult);
        System.out.println("통합주문테이블 등록 완료");

        //리워드 주문 상세 테이블 인서트
        rewardOptionList.forEach(option ->{
            option.setOrderCode(orderCode);
            rewardMapper.rewardOrderDetailInsert(option);
        });
        System.out.println("주문상세테이블 등록 완료");

        //결제 테이블 인서트
        rewardMapper.rewardPaymentsInsert(paymentResult);
        System.out.println("결제테이블 등록 완료");

        //프로젝트 달성 금액, 달성률 업데이트
        rewardMapper.projectAchievementMoney(paymentResult);
        System.out.println("프로젝트 달성금액, 달성률 업데이트 완료");

        //리워드 배송 테이블 인서트
        rewardMapper.orderDeliveryInsert(paymentResult);

        if( paymentResult.getUsePoint() > 0) {
            //포인트 사용 내역 인서트
            rewardMapper.usePointLogInsert(paymentResult);
            //포인트 사용 시 포인트 차감.
            rewardMapper.customerUsePoint(paymentResult);
            System.out.println("포인트사용 로그 등록 완료");
        }

        if(paymentResult.getUseCouponCode() != null) {

            // 쿠폰 사용 내역 인서트
            rewardMapper.useCouponLogInsert(paymentResult);
            System.out.println("쿠폰등록 완료");

            String couponIssueCode = paymentResult.getCouponIssueCode();
            //쿠폰 사용 시 보유 쿠폰 사용했음으로 업데이트.
            rewardMapper.usedCouponUpdate(couponIssueCode);
            System.out.println("쿠폰사용 로그 등록 완료");
        }

    }

    //댓글 조회
    public List<RewardComment> getCommentList (String rewardProjectCode) {

        List<RewardComment> rewardCommentList = rewardMapper.getCommentList(rewardProjectCode);

        return rewardCommentList;
    }

    //댓글 달기
    public void addRewardComment (String memberId, String rewardProjectCode, String memberName, String commentContent) {
        rewardMapper.addRewardComment(memberId, rewardProjectCode, memberName, commentContent);
    }

    //댓글 삭제
    public void commentDelete (String rewardCommentCode) {
        rewardMapper.commentDelete(rewardCommentCode);
    }

    //대댓글 달기
    public void addReplyComment (String reply, String rewardProjectCode, String parentCommentCode,  String memberId, String memberName){
        rewardMapper.addReplyComment(reply, rewardProjectCode, parentCommentCode, memberId, memberName);
    }

    // 리워드 공고 옵션 조회
    public List<RewardOption> getRewardOptionByCode(String rewardProjectCode){

        List<RewardOption> getRewardOptionByCode = null;
        getRewardOptionByCode = rewardMapper.getRewardOptionByCode(rewardProjectCode);
        return getRewardOptionByCode;

    }

    //프로젝트 찜 여부 조회
    public int projectGreatCheck(String rewardProjectCode, String loginMemberId) {
        return rewardMapper.projectGreatCheck(rewardProjectCode,loginMemberId);
    }

    //찜하기 진행
    public void greatInsert(String rewardProjectCode, String loginMemberId){
        rewardMapper.greatInsert(rewardProjectCode, loginMemberId);
    }
    //찜하기 취소
    public void greatCancel(String rewardProjectCode, String loginMemberId){
        rewardMapper.greatCancel(rewardProjectCode, loginMemberId);
    }

    //프로젝트 추천 리스트 조회
    public List<RewardProject> projectRecommendList() {
        return rewardMapper.projectRecommendList();
    }

    //사전체험 후기 목록
    public List<PreReview> preReviewList(String rewardProjectCode){return rewardMapper.preReviewList(rewardProjectCode);}

    //사전 체험 상세정보
    public PreReview preReview(String reviewCode){return rewardMapper.preReview(reviewCode);}

    //사전 체험 리뷰 등록
    public void preReivewInsert (PreReview preReview){
        rewardMapper.preReivewInsert(preReview);
    }

    //사전체험단 여부 조회
    public int isPreMember(String loginMemberId, String storeCode){return rewardMapper.isPreMember(loginMemberId, storeCode);}

    //리뷰 삭제
    public void delReview(String reviewCode){rewardMapper.delReview(reviewCode);}

}
