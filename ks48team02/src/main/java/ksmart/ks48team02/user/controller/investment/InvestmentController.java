package ksmart.ks48team02.user.controller.investment;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.dto.DonationInfo;
import ksmart.ks48team02.common.dto.PaymentResult;
import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.user.dto.*;
import ksmart.ks48team02.user.service.investment.UserInvestmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Controller("userInvestmentController")
@RequestMapping("/user/investment")
public class InvestmentController {

    private final UserInvestmentService userInvestmentService;

    public InvestmentController(UserInvestmentService userInvestmentService) {
        this.userInvestmentService = userInvestmentService;
    }


    @GetMapping(value = {"", "/"})
    public String getMainPage(Model model) {

        List<InvestmentInfo> investmentInfo = userInvestmentService.getInvestmentInfo();
        model.addAttribute("investmentInfo", investmentInfo);

        model.addAttribute("title", "투자 메인 페이지");


        return "user/investment/main";
    }

    @PostMapping("/ajax/sortedList")
    @ResponseBody
    public List<InvestmentInfo> getSortedList(@RequestParam(name = "status") String status,
                                              @RequestParam(name = "securities") String securities,
                                              @RequestParam(name = "orderBy") String orderBy) {
        return userInvestmentService.getSortedList(status, securities, orderBy);
    }


    @GetMapping("/detail/main")
    public String getDetailMainPage(Model model,
                                    @RequestParam(name = "investmentCode") String investmentCode,
                                    HttpSession session) {

        String loginMemberId = (String) session.getAttribute("SID");

        InvestmentInfo investmentInfo = userInvestmentService.investmentProjectDetail(investmentCode);
        model.addAttribute("investmentInfo", investmentInfo);
        SecuritiesIssuanceStock securitiesIssuanceStock = userInvestmentService.securitiesStock(investmentCode);
        model.addAttribute("securitiesIssuanceStock", securitiesIssuanceStock);
        SecuritiesIssuanceBond securitiesIssuanceBond = userInvestmentService.securitiesBond(investmentCode);
        model.addAttribute("securitiesIssuanceBond", securitiesIssuanceBond);
        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }

        model.addAttribute("title", "투자 상세 페이지");


