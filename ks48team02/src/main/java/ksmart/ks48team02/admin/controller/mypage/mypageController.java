package ksmart.ks48team02.admin.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminMypageController")
@RequestMapping("/admin/mypage")
public class mypageController {

    @GetMapping(value = {"","/"})
    public String adminMypage(Model model){
        model.addAttribute("title","관리자 : 개인 정보 수정");
        model.addAttribute("contentsTitle","관리자 개인 정보 수정");
        return "admin/mypage/mypage";
    }
}
