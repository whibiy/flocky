package ksmart.ks48team02.admin.controller.reward;


import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.dto.RewardJudegmentReson;
import ksmart.ks48team02.admin.mapper.reward.AdminRewardMapper;
import ksmart.ks48team02.admin.service.reward.AdminRewardService;
import ksmart.ks48team02.user.dto.RewardProject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("adminRewardController")
@RequestMapping("/admin/reward")
@AllArgsConstructor
public class AdminRewardController {
    private final AdminRewardMapper adminRewardMapper;
    private final AdminRewardService adminRewardService;


    //관리자 리워드 프로젝트 심사.
    @GetMapping("/judgement")
    public String rewardJudgementPage (Model model, HttpSession httpSession,
                                       @RequestParam(name="currentPage", required = false, defaultValue = "1") int currentPage) {


        Map<String,Object> inquirMap = new HashMap<String,Object>();

        inquirMap.put("currentPage",currentPage);

        Map<String,Object> resultMap =  adminRewardService.rewardProjectListNotJudge(inquirMap);

        List<RewardProject> projectList  = (List<RewardProject>) resultMap.get("projectList");
        List<RewardJudegmentReson> rewardJudegmentResonList = (List<RewardJudegmentReson>) resultMap.get("rewardJudegmentResonList");
        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");
        int rowCnt = (int)(double) resultMap.get("rowCnt");

        model.addAttribute("projectList",projectList);
        model.addAttribute("rewardJudegmentResonList",rewardJudegmentResonList);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);
        model.addAttribute("rowCnt",rowCnt);

        return "admin/reward/judgement/main";
    }

    //프로젝트 심사 승인, 거
    @GetMapping("/confirmAndRegect")
    public String confirm (@RequestParam(name="rewardProjectCode") String rewardProjectCode,
                           @RequestParam(name="judgement") String judgement,
                           @RequestParam(name="judgeRejectReasonCode" , required = false) String judgeRejectReasonCode,
                           @RequestParam(name="judgeRejectReasonDetail", required = false) String judgeRejectReasonDetail,
                           HttpSession httpSession){

        System.out.println("DDFSFADSFADSFADSFADSFADSF");
        System.out.println(rewardProjectCode);
        System.out.println(judgement);
        System.out.println(judgeRejectReasonCode);
        System.out.println(judgeRejectReasonDetail);

        String adminMemberId = (String) httpSession.getAttribute("SID");
        adminRewardService.rewardProjectConfirmAndReject(rewardProjectCode, judgement, adminMemberId, judgeRejectReasonCode, judgeRejectReasonDetail);

        return "redirect:/admin/reward/judgement";
    }





}
