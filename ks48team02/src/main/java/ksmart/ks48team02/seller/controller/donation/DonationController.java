package ksmart.ks48team02.seller.controller.donation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.seller.dto.DonationList;
import ksmart.ks48team02.admin.dto.Donation;
import jakarta.websocket.Session;
import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.seller.service.donation.SellerDonationService;
import ksmart.ks48team02.user.dto.AllDonationInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller("sellerDonationController")
@RequestMapping("/seller/donation")
@AllArgsConstructor
public class DonationController {
    SellerDonationService sellerDonationService;

    @PostMapping("/products/startProject")
    public String startProject(@RequestParam String donationCode){
        if(donationCode != null){
            sellerDonationService.startProject(donationCode);
            return "redirect:/seller/donation/products";
        }
        return "redirect:/seller/donation/products";
    }

    @GetMapping("/products")
    public String mainPage(Model model,
                           HttpServletRequest request){
        HttpSession session = request.getSession();
        model.addAttribute("title","판매자 : 기부 프로젝트 목록");
        model.addAttribute("contentsTitle","기부 프로젝트 목록");
        String memberId = (String) session.getAttribute("SID");
        List<DonationList> donationList = sellerDonationService.getDonationProjectList(memberId);
        model.addAttribute("donationList", donationList);

        return "seller/donation/products/main";
    }

    @GetMapping("/products/searchTagModify")
    public String searchTagModifyPage(Model model){
        model.addAttribute("title","판매자 : 기부 태그 관리");
        model.addAttribute("contentsTitle","기부 태그 관리");
        return "seller/donation/products/search_tag_modify";
    }

    @GetMapping("/products/modify")
    public String productModifyPage(){
        return "seller/donation/products/modify";
    }

    @GetMapping("/projectRegistration")
    public String projectRegistrationPage(){
        return "seller/donation/projectRegistration/donation_insert";
    }

    @GetMapping("/condition")
    public String conditionMainPage(Model model,
                                    HttpSession session){
        model.addAttribute("title","판매자 : 기부 진행현황 관리");
        model.addAttribute("contentsTitle","기부 진행현황 관리");
        String memberId = (String)session.getAttribute("SID");
        List<AllDonationInfo> allDonationInfo = sellerDonationService.getAllDonationInfo(memberId); // 현재 로그인한 유저 정보로 데이터 가져옴
        model.addAttribute("allDonationInfo", allDonationInfo);

        return "seller/donation/condition/main";
    }

    @PostMapping("/condition/add")
    public String conditionAddPage(@RequestParam(name = "detailComent") String detailContent,
                                   @RequestParam(name = "donationCode") String donationCode){
        sellerDonationService.addCondition(detailContent, donationCode);

        return "redirect:/seller/donation/condition";
    }
    @GetMapping("/condition/add")
    public String conditionAddPage(@RequestParam(name = "donationCode") String donationCode, Model model){
        model.addAttribute("donationCode", donationCode);
        return "seller/donation/condition/add";
    }
    @PostMapping("/condition/modify/update")
    public String conditionModifyUpdate(@RequestParam(name = "detailComent") String detailComent,
                                        @RequestParam(name = "donationCode") String donationCode){
        sellerDonationService.updateCondition(detailComent, donationCode);

        return "redirect:/seller/donation/condition";
    }

    @GetMapping("/condition/modify")
    public String conditionModifyPage(Model model,
                                      @RequestParam(name = "donationCode") String donationCode){
        String Contents = sellerDonationService.modifyCondition(donationCode);
        model.addAttribute("Contents", Contents);
        model.addAttribute("donationCode", donationCode);

        return "seller/donation/condition/modify";
    }

    @GetMapping("/calculate")
    public String calculateMainPage(){
        return "seller/donation/calculate/main";
    }

    @GetMapping("/comments")
    public String commentsManagementPage(Model model){
        model.addAttribute("title","판매자 : 기부 댓글 관리");
        model.addAttribute("contentsTitle","기부 댓글 관리");
        return "seller/donation/comments/main";
    }

