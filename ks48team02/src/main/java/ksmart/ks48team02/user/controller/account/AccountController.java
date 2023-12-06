package ksmart.ks48team02.user.controller.account;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.seller.dto.Store;
import ksmart.ks48team02.seller.service.store.StoreService;
import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.service.member.UserMemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/user/account")
public class AccountController {

    private final UserMemberService userMemberService;
    private final StoreService storeService;


    public AccountController (UserMemberService userMemberService,
                              StoreService storeService) {
        this.userMemberService = userMemberService;
        this.storeService = storeService;
    }

    //로그인 페이지
    @GetMapping("/login")
    public String login(Model model, @RequestParam(name="msg", required = false) String msg) {

        if(msg != null) model.addAttribute("msg", msg);

        return "user/account/login";
    }

    //로그인 기능
    @PostMapping("/login")
    public String login(@RequestParam(name="memberId") String memberId
            , @RequestParam(name="memberPw") String memberPw
            , HttpSession session
            , RedirectAttributes reAttr
            , HttpServletRequest request) throws UnknownHostException {
        Map<String, Object> resultMap = userMemberService.checkMemberInfo(memberId, memberPw);
        boolean isChecked = (boolean) resultMap.get("isChecked");

        if(isChecked) {
            // 로그인 처리
            String memberTypeCode = (String) resultMap.get("memberTypeCode");
            String memberName = (String) resultMap.get("memberName");

            // 클라이언트 IP 가져오기
            String clientIp = getClientIp(request);
            log.info("=========클라이언트 IP{}======",clientIp);
            // 로그인시 로그인 로그 업데이트
            userMemberService.addLoginLog(clientIp, memberId);

            session.setAttribute("SID", memberId);
            session.setAttribute("SNAME", memberName);
            session.setAttribute("STYPECODE", memberTypeCode);

            String getStoreCodeById = storeService.getStoreCodeById(memberId);

            log.info("getStoreCodeById {}", getStoreCodeById);
            session.setAttribute("SSTORECODE", getStoreCodeById);
            // 로그인 처리 후에는 메인화면으로 전환

            return "redirect:/user";
        }
        reAttr.addFlashAttribute("msg",resultMap.get("msg"));

        return "redirect:/user/account/login";
    }

    // ip 가져오기
    public static String getClientIp(HttpServletRequest request) throws UnknownHostException {

        String clientIp = null;
        boolean isIpInHeader = false;

        List<String> headerList = new ArrayList<>();
        headerList.add("X-Forwarded-For");
        headerList.add("HTTP_CLIENT_IP");
        headerList.add("HTTP_X_FORWARDED_FOR");
        headerList.add("HTTP_X_FORWARDED");
        headerList.add("HTTP_FORWARDED_FOR");
        headerList.add("HTTP_FORWARDED");
        headerList.add("Proxy-Client-IP");
        headerList.add("WL-Proxy-Client-IP");
        headerList.add("HTTP_VIA");
        headerList.add("IPV6_ADR");

        for (String header : headerList) {
            clientIp = request.getHeader(header);
            if (StringUtils.hasText(clientIp) && !clientIp.equals("unknown")) {
                isIpInHeader = true;
                break;
            }
        }

        if (!isIpInHeader) {
            clientIp = request.getRemoteAddr();
        }

        if(clientIp.equals("0:0:0:0:0:0:0:1") || clientIp.equals("127.0.0.1")){
            InetAddress address = InetAddress.getLocalHost();

            clientIp = /* address.getHostName() + "/" + */ address.getHostAddress();
        }

        return clientIp;

    }

    //로그아웃  기능
    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request) throws UnknownHostException {

        session.invalidate();
        return "redirect:/user";
    }


}


