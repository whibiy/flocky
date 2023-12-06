package ksmart.ks48team02.admin.controller.board;

import ksmart.ks48team02.admin.dto.Coupon;

import ksmart.ks48team02.admin.service.coupon.AdminCouponService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller("adminBoardController")
@RequestMapping("/admin/board")
public class BoardController {
    private static final Logger log = LoggerFactory.getLogger(BoardController.class);

    private final AdminCouponService adminCouponService;

    @Autowired
    public BoardController(AdminCouponService adminCouponService) {
        this.adminCouponService = adminCouponService;
    }
    // 공지사항 관리
    @GetMapping("/main")
    public String mainPage(){

        return "admin/board/main";
    }
    // 공지사항 수정 페이지
    @GetMapping("/modify")
    public String modifyNotice(){

        return "admin/board/modifyNotice";
    }
    // 공지사항 등록
    @GetMapping("/boardAdd")
    public String boardAdd(){

        return "admin/board/boardAdd";
    }


    // 이벤트 관리
    @GetMapping("/event")
    public String eventPage(){

        return "admin/board/event";
    }

    // 이벤트 수정 페이지
    @GetMapping("/eventModify")
    public String eventPageNotice(){

        return "admin/board/eventModify";
    }

    // 이벤트 등록 페이지
    @GetMapping("/eventAdd")
    public String eventAddPage(){

        return "admin/board/eventAdd";
    }

    // 쿠폰 삭제

    /***
     *
     * @param couponCode
     * @PathVariable : 스프링에서 URL의 경로에서 특정 값을 추출하여 사용할 때 사용한다.
     * @return
     */
    @DeleteMapping("/coupon/{couponCode}") // Delete 핸들러 메소드
    public ResponseEntity<Void> deleteCoupon(@PathVariable String couponCode) {
        adminCouponService.deleteCoupon(couponCode);
        return ResponseEntity.noContent().build();  // 204 No Content 응답을 반환
    }

    // 쿠폰 관리
    @GetMapping("/coupon")
    public String couponPage(Model model){
        List<Coupon> couponList = adminCouponService.getCouponList();
        log.info("쿠폰 목록 {}", couponList);
        model.addAttribute("couponList", couponList);
        model.addAttribute("title", "관리자 쿠폰 목록");

        return "admin/board/coupon";
    }

    // 쿠폰 수정 post
    @PostMapping("/couponAdd")
    public String couponAddPost(Model model, @RequestBody Coupon coupon){
        log.info("쿠폰 수정: {}", coupon);
        adminCouponService.updateCoupon(coupon);
        model.addAttribute("title", " 쿠폰 수정");

        return "redirect:/admin/board/couponAdd";
    }

    //쿠폰 수정
    @GetMapping("/couponAdd")
    public String couponAddPage(@RequestParam(name = "couponCode") String couponCode,
                                Model model){

        log.info("couponCode: {}", couponCode);

        Coupon couponAdd = adminCouponService.getCouponCodeById(couponCode);
        log.info("couponAdd: {}", couponAdd);
        model.addAttribute("couponAdd", couponAdd);
        return "admin/board/couponAdd";
    }

    // 쿠폰 등록 post
    @PostMapping("/couponCreate")
    public String couponCreatePost(@ModelAttribute Coupon coupon){

        adminCouponService.insertCoupon(coupon);

        return "redirect:/admin/board/couponCreate";
    }

    // 쿠폰 등록
    @GetMapping("/couponCreate")
    public String couponCreate(Model model){
        model.addAttribute("title", "쿠폰 등록");

        return "admin/board/couponCreate";
    }
}
