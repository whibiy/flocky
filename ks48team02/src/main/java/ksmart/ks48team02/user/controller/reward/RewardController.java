package ksmart.ks48team02.user.controller.reward;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.dto.Coupon;
import ksmart.ks48team02.admin.service.coupon.AdminCouponService;
import ksmart.ks48team02.common.dto.DeliveryMessage;
import ksmart.ks48team02.common.dto.OrderTotal;
import ksmart.ks48team02.common.dto.PaymentResult;
import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.user.controller.PojectRegistrationContoller;
import ksmart.ks48team02.user.dto.*;
import ksmart.ks48team02.user.service.donation.DonationService;
import ksmart.ks48team02.user.service.reward.RewardService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

@Controller("userRewardController")
@RequestMapping("/user/reward")
@AllArgsConstructor
public class RewardController {

    private static final Logger log = LoggerFactory.getLogger(PojectRegistrationContoller.class);
    private static final Logger Log = LoggerFactory.getLogger(RewardController.class);
    private final RewardService rewardService;
    private final AdminCouponService adminCouponService;
    private final DonationService donationService;


    //리워드 메인 페이지
    @GetMapping(value = {"" , "/"})
    public String mainPage(Model model, @RequestParam(name="projectStatus", required = false, defaultValue = "all") String projectStatus,
                           @RequestParam(name="projectArrange", required = false, defaultValue = "like") String projectArrange,
                           @RequestParam(name="category", required = false, defaultValue = "allCategory") String category) {

        //리워드 진행중인 전체 리워드 프로젝트 조회
        List<RewardProject> rewardProjectList = rewardService.rewardProjectList(projectStatus, projectArrange, category);
        model.addAttribute("rewardProjectList",rewardProjectList);
        model.addAttribute("projectStatus",projectStatus);
        model.addAttribute("projectArrange",projectArrange);
        model.addAttribute("category",category);

        return "user/reward/main";
    }

    //리워드 상세 페이지
    @GetMapping("/detail")
    public String detailPage(Model model, @RequestParam(name = "rewardProjectCode") String rewardProjectCode,
                             @RequestParam(name = "searchCnt" , required = false) boolean searchCnt,
                             HttpSession httpSession) {

        //메인 페이지에서 상세페이지 진입 시에만 조회수 증가 하도록.
        if(searchCnt) {
            rewardService.searchCnt(rewardProjectCode);
        }
        //리워드 상세페이지 정보 조회
        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);
        //로그인 한 회원 아이디 조회
        String loginMemberId = (String) httpSession.getAttribute("SID");
        // 회원이 프로젝트 찜 했는지 조회
        int greatCheck = rewardService.projectGreatCheck(rewardProjectCode,loginMemberId);
        //리워드 프로젝트 추천 리스트 조회
        List<RewardProject> recommendProjectList = rewardService.projectRecommendList();

        model.addAttribute("greatCheck", greatCheck);
        model.addAttribute("rewardProject",rewardProject);
        model.addAttribute("recommendProjectList",recommendProjectList);

        log.info("프로젝트 상세페이지 정보 : {}",rewardProject);

