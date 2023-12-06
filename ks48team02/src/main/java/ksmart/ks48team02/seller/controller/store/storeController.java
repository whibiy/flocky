package ksmart.ks48team02.seller.controller.store;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("sellerStoreController")
@RequestMapping("/seller/store")
public class storeController {

    @GetMapping(value = {"", "/"})
    public String storePage(Model model) { // 스토어 메인페이지 : 소속된 스토어 정보 조회 페이지
        model.addAttribute("contentsTitle","My 스토어");
        return "seller/store/main";
    }

    @GetMapping(value = { "/edit"})
        public String storeEditPage(Model model) { // 내 스토어 상세 확인/수정 페이지
        model.addAttribute("contentsTitle","My 스토어");
        return "seller/store/edit";
    }

    @GetMapping(value = "/registration")
    public String storeRegisterPage(Model model) { // 대표자 스토어 등록 페이지
        model.addAttribute("contentsTitle","스토어 만들기");
        return "seller/store/registration";
    }

    @GetMapping(value = "/staffAdd")
    public String staffAddPage(Model model) { //대표자 직원 관리 페이지
        model.addAttribute("contentsTitle","스토어 직원 관리");
        return "seller/store/staff_add";
    }

    @GetMapping("/news")
    public String storeNewsPage(Model model){ // 스토어 새소식 관리
        model.addAttribute("contentsTitle","스토어 새소식 관리");
        return "seller/store/news";
    }

    @GetMapping("/storeCode")
    public String storeCodePage(Model model){ // 스토어 새소식 관리
        model.addAttribute("contentsTitle","스토어 연결하기");
        return "seller/store/reg_store_code";
    }
}
