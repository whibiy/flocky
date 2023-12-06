package ksmart.ks48team02.user.controller.mypage;

import groovy.util.logging.Log;
import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.dto.Coupon;
import ksmart.ks48team02.admin.service.coupon.AdminCouponService;
import ksmart.ks48team02.common.dto.OrderTotal;
import ksmart.ks48team02.user.dto.RewardProject;
import ksmart.ks48team02.user.service.account.AccountService;
import ksmart.ks48team02.user.service.mypage.MypageRewardService;
import ksmart.ks48team02.user.service.mypage.MypageService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

@Controller
@RequestMapping("/user/mypage")
@AllArgsConstructor
public class MypageController {
    private static final Logger Log = LoggerFactory.getLogger(MypageController.class);

    private final MypageService mypageService;
    private final MypageRewardService mypageRewardService;
    private final AdminCouponService adminCouponService;

    @GetMapping(value={"","/"})
    public String mypage(Model model, HttpSession session,
                         @RequestParam(name="selectFund", required = false, defaultValue = "viewAll") String selectFund){

        String loginId = (String) session.getAttribute("SID");
        List<OrderTotal> mypageOrderList = mypageService.mypageOrderList(loginId, selectFund);
        Map<String, Object> resultMap = mypageService.getMemberInfoById(loginId);
        String memberEmail = (String) resultMap.get("memberEmail");
        String memberContactInfo = (String) resultMap.get("memberContactInfo");
        List<RewardProject> rewardGreatList = mypageRewardService.rewardProjectGreatList(loginId);


        List<Coupon> memberHaveCouponList = adminCouponService.MemberHaveCouponById(loginId);

        model.addAttribute("memberHaveCouponList",memberHaveCouponList);
        model.addAttribute("mypageOrderList",mypageOrderList);
        model.addAttribute("selectFund",selectFund);
        model.addAttribute("memberEmail", memberEmail);
        model.addAttribute("memberContactInfo", memberContactInfo);
        model.addAttribute("loginId",loginId);
        model.addAttribute("rewardGreatList",rewardGreatList);

        return "user/mypage/mypage";
    }

    @GetMapping("/profile")
    public String profilePage(){
        return "user/mypage/profile";
    }

    @PostMapping("/pwCheck")
    @ResponseBody
    public boolean pwCheck(@RequestParam(name="memberPw") String memberPw, HttpSession session){
        String loginId = (String) session.getAttribute("SID");

        return mypageService.pwCheck(loginId, memberPw);
    }

    @PostMapping("/pwModify")
    @ResponseBody
    public Map<String, Object> pwModify(@RequestParam(name="memberPw") String memberPw, HttpSession session){
        String loginId = (String) session.getAttribute("SID");
        int result = mypageService.pwModify(loginId, memberPw);

        Log.info("비밀번호 변경 결과 {} ", result);

        Map<String, Object> modifyResponse = new HashMap<>();
        modifyResponse.put("result", result);

        return modifyResponse;
    }

    // 이메일 변경
    @PostMapping("/emailModify")
    @ResponseBody
    public void emailModify(@RequestParam(name="memberEmail")String memberEmail, HttpSession session){
        String loginId = (String) session.getAttribute("SID");
        mypageService.emailModify(loginId,memberEmail);
    }
    // 연락처 변경
    @PostMapping("/contactInfoModify")
    @ResponseBody
    public void contactInfoModify(@RequestParam(name="memberContactInfo")String memberContactInfo, HttpSession session){
        String loginId = (String) session.getAttribute("SID");
        mypageService.contactInfoModify(loginId,memberContactInfo);
    }





}
