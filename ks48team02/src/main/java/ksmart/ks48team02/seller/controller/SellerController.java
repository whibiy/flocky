package ksmart.ks48team02.seller.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("sellerMainController")
@RequestMapping("/seller")
public class SellerController {
    @GetMapping(value = {"", "/"})
    public String sellerMainPage(Model model,
                                 HttpSession session){

        // 세션 기본값 설정
        String getSid = (String) session.getAttribute("SID");
        String getStype = (String) session.getAttribute("STYPECODE");

        if(getSid == null){
            session.setAttribute("SID", "id003");
            session.setAttribute("STYPECODE", "mem_type_03");
            session.setAttribute("SSTORECODE", "sto_001");
            session.setAttribute("SNAME", "최자두");
        }

        if(getStype != null && (getStype.equals("mem_type_01") || getStype.equals("mem_type_05"))){
            session.removeAttribute("SID");
            session.removeAttribute("STYPECODE");
            session.removeAttribute("SSTORECODE");
            session.removeAttribute("SNAME");
            session.setAttribute("SID", "id003");
            session.setAttribute("STYPECODE", "mem_type_03");
            session.setAttribute("SSTORECODE", "sto_001");
            session.setAttribute("SNAME", "최자두");
        }



        return "seller/index";
    }
}
