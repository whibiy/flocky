package ksmart.ks48team02.seller.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("sellerMypageController")
@RequestMapping("/seller/mypage")
public class mypageController {

    @GetMapping(value = {"","/"})
    public String adminMypage(Model model){
        model.addAttribute("title","판매자 : 개인 정보 수정");
        model.addAttribute("contentsTitle","판매자 개인 정보 수정");
        return "seller/mypage/mypage";
    }


}
