package ksmart.ks48team02.admin.controller.donation;

import ksmart.ks48team02.admin.dto.Donation;
import ksmart.ks48team02.admin.dto.DonationJudgementReason;
import ksmart.ks48team02.admin.service.donation.AdminDonationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("adminDonationController")
@RequestMapping("/admin/donation")
public class DonationController {
    private static final Logger log = LoggerFactory.getLogger(DonationController.class);
    private final AdminDonationService adminDonationService;

    public DonationController(AdminDonationService adminDonationService){
        this.adminDonationService = adminDonationService;
    }

    @GetMapping(value = {"", "/"})
    public String mainPage(){
        return "admin/donation/products/main";
    }

    @GetMapping("/products/modify")
    public String productModifyPage(){
        return "admin/donation/products/modify";
    }

    @GetMapping("/products/search_tag_modify")
    public String searchTagModifyPage(){
        return "admin/donation/products/search_tag_modify";
    }

    @GetMapping("/judgement")
    public String judgementMainPage(@RequestParam(name = "adminId", required = false) String adminId,
                                    @RequestParam(name = "judgeApprove", required = false) String judgeApprove,
                                    @RequestParam(name = "judgeReject", required = false) String judgeReject,
                                    @RequestParam(name = "judgeRejectReason", required = false) String judgeRejectReason,
                                    @RequestParam(name = "judgeRejectReasonDetail", required = false) String judgeRejectReasonDetail,
                                                  Model model){
        List<Donation> donationList = adminDonationService.getDonationList();
        log.info("도네이션 목록 {}", donationList);
        List<DonationJudgementReason> donationJudgementReasonsList = adminDonationService.judgementReason();
        model.addAttribute("donationList", donationList);
        model.addAttribute("title", "기부 심사 관리");
        model.addAttribute("contentsTitle", "기부 심사 관리");
        model.addAttribute("donationJudgementReason", donationJudgementReasonsList);

        if (judgeApprove != null){
            System.out.println("어프로브 들어옴" + judgeApprove);
            adminDonationService.judgementApprove(judgeApprove ,adminId);
            return "redirect:/admin/donation/judgement";
        } else if (judgeReject != null) {
            System.out.println("리젝트 들어옴" + judgeReject + "심사반려이유 : " + judgeRejectReason + "심사반려이유상세 : " + judgeRejectReasonDetail + "관리자 아이디 : " + adminId);
            adminDonationService.judgementReject(judgeReject, judgeRejectReason, judgeRejectReasonDetail, adminId);
            return "redirect:/admin/donation/judgement";
        }

        return "admin/donation/judgement/main";
    }

    @GetMapping("/judgement/reject")
    public String judgementRejectPage(){
        return "admin/donation/judgement/reject";
    }

    @GetMapping("/category")
    public String categoryMainPage(){
        return "admin/donation/category/main";
    }

    @GetMapping("/category/modify")
    public String categoryModifyPage(){
        return "admin/donation/category/modify";
    }

    @GetMapping("/calculate")
    public String calculateMainPage(){
        return "admin/donation/calculate/main";
    }

}
