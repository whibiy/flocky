package ksmart.ks48team02.admin.controller.user;

import ksmart.ks48team02.admin.dto.UserManagement;
import ksmart.ks48team02.admin.service.user.UserManagementService;
import ksmart.ks48team02.user.dto.Member;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("adminUserController")
@RequestMapping("/admin/user")
@Slf4j
@AllArgsConstructor
public class UserManagementController {
    private final UserManagementService userManagementService;
    @GetMapping("/memberList")
    public String memberListPage(Model model){
        List<UserManagement> memberList = userManagementService.getMemberList();
        model.addAttribute("memberList", memberList);
        model.addAttribute("contentsTitle", "회원 목록");

        return "admin/user/member_list";
    }




    // 로그인 로그 조회
    @PostMapping("/getLoginLog")
    @ResponseBody
    public List<UserManagement> getLoginLog(@RequestParam(name="memberId", required = false) String memberId,
                                            @RequestParam(name="memberTypeCode", required = false) String memberTypeCode,
                                            @RequestParam(name="startDate") String startDate,
                                            @RequestParam(name="endDate") String endDate){
        List<UserManagement> loginLogs = userManagementService.getLoginLogById(memberId, startDate, endDate, memberTypeCode);

        log.info("로그인 로그 {}", loginLogs);

        return loginLogs;
    }

    // 로그인 내역 조회 페이지
    @GetMapping("/loginLog")
    public String memberLoginLog(Model model){
        // 로그인 로그에서 유저 아이디 작성하고 검색 버튼 클릭시 리스트 반환
        List<UserManagement> loginLogAll = userManagementService.getLoginLog();
        model.addAttribute("loginLogAll", loginLogAll);
        model.addAttribute("contentsTitle", "회원 로그인 이력");
        return "admin/user/login_log";
    }

    // 등급 정보 조회 페이지
    @GetMapping("/memberRank")
    public String memberRankPage(Model model){
        List<UserManagement> rewardRanks = userManagementService.getRewardRank();
        List<UserManagement>  donationRanks = userManagementService.getDonationRank();
        model.addAttribute("rewardRanks",rewardRanks);
        model.addAttribute("donationRanks",donationRanks);
        model.addAttribute("contentsTitle", "프로젝트 유형별 등급 관리");
        return "admin/user/member_rank";
    }


}