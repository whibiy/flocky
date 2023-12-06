package ksmart.ks48team02.user.controller.mypage;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.user.dto.MypageReward;
import ksmart.ks48team02.user.service.mypage.MypageRewardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller("mypageRewardController")
@RequestMapping("/user/mypage/reward")
@AllArgsConstructor
@Slf4j
public class MypageRewardController {

    private final MypageRewardService mypageRewardService;

    //환불 페이지
    @GetMapping(value={"","/"})
    public String refundMainPage(){

        return"user/mypage/reward/refund/main";
    }

    //취소 페이지
    @GetMapping("/cancel")
    public String cancelMainPage(Model model,
                                 HttpSession httpSession,
                                 @RequestParam(name="orderCode") String orderCode){

        String memberName = (String) httpSession.getAttribute("SNAME");
        MypageReward orderInfo = mypageRewardService.rewardOrderInfo(orderCode);
        model.addAttribute("memberName",memberName);
        model.addAttribute("orderInfo",orderInfo);


        return"user/mypage/reward/cancel/main";
    }

    //주문취소 진행
    @PostMapping("/cancel")
    @ResponseBody
    public String orderCancel(@RequestBody MypageReward orderInfo) throws IOException, InterruptedException {

        String paymentKey = orderInfo.getPaymentKey();

        //주문 취소 진행 시 보낼 uri 객체 생성.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.tosspayments.com/v1/payments/"+paymentKey+"/cancel"))
                .header("Authorization","Basic dGVzdF9za19EbnlScFFXR3JOV0Q5WHBMemdaZzhLd3YxTTlFOg==")
                .header("Content-Type","application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\"cancelReason\":\"고객이 취소를 원함\"}"))
                .build();

        //주문 취소 진행 후, 응답받은 객체 response에 할당.
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        log.info("주문 취소 후 응답 객체{}",(response.body()));

        //주문 취소 서비스 작업 진행.
        mypageRewardService.orderCancel(orderInfo);
        return"/user/mypage/reward/cancelSuccess";
    }

    //주문취소 완료 페이지
    @GetMapping("/cancelSuccess")
    public String cancelSeccess() {

        return "user/mypage/reward/cancel/cancelSuccess";
    }

    //구매 확정 진행
    @GetMapping("/orderConfirm")
    public String OrderConfirm (@RequestParam(name="orderCode", required = true) String orderCode) {

        //주문 정보 조회
        MypageReward orderInfo = mypageRewardService.rewardOrderInfo(orderCode);
        orderInfo.setChangeCategory("구매확정");
        mypageRewardService.orderConfirm(orderInfo);

        return "redirect:/user/mypage";
    }

    //결제, 환불, 취소 내역 페이지
    @GetMapping("/detailInfo")
    public String detailPage(@RequestParam(name="orderCode", required = true) String orderCode,
                             @RequestParam(name="detailCategory", required = true) String detailCategory,
                             HttpSession httpSession,
                             Model model) {
        String memberName = (String) httpSession.getAttribute("SNAME");
        MypageReward orderInfo = mypageRewardService.rewardOrderInfo(orderCode);
        orderInfo.setChangeCategory(detailCategory);
        model.addAttribute("memberName",memberName);
        model.addAttribute("orderInfo",orderInfo);
        return "user/mypage/reward/detailInfo";
    }


}
