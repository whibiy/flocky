package ksmart.ks48team02.user.controller.coupon;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.dto.Coupon;
import ksmart.ks48team02.admin.service.coupon.AdminCouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("userCouponController")
@RequestMapping("/user/coupon")
public class CouponController {

    private static final Logger log = LoggerFactory.getLogger(CouponController.class);

    //DI의존성 추가
    private final AdminCouponService adminCouponService;
    public CouponController ( AdminCouponService adminCouponService) {
        this.adminCouponService = adminCouponService;
    }

    @GetMapping("/main")
    public String userCouponMainPage(Model model, HttpSession session){

        String memberId = (String)session.getAttribute("SID");

        List<Coupon> memberHaveCouponList = adminCouponService.MemberHaveCouponById(memberId);

        model.addAttribute("memberHaveCouponList",memberHaveCouponList);

        return "user/coupon/main";
    }

    @PostMapping("/couponZone")
    public String userCouponPage(Coupon coupon){


        return "redirect:/user/coupon/couponZone";
    }

    @GetMapping("/couponZone")
    public String userCouponZone(Model model){
        model.addAttribute("title", "쿠폰존");



        return "user/coupon/couponZone";
    }

}
