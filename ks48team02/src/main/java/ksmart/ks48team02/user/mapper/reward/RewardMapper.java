package ksmart.ks48team02.user.mapper.reward;


import ksmart.ks48team02.common.dto.DeliveryMessage;
import ksmart.ks48team02.common.dto.OrderTotal;
import ksmart.ks48team02.common.dto.PaymentResult;
import ksmart.ks48team02.user.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface RewardMapper {


    //주문 회원 정보 조회
    public Member getOrderMemberInfo(String memberId);

    //배송 메세지 조회
    public List<DeliveryMessage> deliveryMessage();

    //프로젝트 등록
    public int addRewardProject (RewardProject rewardProject);

    //리워드 옵션 등록
    public int rewardOptionAdd (RewardOption rewardOption);

    //리워드프로젝트 전체 조회.
    public List<RewardProject> rewardProjectList(String projectStatus, String projectArrange, String category);

    //리워드 프로젝트 상세 페이지
    public RewardProject rewardProjectDetail(String rewardProjectCode);

    // 리워드 공고 옵션 조회
    public List<RewardOption> getRewardOptionByCode(String rewardProjectCode);
    //상세 페이지 진입 시 조회수 증가
    public int searchCnt(String rewardProjectCode);

    //옵션당 총 주문 개수 조회
    public int optionTotalOrderQuantity (String optionCode);

    //프로젝트 총 참여인원 조회
    public int rewardProjectJoinNumber (String rewardProjectCode);

    //주문번호, 주문상세번호, 결제번호 생성.
    public OrderTotal getOrderAndPaymentCode();

    //통합 주문 테이블 인서트
    public int orderTableInsert(PaymentResult paymentResult);

    //리워드 주문 상세 테이블 인서트
    public int rewardOrderDetailInsert(RewardOption rewardOption);

    //리워드 결제 관리 테이블 인서트
    public int rewardPaymentsInsert(PaymentResult paymentResult);

    // 결제 시 리워드 배송 테이블 인서트
    public int orderDeliveryInsert (PaymentResult paymentResult);

    //프로젝트 달성 금액, 달성률 업데이트
    public int projectAchievementMoney(PaymentResult paymentResult);

    //포인트 사용 내역 인서트.
    public int usePointLogInsert(PaymentResult paymentResult);

    //포인트 적립 내역 인서트
    public int savePointLogInsert(PaymentResult paymentResult);

    //포인트 사용 시 보유 포인트에서 차감
    public int customerUsePoint(PaymentResult paymentResult);


    //쿠폰 사용 내역 인서트
    public int useCouponLogInsert (PaymentResult paymentResult);

    //사용한 쿠폰 사용했음으로 업데이트
    public int usedCouponUpdate (String couponIssueCode);

    //댓글 조회
    public List<RewardComment> getCommentList (String rewardProjectCode);

    //댓글 달기
    public int addRewardComment (String memberId, String rewardProjectCode, String memberName, String commentContent);

    //댓글 삭제
    public int commentDelete (String rewardCommentCode);

    //대댓글 달기
    public int addReplyComment (String reply, String rewardProjectCode, String parentCommentCode,  String memberId, String memberName);

    //프로젝트 찜 여부 조회
    public int projectGreatCheck(String rewardProjectCode, String loginMemberId);

    // 찜하기 진행
    public int greatInsert(String rewardProjectCode, String loginMemberId);

    // 찜하기 취소
    public int greatCancel(String rewardProjectCode, String loginMemberId);

    //프로젝트 추천 리스트 조회
    public List<RewardProject> projectRecommendList();

    //사전체험 후기 목록
    public List<PreReview> preReviewList(String rewardProjectCode);

    //사전 체험 상세정보
    public PreReview preReview(String reviewCode);

    //사전 체험 리뷰 등록
    public int preReivewInsert (PreReview preReview);

    //사전체험단 여부 조회
    public int isPreMember(String loginMemberId, String storeCode);

    //리뷰 삭제
    public int delReview(String reviewCode);

}
