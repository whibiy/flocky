package ksmart.ks48team02.user.controller.account;

import ch.qos.logback.core.joran.spi.ConsoleTarget;
import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.service.account.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/user/account")
public class MemberAccountController {

    private final AccountService accountService;

    public MemberAccountController(AccountService accountService){
        this.accountService = accountService;
    }

    // 회원가입 메인 페이지
    @GetMapping(value={"","/"})
    public String joinPage() {

        return "user/account/main";
    }

    // 회원 가입 처리 후 이동
    @PostMapping(value="/join")
    public String joinMember(Member member){
        accountService.addMember(member);

        return "user/account/join";
    }

    // 회원 가입 처리 후가 아니면 메인 페이지로
    @GetMapping("/join")
    public String viewJoinPage(){
        return "user/account/main";
    }


    // 아이디 중복체크
    @PostMapping(value="/idCheck")
    @ResponseBody
    public boolean idCheck(@RequestParam(name="memberId") String memberId ) {

        return accountService.idCheck(memberId);
    }

    // 회원 탈퇴 페이지
    @GetMapping("/drop")
    public String dropPage(HttpSession session, Model model){
        String loginId =  (String) session.getAttribute("SID");
        model.addAttribute("loginId", loginId);

        if(loginId == null) return "user/account/main"; else return "user/account/drop";
    }

    // 회원 탈퇴 전 비밀번호 일치 확인 단계
    @PostMapping( "/pwCheck")
    @ResponseBody
    public boolean pwCheck(@RequestParam(name="memberPw") String memberPw
                          ,HttpSession session
                          ,Model model){
        String loginId = (String) session.getAttribute("SID");

        return accountService.pwCheck(loginId, memberPw);
    }

    // 비밀번호 인증 후 정말 탈퇴하시겠습니까 ? YES 👉 회원 비활성화
    @PostMapping("/inactivate")
    public String inactivate(HttpSession session, Model model, RedirectAttributes redirectAttributes){
        String loginId = (String) session.getAttribute("SID");
        model.addAttribute("loginId",loginId);
        int result = accountService.inactivateMember(loginId);
        if(result != 0) model.addAttribute("msg","탈퇴가 완료되었습니다.");
        session.invalidate();

        return "redirect:/user"; // 메인페이지로 이동
    }

    // 회원정보 완전 삭제는 회원 아이디를 참조하는 테이블이 너무 많은 관계로 안 하는 걸로...

    // 회원 아이디로 회원정보 조회




}
