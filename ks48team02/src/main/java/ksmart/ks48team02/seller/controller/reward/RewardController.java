package ksmart.ks48team02.seller.controller.reward;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.dto.TotalCategory;
import ksmart.ks48team02.admin.service.TotalCategoryService;
import ksmart.ks48team02.seller.dto.PreMember;
import ksmart.ks48team02.seller.service.reward.SellerRewardService;
import ksmart.ks48team02.user.dto.RewardProject;
import ksmart.ks48team02.user.service.reward.RewardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;


@Controller("sellerRewardController")
@RequestMapping("/seller/reward")
@AllArgsConstructor
public class RewardController {
    SellerRewardService sellerRewardService;
    RewardService rewardService;
    TotalCategoryService totalCategoryService;

    // 판매자 상품 관리 페이지
    @GetMapping("/products")
    public String productsPage(Model model, HttpSession httpSession,
                               @RequestParam(name="projectCondition" ,required = false) String projectCondition,
                               @RequestParam(name="currentPage", required = false, defaultValue = "1") int currentPage) {

        String sellerId = (String) httpSession.getAttribute("SID");
        Map<String,Object> inquirMap = new HashMap<String,Object>();

        inquirMap.put("sellerId",sellerId);
        inquirMap.put("projectCondition",projectCondition);
        inquirMap.put("currentPage",currentPage);

        Map<String,Object> resultMap =  sellerRewardService.projectListBySellerID(inquirMap);

        List<RewardProject> projectList  = (List<RewardProject>) resultMap.get("projectList");
        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");
        int rowCnt = (int)(double) resultMap.get("rowCnt");

        model.addAttribute("projectList",projectList);
        model.addAttribute("projectCondition",projectCondition);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);
        model.addAttribute("rowCnt",rowCnt);
        return "seller/reward/products/main";
    }

    //현황 별 프로젝트 조회 ajax방법. 현재는 사용하지 않음. ajax 아닌 get방식으로 구현
    @PostMapping ("/products")
    @ResponseBody
    public String productsPage(HttpSession httpSession,
                               @RequestParam(name="projectCondition" ,required = false) String projectCondition) throws JsonProcessingException {

        String sellerId = (String) httpSession.getAttribute("SID");

        Map<String,Object> inquirMap = new HashMap<String,Object>();
        inquirMap.put("sellerId",sellerId);
        inquirMap.put("projectCondition",projectCondition);


        List<RewardProject> projectList = null;
        projectList = (List<RewardProject>) sellerRewardService.projectListBySellerID(inquirMap);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String parserStr = mapper.writeValueAsString(projectList);
        return parserStr;
    }

    //프로젝트 시작.
    @PostMapping("/products/startProject")
    public String startProject(@RequestParam String rewardProjectCode){
        if(rewardProjectCode != null){

            sellerRewardService.startProject(rewardProjectCode);
            return "redirect:/seller/reward/products";
        }

        return "redirect:/seller/reward/products";
    }

    //프로젝트 수정.
    @GetMapping("/products/modify")
    public String productModifyPage(Model model,
                                    @RequestParam(name="rewardProjectCode") String rewardProjectCode){

        RewardProject rewardProject = rewardService.rewardProjectDetail(rewardProjectCode);
        List<TotalCategory> categoryList = totalCategoryService.categoryByPatition("reward");

        model.addAttribute("categoryList",categoryList);
        model.addAttribute("rewardProject",rewardProject);

        return "seller/reward/products/modify";
    }


    // 판매자 사전체험단 관리 페이지
    @GetMapping("/products/preExperienceRecruit")
    public String preExperienceRecruitPage(Model model,
                                           HttpSession httpSession) {

        String storeCode = (String) httpSession.getAttribute("SSTORECODE");
        List<PreMember> preMemberList = sellerRewardService.preMemberList(storeCode);
        model.addAttribute("preMemberList",preMemberList);

        return "seller/reward/products/pre_experience_recruit";
    }

    //사전체험단 추가 시, 가입된 회원인지 검사
    @PostMapping("/products/preMemberIdCheck")
    @ResponseBody
    public int preMemberIdCheck(@RequestParam String memberId){

        int memberCeck = sellerRewardService.preMemberIdCheck(memberId);

        return memberCeck;
    }

    //사전체험단 추가 시, 이미 추가된 회원인지 검사
    @PostMapping("/products/preMemberRegCheck")
    @ResponseBody
    public int preMemberRegCheck(@RequestParam String memberId){

        int preMemberRegCheck = sellerRewardService.preMemberRegCheck(memberId);

        return preMemberRegCheck;
    }

    //사전체험단 추가
    @GetMapping("/products/regPreMember")
    public String regPreMember(@RequestParam (name="memberId", required = true) String memberId,
                            @RequestParam (name="startDate", required = true) String startDate,
                            @RequestParam (name="endDate", required = true) String endDate,
                               HttpSession httpSession){

        String storeCode = (String) httpSession.getAttribute("SSTORECODE");
        sellerRewardService.regPreMember(storeCode, memberId, startDate, endDate);

        return "redirect:/seller/reward/products/preExperienceRecruit";
    }

    //사전체험단 삭제
    @GetMapping("/products/delPreMember")
    public String delPreMember(@RequestParam (name="memberId", required = true) String memberId){


        sellerRewardService.delPreMember(memberId);

        return "redirect:/seller/reward/products/preExperienceRecruit";
    }

    // 판매자 상품 검색태그 수정 패이지
    @GetMapping("/products/searchTagModify")
    public String serchTagModifyPage(Model model) {


        return "seller/reward/products/search_tag_modify";
    }

    //판매자 리워드 새소식 관리 페이지 (새소식 목록 조회+ 삭제)
    @GetMapping("/news")
    public String newsPage(Model model, HttpSession httpSession) {
        String sellerId = (String) httpSession.getAttribute("SID");

        List<RewardProject> newsListPerProject = sellerRewardService.getNewsListBySellerId(sellerId);
        model.addAttribute("newsListPerProject",newsListPerProject);

        return "seller/reward/news/main";
    }

    //판매자 댓글 관리
    @GetMapping("/products/comment")
    public String rewardComment(Model model) {

        return"seller/reward/products/comment";
    }



}