    @GetMapping("/news")
    public String newsManagementPage(Model model,
                                     HttpSession session){
        model.addAttribute("title","판매자 : 새소식 관리");
        model.addAttribute("contentsTitle","새소식 관리");
        String memberId = (String)session.getAttribute("SID");
        List<AllDonationInfo> allDonationInfo = sellerDonationService.getAllDonationInfo(memberId); // 현재 로그인한 유저 정보로 데이터 가져옴
        model.addAttribute("allDonationInfo", allDonationInfo);
        List<NewsList> newsList = sellerDonationService.getNews();
        model.addAttribute("newsList", newsList);

        return "seller/donation/news/main";
    }

    @PostMapping("/news/add")
    public String newsAddPage(@RequestParam(name = "detailSubject") String detailSubject,
                              @RequestParam(name = "detailComent") String detailContent,
                              @RequestParam(name = "donationCode") String donationCode){
        sellerDonationService.addNews(detailSubject, detailContent, donationCode);

        String reAddr = "redirect:/seller/";
        if(donationCode.contains("don")) {
            reAddr = reAddr.concat("donation/news");
        } else if (donationCode.contains("RWD") || donationCode.contains("rwd")) {
            reAddr = reAddr.concat("reward/news");
        } else if (donationCode.contains("inv")) {
            reAddr = reAddr.concat("investment/news");
        }

        return reAddr;
    }

    @GetMapping("/news/add")
    public String newsAddPage(@RequestParam(name = "donationCode") String donationCode, Model model){
        model.addAttribute("donationCode", donationCode);
        return "seller/donation/news/add";
    }

    @GetMapping("/news/modify")
    public String newsModifyPage(Model model,
                                 @RequestParam(name = "newsCode") String newsCode,
                                 @RequestParam(name = "projectCode", required = false) String projectCode){

            // newsCode로 select 해서 정보들 가져와서 수정 페이지로 넘기기
        List<NewsList> newsList = sellerDonationService.getNews();
        model.addAttribute("newsCode", newsCode);
        model.addAttribute("newsList",newsList);
        model.addAttribute("projectCode",projectCode);



        return "seller/donation/news/modify";
    }
    @PostMapping("/news/modify/update")
    public String newsModifyUpdate(@RequestParam(name = "detailSubject") String detailSubject,
                                   @RequestParam(name = "detailComent") String detailContent,
                                   @RequestParam(name = "newsCode") String newsCode,
                                   @RequestParam(name = "projectCode") String projectCode){
        sellerDonationService.updateNews(detailSubject, detailContent, newsCode);

        String reAddr = "redirect:/seller/";
        if(projectCode.contains("don")) {
            reAddr = reAddr.concat("donation/news");
        } else if (projectCode.contains("RWD") || projectCode.contains("rwd")) {
            reAddr = reAddr.concat("reward/news");
        } else if (projectCode.contains("inv")) {
            reAddr = reAddr.concat("investment/news");
        }

        return reAddr;
    }

    @GetMapping("/news/delete")
    public String newsDelete(@RequestParam(name = "delNewsCode") String newsCode,
                             @RequestParam(name = "projectCode", required = false) String projectCode){
        sellerDonationService.deleteNews(newsCode);

        String reAddr = "redirect:/seller/";

        if(projectCode != null) {
            if (projectCode.contains("RWD") || projectCode.contains("rwd")) {
                reAddr = reAddr.concat("reward/news");
            } else if (projectCode.contains("inv")) {
                reAddr = reAddr.concat("investment/news");
            }
        } else {
            reAddr = reAddr.concat("donation/news");
        }

        return reAddr;
    }

    @PostMapping("/condition/isProject")
    @ResponseBody
    public int conditionCheck(@RequestBody String donationCode){
        return sellerDonationService.isCondition(donationCode);
    }


}
