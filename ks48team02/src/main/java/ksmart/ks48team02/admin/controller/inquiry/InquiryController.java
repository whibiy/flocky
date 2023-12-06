package ksmart.ks48team02.admin.controller.inquiry;

import ksmart.ks48team02.admin.dto.Inquiry;
import ksmart.ks48team02.admin.dto.InquiryPage;
import ksmart.ks48team02.admin.service.inquiry.InquiryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("adminInquiryController")
@RequestMapping("/admin/inquiry")
@Slf4j
public class InquiryController {

    private InquiryService inquiryService;
    public InquiryController(InquiryService inquiryService){
        this.inquiryService = inquiryService;
    }


    // 1:1 문의 관리
    @GetMapping("/main")
    public String inquiryMainPage(Model model){
        List<Inquiry> inquiryPage = inquiryService.getInquiryPage();

        model.addAttribute("title", "문의 관리");
        model.addAttribute("hg", inquiryPage);

        log.info("inquiryPage: {}", inquiryPage);

        return "admin/inquiry/main";
    }


    // 1:1 문의 답변 관리
    @GetMapping("/inquiryAnswer")
    public String inquiryAnswerPage(Model model){
        List<Inquiry> inquiryList = inquiryService.getInquiryList();

        model.addAttribute("title","문의 답변 관리");
        model.addAttribute("inquiryList", inquiryList);

        return "admin/inquiry/inquiryAnswer";
    }

    // 1:1 문의 관리 답변 페이지
    @GetMapping("/inquiryModify")
    public String inquiryModiPage(Model model,
                                  @RequestParam(name="inquireCode") String inquireCode){
        Inquiry inquiryModifyList = inquiryService.getInquiryModifyListByCode(inquireCode);

        model.addAttribute("title", "문의 관리 답변 페이지");
        model.addAttribute("hp", inquiryModifyList);
        log.info("inquiryModifyList {}", inquiryModifyList);
        return "admin/inquiry/inquiryModify";
    }

    // 신고 관리
    @GetMapping("/report")
    public String reportMainPage(){

        return "admin/inquiry/report";
    }

    // 신고하기 관리 수정페이지
    @GetMapping("/reportModify")
    public String reportModiPage(){

        return "admin/inquiry/reportModify";
    }
}
