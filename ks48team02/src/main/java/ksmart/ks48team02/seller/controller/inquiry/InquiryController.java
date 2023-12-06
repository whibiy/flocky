package ksmart.ks48team02.seller.controller.inquiry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("sellerInquiryController")
@RequestMapping("/seller/inquiry")
public class InquiryController {

    @GetMapping("/main")
    public String inquiryMainPage(Model model){

        model.addAttribute("title", "1:1 문의");
        
        return "seller/inquiry/main";
    }

    @GetMapping("/inquiryModify")
    public String inquiryModify(Model model){
        model.addAttribute("title", "판매자 문의");

        return "admin/inquiry/inquiryModify";
    }

}