        return "user/investment/detail/main";
    }

    @GetMapping("/detail/comment")
    public String detailCommentPage(Model model,
                                    @RequestParam(name = "investmentCode") String investmentCode,
                                    HttpSession session) {

        String memberId = (String)session.getAttribute("SID");

        InvestmentInfo investmentInfo = userInvestmentService.investmentProjectDetail(investmentCode);
        model.addAttribute("investmentInfo", investmentInfo);
        SecuritiesIssuanceStock securitiesIssuanceStock = userInvestmentService.securitiesStock(investmentCode);
        model.addAttribute("securitiesIssuanceStock", securitiesIssuanceStock);
        SecuritiesIssuanceBond securitiesIssuanceBond = userInvestmentService.securitiesBond(investmentCode);
        model.addAttribute("securitiesIssuanceBond", securitiesIssuanceBond);
        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }

        List<InvestmentComment> investmentComment = userInvestmentService.getCommentList(investmentCode);
        model.addAttribute("investmentComment", investmentComment);
        // 리뷰 개수 계산
        int viewCount = 0;
        for (int i = 0; i < investmentComment.size(); i++) {
            if(investmentComment.get(i).getCommentClass().equals("comment")){
                viewCount++;
            }
        }
        model.addAttribute("viewCount", viewCount);

        model.addAttribute("title", "투자 상세 댓글");

        return "user/investment/detail/comment";
    }

    @PostMapping("/detail/comment")
    public String commentAdd(HttpSession session, Model model,
                             @RequestParam(name = "investmentCode") String investmentCode,
                             @RequestParam(name = "commentContent") String commentContent){
        String memberId = (String)session.getAttribute("SID");
        CommentMember commentMember = userInvestmentService.getMember(memberId);
        model.addAttribute("commentMember", commentMember);

        System.out.println("Received investmentCode: " + investmentCode);

        userInvestmentService.CommentAdd(memberId, investmentCode, commentMember.getMemberName(), commentContent);

        return "redirect:/user/investment/detail/comment?investmentCode=" + investmentCode;
    }

    @PostMapping("/detail/reply")
    public String replyAdd(HttpSession session, Model model,
                           @RequestParam(name = "reply") String reply,
                           @RequestParam(name = "investmentCode") String investmentCode,
                           @RequestParam(name = "parentCommentCode") String parentCommentCode){
        String memberId = (String)session.getAttribute("SID");
        CommentMember commentMember = userInvestmentService.getMember(memberId);
        model.addAttribute("commentMember", commentMember);

        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }

        userInvestmentService.replyAdd(reply, investmentCode, parentCommentCode, memberId, commentMember.getMemberName());

        return "redirect:/user/investment/detail/comment?investmentCode=" + investmentCode;
    }

    @GetMapping("/detail/investor")
    public String detailInvestorPage(Model model,
                                     @RequestParam(name = "investmentCode") String investmentCode,
                                     HttpSession session) {


        InvestmentInfo investmentInfo = userInvestmentService.investmentProjectDetail(investmentCode);
        model.addAttribute("investmentInfo", investmentInfo);
        SecuritiesIssuanceStock securitiesIssuanceStock = userInvestmentService.securitiesStock(investmentCode);
        model.addAttribute("securitiesIssuanceStock", securitiesIssuanceStock);
        SecuritiesIssuanceBond securitiesIssuanceBond = userInvestmentService.securitiesBond(investmentCode);
        model.addAttribute("securitiesIssuanceBond", securitiesIssuanceBond);

        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }

        model.addAttribute("title", "투자 위험 고지");

        return "user/investment/detail/investor";
    }

    @GetMapping("/detail/news")
    public String detailNewsPage(Model model,
                                 @RequestParam(name = "investmentCode") String investmentCode,
                                 HttpSession session) {


        InvestmentInfo investmentInfo = userInvestmentService.investmentProjectDetail(investmentCode);
        model.addAttribute("investmentInfo", investmentInfo);
        SecuritiesIssuanceStock securitiesIssuanceStock = userInvestmentService.securitiesStock(investmentCode);
        model.addAttribute("securitiesIssuanceStock", securitiesIssuanceStock);
        SecuritiesIssuanceBond securitiesIssuanceBond = userInvestmentService.securitiesBond(investmentCode);
        model.addAttribute("securitiesIssuanceBond", securitiesIssuanceBond);

        List<NewsList> newsList = userInvestmentService.getNewsList(investmentCode);
        model.addAttribute("newsList", newsList);

        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }

        model.addAttribute("title", "투자 새소식");

        return "user/investment/detail/news/main";
    }

    @GetMapping("/detail/news/newsDetail")
    public String newsDetailPage(@RequestParam(name = "newCode") String newsCode,
                                 @RequestParam(name = "investmentCode") String investmentCode,
                                 Model model, HttpSession session){
        InvestmentInfo investmentInfo = userInvestmentService.investmentProjectDetail(investmentCode);
        model.addAttribute("investmentInfo", investmentInfo);
        SecuritiesIssuanceStock securitiesIssuanceStock = userInvestmentService.securitiesStock(investmentCode);
        model.addAttribute("securitiesIssuanceStock", securitiesIssuanceStock);
        SecuritiesIssuanceBond securitiesIssuanceBond = userInvestmentService.securitiesBond(investmentCode);
        model.addAttribute("securitiesIssuanceBond", securitiesIssuanceBond);

        NewsList newsList = userInvestmentService.getDetailNews(newsCode);
        model.addAttribute("newsList", newsList);

        String STYPECODE = (String)session.getAttribute("STYPECODE");
        model.addAttribute("STYPECODE", STYPECODE);
        String SID = (String) session.getAttribute("SID");
        if(SID == null || SID == "" || SID == "null"){
            model.addAttribute("SID", "noSession");
        }else {
            model.addAttribute("SID", SID);
        }


        return "user/investment/detail/news/news_detail";
    }

    @GetMapping("/order")
    public String orderPage(Model model, HttpSession session) {

        model.addAttribute("title", "투자 주문 페이지");

        String memberId = (String) session.getAttribute("SID");

        if(memberId == null) {
            return "user/account/login";
        }
        // 프로젝트 상세 정보 가져오기



        return "user/investment/order/main";
    }

    @GetMapping("/list/after-process")
    public String getAfterProcessList(Model model) {

        model.addAttribute("title", "투자 펀딩 후 진행정보 목록");
        model.addAttribute("contentsTitle","투자 펀딩 후 진행정보 목록");

        return "user/mypage/investment/list/invest_after_process_list";
    }

    @GetMapping("/list/after-fund-revenue")
    public String getAfterFundRevenueList(Model model) {

        model.addAttribute("title", "투자 후 기업 정보 공개 목록");
        model.addAttribute("contentsTitle","투자 후 기업 정보 공개 목록");

        return "user/mypage/investment/list/after_fund_revenue_list";
    }

    @GetMapping("/list/customer-invest")
    public String getCustomerInvestList(Model model) {

        model.addAttribute("title", "운영 후 투자자 손익 목록");
        model.addAttribute("contentsTitle","운영 후 투자자 손익 목록");

        return "user/mypage/investment/list/customer_invest_list";
    }

    @GetMapping("/list/after-invest-division")
    public String getAfterDivisionList(Model model) {

        model.addAttribute("title", "투자 후 분배 목록");
        model.addAttribute("contentsTitle","투자 후 분배 목록");

        return "user/mypage/investment/list/after_invest_division_list";
    }

    @GetMapping("/view/after-process")
    public String getAfterProcessView(Model model) {

        model.addAttribute("title", "투자 펀딩 후 진행정보");

        return "user/mypage/investment/view/invest_after_process_view";
    }

    @GetMapping("/view/after-fund-revenue")
    public String getAfterFundRevenueView(Model model) {

        model.addAttribute("title", "투자 후 기업 정보 공개");

        return "user/mypage/investment/view/after_fund_revenue_view";
    }

    @GetMapping("/view/customer-invest")
    public String getCustomerInvestView(Model model) {

        model.addAttribute("title", "운영 후 투자자 손익");

        return "user/mypage/investment/view/customer_invest_view";
    }

    @GetMapping("/view/after-invest-division")
    public String getAfterDivisionView(Model model) {

        model.addAttribute("title", "투자 후 분배");

        return "user/mypage/investment/view/after_invest_division_view";
    }

}