        return "user/reward/detail/main";
    }

    //리워드 상세 페이지 댓글
    @GetMapping("/detail/comment")
    public String commentPage(HttpSession session, Model model,
                              @RequestParam(name = "rewardProjectCode") String rewardProjectCode) {

        //접속 회원 아이디
        String memberId = (String)session.getAttribute("SID");
        //프로젝트 정보 조회
        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);
        //댓글 리스트 조회
        List<RewardComment> rewardCommentList = rewardService.getCommentList(rewardProjectCode);
        //리워드 프로젝트 추천 리스트 조회
        List<RewardProject> recommendProjectList = rewardService.projectRecommendList();

        model.addAttribute("recommendProjectList",recommendProjectList);
        model.addAttribute("rewardProject",rewardProject);
        model.addAttribute("memberId", memberId);
        model.addAttribute("rewardCommentList", rewardCommentList);


        return "user/reward/detail/comment";
    }

    //댓글 등록
    @PostMapping("/detail/comment")
    public String commentAdd(HttpSession session, Model model,
                             @RequestParam(name = "rewardProjectCode") String rewardProjectCode,
                             @RequestParam(name = "commentContent") String commentContent){

        String memberId = (String)session.getAttribute("SID");
        String memberName = (String) session.getAttribute("SNAME");
        rewardService.addRewardComment(memberId, rewardProjectCode, memberName, commentContent);

        return "redirect:/user/reward/detail/comment?rewardProjectCode=" + rewardProjectCode;
    }

    //댓글 삭제
    @GetMapping("/detail/commentDelete")
    public String commentDelete(Model model,
                                HttpSession session,
                                @RequestParam(name= "rewardCommentCode") String rewardCommentCode,
                                @RequestParam(name = "rewardProjectCode") String rewardProjectCode){

        //접속 회원 아이디
        String memberId = (String)session.getAttribute("SID");
        //프로젝트 정보 조회
        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);
        //댓글 리스트 조회
        List<RewardComment> rewardCommentList = rewardService.getCommentList(rewardProjectCode);

        model.addAttribute("rewardProject",rewardProject);
        model.addAttribute("memberId", memberId);
        model.addAttribute("rewardCommentList", rewardCommentList);

        rewardService.commentDelete(rewardCommentCode);

        return "redirect:/user/reward/detail/comment?rewardProjectCode=" + rewardProjectCode;
    }

    //대댓글 등록
    @PostMapping("/detail/reply")
    public String replyAdd(HttpSession session, Model model,
                           @RequestParam(name = "reply") String reply,
                           @RequestParam(name = "rewardProjectCode") String rewardProjectCode,
                           @RequestParam(name = "parentCommentCode") String parentCommentCode){

        String memberId = (String)session.getAttribute("SID");
        String memberName = (String) session.getAttribute("SNAME");
        rewardService.addReplyComment(reply, rewardProjectCode, parentCommentCode, memberId, memberName);

        return "redirect:/user/reward/detail/comment?rewardProjectCode=" + rewardProjectCode;
    }



    //리워드 상세 페이지 새소식
    @GetMapping("/detail/news")
    public String newsPage(Model model, @RequestParam(name = "rewardProjectCode") String rewardProjectCode) {

        //프로젝트 상세정보 조회
        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);
        //프로젝트 새소식 조회
        List<NewsList> newsList = donationService.getNewsList(rewardProjectCode);
        //리워드 프로젝트 추천 리스트 조회
        List<RewardProject> recommendProjectList = rewardService.projectRecommendList();

        model.addAttribute("recommendProjectList",recommendProjectList);
        model.addAttribute("rewardProject",rewardProject);
        model.addAttribute("newsList",newsList);

        return "user/reward/detail/news/main";
    }

    //리워드 새소식 상세 페이지
    @GetMapping("/detail/news/detail")
    public String newsDetailPage(Model model,
                                 @RequestParam(name = "rewardProjectCode") String rewardProjectCode,
                                 @RequestParam(name = "newCode") String newsCode){

        //프로젝트 상제정보 조회
        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);
        //프로젝트 새소식 조회
        NewsList newsList = donationService.getDetailNews(newsCode);
        //리워드 프로젝트 추천 리스트 조회
        List<RewardProject> recommendProjectList = rewardService.projectRecommendList();

        model.addAttribute("recommendProjectList",recommendProjectList);
        model.addAttribute("rewardProject",rewardProject);
        model.addAttribute("newsList", newsList);

        return "user/reward/detail/news/detail";
    }


    //리워드 주문 페이지
    @GetMapping("/order")
    public String orderPage(Model model, HttpSession session,
                            @RequestParam(name = "rewardProjectCode") String rewardProjectCode,
                            @RequestParam(name = "rewardOptionCode", required = false) String rewardOptionCode) {
        //로그인 한 아이디 불러오기
        String memberId = (String) session.getAttribute("SID");

        //로그인 하지 않았다면 로그인 화면으로 이동.
        if(memberId == null) {
            return "user/account/login";
        }

        //프로젝트 상세 정보 가져오기
        RewardProject rewardOrderInfo = rewardService.rewardProjectDetail(rewardProjectCode);
        //로그인 한 회원 정보 가져오기
        Member orderMemberInfo = rewardService.getOrderMemberInfo(memberId);
        //로그인 한 회원 보유 쿠폰 리스트 가져오기
        List<Coupon> memberHaveCouponList = adminCouponService.MemberHaveCouponById(memberId);
        //배송 메세지 리스트 가져오기
        List<DeliveryMessage> deliveryMessageList = rewardService.deliveryMessage();

        model.addAttribute("deliveryMessageList",deliveryMessageList);
        model.addAttribute("rewardOrderInfo", rewardOrderInfo);
        model.addAttribute("orderMemberInfo", orderMemberInfo);
        model.addAttribute("memberHaveCouponList", memberHaveCouponList);
        model.addAttribute("rewardOptionCode",rewardOptionCode);

        return "user/reward/order/main";
    }

    //리워드 결제 페이지
    @PostMapping("/payment")
    @ResponseBody
    public String paymentPage(@RequestBody PaymentResult paymentResult) throws IOException, InterruptedException {

        //결제 DB작업에 필요한 데이터 잘 받았는지 log4j로 출력
        log.info("결제 진행 객체: {}", paymentResult);

        String paymentKey = paymentResult.getPaymentKey();
        String orderId = paymentResult.getOrderId();
        int amount = Integer.parseInt(paymentResult.getAmount());

        String payResult = "{\"paymentKey\":\""+paymentKey+"\", "
                            +"\"orderId\":\""+orderId+"\", "
                            +"\"amount\":\""+amount+"\"}";

        //토스 API에 결제 요청 후 승인하고, 결제에 사용된 데이터 요청.
        //결제 승인하기 위해 필요한 url 객체 생성.
        HttpRequest request = HttpRequest.newBuilder()
                                        .uri(URI.create("https://api.tosspayments.com/v1/payments/confirm"))
                                        .header("Authorization","Basic dGVzdF9za19EbnlScFFXR3JOV0Q5WHBMemdaZzhLd3YxTTlFOg==")
                                        .header("Content-Type","application/json")
                                        .method("POST", HttpRequest.BodyPublishers.ofString(payResult))
                                        .build();
        //생성한 url을 보내고, 결제 승인 후 반환 객체를 response변수에 할당.
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(response.body(), Map.class);

        log.info("결제 승인 후 반환 객체: {}", map);

        //주문코드, 결제코드 생성
        OrderTotal orderAndPaymentCode = rewardService.getOrderAndPaymentCode();
        //paymentResult 객체에 주문코드 할당
        String orderCode = orderAndPaymentCode.getOrderCode();
        paymentResult.setOrderCode(orderCode);
        //paymentResult 객체에 결제코드 할당
        String paymentCode = orderAndPaymentCode.getRewardPaymentCode();
        paymentResult.setPaymentCode(paymentCode);

        //프로젝트 결제 서비스 진행
        rewardService.rewardProjectPay(paymentResult);

        return "/user/reward/order/paymentConfirm";
    }

    //결제 완료 페이지
    @GetMapping("/order/paymentConfirm")
    public String paymentConfirm (){

        return"user/reward/order/paymentConfirm";
    }


    //리워드 환불 정책 페이지
    @GetMapping("/detail/refundPolicy")
    public String refundPolicyPage(Model model, @RequestParam(name = "rewardProjectCode") String rewardProjectCode){

        //프로젝트 상세정보 조회
        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);
        //리워드 프로젝트 추천 리스트 조회
        List<RewardProject> recommendProjectList = rewardService.projectRecommendList();

        model.addAttribute("recommendProjectList",recommendProjectList);
        model.addAttribute("rewardProject",rewardProject);
        log.info("프로젝트 상세페이지 정보 : {}",rewardProject);

        return"user/reward/detail/refundPolicy";
    }

    //찜하기
    @GetMapping("/great")
    public String great (@RequestParam(name="rewardProjectCode") String rewardProjectCode,
                         @RequestParam(name="greatCheck") int greatCheck,
                         HttpSession httpSession,
                         RedirectAttributes reattr){
        reattr.addAttribute("rewardProjectCode",rewardProjectCode);
        String loginMemberId = (String) httpSession.getAttribute("SID");
        if(greatCheck > 0) {
            rewardService.greatCancel(rewardProjectCode, loginMemberId);
        } else {
            rewardService.greatInsert(rewardProjectCode, loginMemberId);
        }

        return "redirect:/user/reward/detail";
    }

    //사전체험 리뷰 목록
    @GetMapping("/detail/preReview")
    public String preReview (HttpSession session, Model model,
                             @RequestParam(name = "rewardProjectCode") String rewardProjectCode){
        //리워드 상세페이지 정보 조회
        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);
        //리워드 사전체험리뷰 목록 조회
        List<PreReview> preReviewList =rewardService.preReviewList(rewardProjectCode);
        //리워드 프로젝트 추천 리스트 조회
        List<RewardProject> recommendProjectList = rewardService.projectRecommendList();
        //사전체험단 여부 조회
        String loginMemberId = (String) session.getAttribute("SID");
        String storeCode = rewardProject.getStoreCode();
        int isPreMember = rewardService.isPreMember(loginMemberId, storeCode);

        model.addAttribute("recommendProjectList",recommendProjectList);
        model.addAttribute("rewardProject",rewardProject);
        model.addAttribute("preReviewList",preReviewList);
        model.addAttribute("isPreMember",isPreMember);

        return "user/reward/detail/preReview/main";
    }

    //사전체험 리뷰 상세
    @GetMapping("/detail/reviewDetail")
    public String preReviewDetail (HttpSession session, Model model,
                                   @RequestParam(name = "rewardProjectCode") String rewardProjectCode,
                                   @RequestParam(name = "reviewCode") String reviewCode){
        //리워드 상세페이지 정보 조회
        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);
        //사전체험 리뷰 상세내용 조회
        PreReview preReviewInfo =rewardService.preReview(reviewCode);
        //리워드 프로젝트 추천 리스트 조회
        List<RewardProject> recommendProjectList = rewardService.projectRecommendList();
        //사전체험단 여부 조회
        String loginMemberId = (String) session.getAttribute("SID");
        String storeCode = rewardProject.getStoreCode();
        int isPreMember = rewardService.isPreMember(loginMemberId, storeCode);

        model.addAttribute("recommendProjectList",recommendProjectList);
        model.addAttribute("rewardProject",rewardProject);
        model.addAttribute("preReviewInfo",preReviewInfo);
        model.addAttribute("isPreMember",isPreMember);

        return "user/reward/detail/preReview/reviewDetail";
    }

    //사전체험 리뷰 등록
    @GetMapping("/detail/addReview")
    public String addReviewPage (Model model,
                                 @RequestParam(name = "rewardProjectCode") String rewardProjectCode) {
        //리워드 상세페이지 정보 조회
        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);
        //리워드 프로젝트 추천 리스트 조회
        List<RewardProject> recommendProjectList = rewardService.projectRecommendList();

        model.addAttribute("recommendProjectList",recommendProjectList);
        model.addAttribute("rewardProject",rewardProject);

        return "user/reward/detail/preReview/addReview";
    }

    // 리뷰 등록 진행
    @PostMapping("/detail/addReview")
    public String addReview (PreReview preReview, HttpSession httpSession,
                             RedirectAttributes reAttr){

        String preMemberId = (String) httpSession.getAttribute("SID");
        preReview.setMemberId(preMemberId);

        rewardService.preReivewInsert(preReview);
        reAttr.addAttribute("rewardProjectCode", preReview.getRewardProjectCode());

        return "redirect:/user/reward/detail/preReview";
    }

    //리뷰 삭제
    @GetMapping("/detail/delReview")
    public String delReview (Model model,
                             @RequestParam(name = "reviewCode") String reviewCode,
                             @RequestParam(name = "rewardProjectCode") String rewardProjectCode,
                             RedirectAttributes reAttr) {

        rewardService.delReview(reviewCode);
        reAttr.addAttribute("rewardProjectCode",rewardProjectCode);

        return "redirect:/user/reward/detail/preReview";
    }







}
