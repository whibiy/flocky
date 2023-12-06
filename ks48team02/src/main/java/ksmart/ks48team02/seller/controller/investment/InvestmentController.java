package ksmart.ks48team02.seller.controller.investment;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.dto.*;
import ksmart.ks48team02.seller.dto.*;
import ksmart.ks48team02.seller.service.investment.InvestmentService;
import ksmart.ks48team02.user.dto.InvestmentInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller("sellerInvestmentController")
@RequestMapping("/seller/investment")
public class InvestmentController {

    // DI(의존성 주입)
    private final InvestmentService investmentService;

    // 생성자메소드를 통한 DI
    public InvestmentController(InvestmentService investmentService) {

        this.investmentService = investmentService;
    }

    @GetMapping("/invest-main")
    public String getInvestMain(Model model, HttpSession session
                               ,@RequestParam(name = "searchKey", required = false) String searchKey
                               ,@RequestParam(name = "searchValue", required = false, defaultValue = "") String searchValue
                               ,@RequestParam(name = "amDateSettStartDate", required = false) String amDateSettStartDate
                               ,@RequestParam(name = "amDateSettEndDate", required = false) String amDateSettEndDate
                               ,@RequestParam(name = "searchSelectValue", required = false, defaultValue = "") String searchSelectValue
                               ,@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage) {

        String loginId = (String) session.getAttribute("SID");

        Map<String, Object> resultMap = null;

        List<AdminInvestment> investmentList = null;

        if(searchKey != null) {
            resultMap = investmentService.getInvestmentList(loginId, searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, searchSelectValue, currentPage);
            investmentList = (List<AdminInvestment>) resultMap.get("investmentList");
        }else {
            resultMap = investmentService.getInvestmentList(loginId, currentPage);
            investmentList = (List<AdminInvestment>) resultMap.get("investmentList");
        }
        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");

        model.addAttribute("title", "판매자 : 투자 프로젝트");
        model.addAttribute("contentsTitle","투자 프로젝트");
        model.addAttribute("investmentList",investmentList);
        model.addAttribute("searchKey", searchKey);
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("amDateSettStartDate", amDateSettStartDate);
        model.addAttribute("amDateSettEndDate", amDateSettEndDate);
        model.addAttribute("searchSelectValue", searchSelectValue);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);

        return "seller/investment/invest_main";
    }

    @GetMapping("/search/judge")
    public String getInvestmentJudgeList(Model model
                                        ,@RequestParam(name = "searchKey", required = false) String searchKey
                                        ,@RequestParam(name = "searchValue", required = false, defaultValue = "") String searchValue
                                        ,@RequestParam(name = "amDateSettStartDate", required = false) String amDateSettStartDate
                                        ,@RequestParam(name = "amDateSettEndDate", required = false) String amDateSettEndDate
                                        ,@RequestParam(name = "searchSelectValue", required = false, defaultValue = "") String searchSelectValue
                                        ,@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage
                                        ,HttpSession session) {

        String loginId = (String) session.getAttribute("SID");

        Map<String, Object> resultMap = null;

        List<AdminInvestmentRequestJudge> investmentRequestJudgeList = null;

        if(searchKey != null) {
            resultMap = investmentService.getInvestmentRequestJudgeList(loginId, searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, searchSelectValue, currentPage);
            investmentRequestJudgeList = (List<AdminInvestmentRequestJudge>) resultMap.get("investmentRequestJudgeList");
        }else {
            resultMap = investmentService.getInvestmentRequestJudgeList(loginId, currentPage);
            investmentRequestJudgeList = (List<AdminInvestmentRequestJudge>) resultMap.get("investmentRequestJudgeList");
        }
        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");

        model.addAttribute("title", "판매자 : 투자 펀딩 심사 요청");
        model.addAttribute("contentsTitle","투자 펀딩 심사 요청");
        model.addAttribute("contentsSubTitle","투자 펀딩 심사 요청을 조회합니다");
        model.addAttribute("investmentRequestJudgeList", investmentRequestJudgeList);
        model.addAttribute("searchKey", searchKey);
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("amDateSettStartDate", amDateSettStartDate);
        model.addAttribute("amDateSettEndDate", amDateSettEndDate);
        model.addAttribute("searchSelectValue", searchSelectValue);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);

        return "seller/investment/list/invest_judge_list";
    }

    @GetMapping("/search/after-process")
    public String getInvestAfterProcessList(Model model) {

        model.addAttribute("title", "판매자 : 투자 펀딩후 진행정보");
        model.addAttribute("contentsTitle","투자 펀딩후 진행정보");

        return "seller/investment/list/invest_after_process_list";
    }

    @GetMapping("/search/after-fund-revenue")
    public String getAfterFundRevenueList(Model model
                                         ,@RequestParam(name = "searchKey", required = false) String searchKey
                                         ,@RequestParam(name = "searchValue", required = false, defaultValue = "") String searchValue
                                         ,@RequestParam(name = "amDateSettStartDate", required = false) String amDateSettStartDate
                                         ,@RequestParam(name = "amDateSettEndDate", required = false) String amDateSettEndDate
                                         ,@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage
                                         ,@RequestParam(name = "security", required = false, defaultValue = "stock") String security
                                         ,HttpSession session) {

        String loginId = (String) session.getAttribute("SID");

        Map<String, Object> resultMap = null;

        List<SellerAfterFundRevenueStock> sellerAfterFundRevenueStockList = null;

        List<SellerAfterFundRevenueBond> sellerAfterFundRevenueBondList = null;

        if(searchKey != null && Objects.equals(security, "stock")) {
            resultMap = investmentService.getAfterFundRevenueStockList(loginId, searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, currentPage);
            sellerAfterFundRevenueStockList = (List<SellerAfterFundRevenueStock>) resultMap.get("sellerAfterFundRevenueStockList");
        }else if(searchKey != null && Objects.equals(security, "bond")) {
            resultMap =  investmentService.getAfterFundRevenueBondList(loginId, searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, currentPage);
            sellerAfterFundRevenueBondList = (List<SellerAfterFundRevenueBond>) resultMap.get("sellerAfterFundRevenueBondList");
        }else if(searchKey == null && Objects.equals(security, "stock")) {
            resultMap = investmentService.getAfterFundRevenueStockList(loginId, currentPage);
            sellerAfterFundRevenueStockList = (List<SellerAfterFundRevenueStock>) resultMap.get("sellerAfterFundRevenueStockList");
        }else if(searchKey == null && Objects.equals(security, "bond")) {
            resultMap = investmentService.getAfterFundRevenueBondList(loginId, currentPage);
            sellerAfterFundRevenueBondList = (List<SellerAfterFundRevenueBond>) resultMap.get("sellerAfterFundRevenueBondList");
        }

        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");

        model.addAttribute("title", "판매자 : 투자후 기업정보 공개");
        model.addAttribute("contentsTitle","투자후 기업정보 공개");
        model.addAttribute("sellerAfterFundRevenueStockList", sellerAfterFundRevenueStockList);
        model.addAttribute("sellerAfterFundRevenueBondList", sellerAfterFundRevenueBondList);
        model.addAttribute("searchKey", searchKey);
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("amDateSettStartDate", amDateSettStartDate);
        model.addAttribute("amDateSettEndDate", amDateSettEndDate);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);

        return "seller/investment/list/after_fund_revenue_list";
    }

    @GetMapping("/search/customer-invest")
    public String getCustomerInvestList(Model model) {

        model.addAttribute("title", "판매자 : 운영후 투자자 손익");
        model.addAttribute("contentsTitle", "운영후 투자자 손익");

        return "seller/investment/list/customer_invest_list";
    }

    @GetMapping("/search/after-invest-division")
    public String getAfterInvestDivisionList(Model model
                                            ,@RequestParam(name = "searchKey", required = false) String searchKey
                                            ,@RequestParam(name = "searchValue", required = false, defaultValue = "") String searchValue
                                            ,@RequestParam(name = "amDateSettStartDate", required = false) String amDateSettStartDate
                                            ,@RequestParam(name = "amDateSettEndDate", required = false) String amDateSettEndDate
                                            ,@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage
                                            ,HttpSession session) {

        String loginId = (String) session.getAttribute("SID");

        Map<String, Object> resultMap = null;

        List<SellerAfterInvestDivision> sellerAfterInvestDivisionList = null;

        if(searchKey != null) {
            resultMap = investmentService.getAfterInvestDivisionBySearch(loginId, searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, currentPage);
            sellerAfterInvestDivisionList = (List<SellerAfterInvestDivision>) resultMap.get("sellerAfterInvestDivisionList");
        }else {
            resultMap = investmentService.getAfterInvestDivision(loginId, currentPage);
            sellerAfterInvestDivisionList = (List<SellerAfterInvestDivision>) resultMap.get("sellerAfterInvestDivisionList");
        }

        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");

        System.out.println(sellerAfterInvestDivisionList);

        model.addAttribute("title", "판매자 : 투자 후 분배");
        model.addAttribute("contentsTitle", "투자 후 분배");
        model.addAttribute("sellerAfterInvestDivisionList", sellerAfterInvestDivisionList);
        model.addAttribute("searchKey", searchKey);
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("amDateSettStartDate", amDateSettStartDate);
        model.addAttribute("amDateSettEndDate", amDateSettEndDate);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);

        return "seller/investment/list/after_invest_division_list";
    }

    @GetMapping("/view/investment")
    public String getInvestementByCode(Model model, String memberIdSeller, String investmentCode, HttpSession session) {

        String loginId = (String) session.getAttribute("SID");

        AdminInvestment investmentInfo = investmentService.getInvestementByCode(loginId, investmentCode);

        model.addAttribute("title", "판매자 : 투자펀딩 공고 상세");
        model.addAttribute("contentsTitle","투자펀딩 공고 상세");
        model.addAttribute("contentsSubTitle","투자펀딩 공고 상세 내용을 확인합니다");
        model.addAttribute("investmentInfo", investmentInfo);

        return "seller/investment/view/investment_view";
    }

    @GetMapping("/view/judge")
    public String getInvestmentJudge(@RequestParam(name = "investmentRequestJudgeCode") String investmentRequestJudgeCode,Model model, HttpSession session){

        String loginId = (String) session.getAttribute("SID");

        AdminInvestmentRequestJudge investmentRequestJudgeInfo = investmentService.getInvestmentRequestJudgeByCode(loginId, investmentRequestJudgeCode);

        model.addAttribute("title", "판매자 : 투자 펀딩 심사 요청 상세");
        model.addAttribute("contentsTitle","투자 펀딩 심사 요청 상세");
        model.addAttribute("contentsSubTitle","투자 펀딩 심사 요청 상세 내용을 확인 및 관리합니다");
        model.addAttribute("investmentRequestJudgeInfo", investmentRequestJudgeInfo);

        return "seller/investment/view/invest_judge_view";
    }

    @GetMapping("/view/after-process")
    public String getInvestAfterProcess(Model model) {

        model.addAttribute("title", "판매자 : 투자 펀딩후 진행정보 상세");
        model.addAttribute("contentsTitle","투자 펀딩후 진행정보 상세");

        return "seller/investment/view/invest_after_process_view";
    }

    @GetMapping("/view/after-fund-revenue")
    public String getAfterFundRevenue(@RequestParam(name = "afterFundRevenueStockCode", required = false) String afterFundRevenueStockCode
                                     ,@RequestParam(name = "afterFundRevenueBondCode", required = false) String afterFundRevenueBondCode
                                     ,Model model, HttpSession session) {

        String loginId = (String) session.getAttribute("SID");

        SellerAfterFundRevenueStock afterFundRevenueStockInfo = null;

        SellerAfterFundRevenueBond afterFundRevenueBondInfo = null;

        if(afterFundRevenueStockCode != null) {
            afterFundRevenueStockInfo = investmentService.getAfterFundRevenueStockByCode(loginId, afterFundRevenueStockCode);
        } else if(afterFundRevenueBondCode != null) {
            afterFundRevenueBondInfo = investmentService.getAfterFundRevenueBondByCode(loginId, afterFundRevenueBondCode);
        }

        model.addAttribute("title", "판매자 : 투자후 기업정보 공개 상세");
        model.addAttribute("contentsTitle","투자후 기업정보 공개 상세");
        model.addAttribute("afterFundRevenueStockInfo", afterFundRevenueStockInfo);
        model.addAttribute("afterFundRevenueBondInfo", afterFundRevenueBondInfo);

        return "seller/investment/view/after_fund_revenue_view";
    }

    @GetMapping("/view/customer-invest")
    public String getCustomerInvest(Model model) {

        model.addAttribute("title", "판매자 : 운영후 투자자 손익 상세");
        model.addAttribute("contentsTitle","운영후 투자자 손익 상세");

        return "seller/investment/view/customer_invest_view";
    }

    @GetMapping("/view/after-invest-division")
    public String getAfterInvestDivision(Model model) {

        model.addAttribute("title", "판매자 : 투자 후 분배 상세");
        model.addAttribute("contentsTitle", "투자 후 분배 상세");

        return "seller/investment/view/after_invest_division_view";
    }

    @GetMapping("/view/corporate-value")
    public String getCorporateValueEvaluation(@RequestParam(name = "corporateValueEvaluationCode") String corporateValueEvaluationCode, Model model){

        AdminCorporateValueEvaluation corporateValueEvaluationInfo = investmentService.getCorporateValueEvaluationByCode(corporateValueEvaluationCode);

        model.addAttribute("title", "판매자 : 기업가치 평가 결과 상세");
        model.addAttribute("contentsTitle","기업가치 평가 결과 상세");
        model.addAttribute("contentsSubTitle","기업가치 평가 결과 상세 내용을 확인합니다");
        model.addAttribute("corporateValueEvaluationInfo", corporateValueEvaluationInfo);

        return "seller/investment/view/corporate_value_evaluation_view";
    }

    @GetMapping("/insert/after-process")
    public String addInvestAfterProcess(Model model) {

        model.addAttribute("title", "판매자 : 투자 펀딩후 진행정보 등록");
        model.addAttribute("contentsTitle","투자 펀딩후 진행정보 등록");

        return "seller/investment/insert/invest_after_process_insert";
    }

    @GetMapping("/insert/after-fund-revenue")
    public String addAfterFundRevenue(Model model, HttpSession session) {

        String loginId = (String) session.getAttribute("SID");

        List<AdminInvestment> investmentList = investmentService.getInvestmentListOnly(loginId);

        model.addAttribute("title", "판매자 : 투자후 기업정보 공개 등록");
        model.addAttribute("contentsTitle","투자후 기업정보 공개 등록");
        model.addAttribute("investmentList", investmentList);

        return "seller/investment/insert/after_fund_revenue_insert";
    }

    @GetMapping("/insert/customer-invest")
    public String addCustomerInvest(Model model) {

        model.addAttribute("title", "판매자 : 운영후 투자자 손익 등록");
        model.addAttribute("contentsTitle","운영후 투자자 손익 등록");

        return "seller/investment/insert/customer_invest_insert";
    }

    @GetMapping("/insert/after-invest-division")
    public  String addAfterInvestDivision(Model model) {

        model.addAttribute("title", "판매자 : 투자후 분배 등록");
        model.addAttribute("contentsTitle","투자후 분배 등록");

        return "seller/investment/insert/after_invest_division_insert";
    }

    @GetMapping("/update/investment")
    public String modifyInvestment(Model model, String investmentCode, HttpSession session) {

        String loginId = (String) session.getAttribute("SID");

        AdminInvestment investmentInfo = investmentService.getInvestementByCode(loginId, investmentCode);

        model.addAttribute("title", "판매자 : 투자펀딩 공고 수정");
        model.addAttribute("contentsTitle","투자펀딩 공고 수정");
        model.addAttribute("investmentInfo", investmentInfo);

        return "seller/investment/update/investment_update";
    }

    @PostMapping("/update/investment")
    public String modifyInvestmentJudge(AdminInvestment adminInvestment, SellerInvestmentContent sellerInvestmentContent) {

        investmentService.modifyInvestment(adminInvestment);
        investmentService.modifyInvestmentContent(sellerInvestmentContent);

        return "redirect:/seller/investment/invest-main";
    }

    @GetMapping("/update/judge")
    public String modifyInvestmentJudge(@RequestParam(name = "investmentRequestJudgeCode") String investmentRequestJudgeCode, Model model, HttpSession session){

        String loginId = (String) session.getAttribute("SID");

        AdminInvestmentRequestJudge investmentRequestJudgeInfo = investmentService.getInvestmentRequestJudgeByCode(loginId, investmentRequestJudgeCode);
        List<AdminLawSatistifyReason> lawSatistifyReasonList = investmentService.getLawSatistifyList();
        List<AdminIncongruitySectors> incongruitySectorsList = investmentService.getIncogruitySectorsList();

        model.addAttribute("title", "판매자 : 투자펀딩 심사요청 수정");
        model.addAttribute("contentsTitle","투자펀딩 심사요청 수정");
        model.addAttribute("investmentRequestJudgeInfo", investmentRequestJudgeInfo);
        model.addAttribute("lawSatistifyReasonList", lawSatistifyReasonList);
        model.addAttribute("incongruitySectorsList", incongruitySectorsList);

        return "seller/investment/update/invest_judge_update";
    }

    @PostMapping("/update/judge")
    public String modifyInvestmentJudge(AdminInvestmentRequestJudge adminInvestmentRequestJudge) {

        investmentService.modifyInvestmentRequestJudge(adminInvestmentRequestJudge);
        return "redirect:/seller/investment/search/judge";
    }

    @GetMapping("/update/after-process")
    public String modifyInvestAfterProcess(Model model) {

        model.addAttribute("title", "판매자 : 투자 펀딩후 진행정보 수정");
        model.addAttribute("contentsTitle","투자 펀딩후 진행정보 수정");

        return "seller/investment/update/invest_after_process_update";
    }

    @GetMapping("/update/after-fund-revenue")
    public String modifyAfterFundRevenue(@RequestParam(name = "afterFundRevenueStockCode", required = false) String afterFundRevenueStockCode
                                        ,@RequestParam(name = "afterFundRevenueBondCode", required = false) String afterFundRevenueBondCode
                                        ,Model model, HttpSession session) {

        String loginId = (String) session.getAttribute("SID");

        SellerAfterFundRevenueStock afterFundRevenueStockInfo = null;

        SellerAfterFundRevenueBond afterFundRevenueBondInfo = null;

        if(afterFundRevenueStockCode != null) {
            afterFundRevenueStockInfo = investmentService.getAfterFundRevenueStockByCode(loginId, afterFundRevenueStockCode);
        } else if(afterFundRevenueBondCode != null) {
            afterFundRevenueBondInfo = investmentService.getAfterFundRevenueBondByCode(loginId, afterFundRevenueBondCode);
        }

        model.addAttribute("title", "판매자 : 투자후 기업정보 공개 수정");
        model.addAttribute("contentsTitle","투자후 기업정보 공개 수정");
        model.addAttribute("afterFundRevenueStockInfo", afterFundRevenueStockInfo);
        model.addAttribute("afterFundRevenueBondInfo", afterFundRevenueBondInfo);

        return "seller/investment/update/after_fund_revenue_update";
    }

    @PostMapping("/update/after-fund-revenue-stock")
    public String modifyAfterFundRevenue(SellerAfterFundRevenueStock sellerAfterFundRevenueStock) {

        investmentService.modifyAfterFundRevenueStock(sellerAfterFundRevenueStock);

        return "redirect:/seller/investment/search/after-fund-revenue";
    }

    @PostMapping("/update/after-fund-revenue-bond")
    public String modifyAfterFundRevenue(SellerAfterFundRevenueBond sellerAfterFundRevenueBond) {

        investmentService.modifyAfterFundRevenueBond(sellerAfterFundRevenueBond);

        return "redirect:/seller/investment/search/after-fund-revenue";
    }

    @GetMapping("/update/customer-invest")
    public String modifyCustomerInvest(Model model) {

        model.addAttribute("title", "판매자 : 운영후 투자자 손익 수정");
        model.addAttribute("contentsTitle","운영후 투자자 손익 수정");

        return "seller/investment/update/customer_invest_update";
    }

    @GetMapping("/update/after-invest-division")
    public String modifyAfterInvestDivision(Model model) {

        model.addAttribute("title", "판매자 : 투자후 분배 수정");
        model.addAttribute("contentsTitle","투자후 분배 수정");

        return "seller/investment/update/after_invest_division_update";
    }

    @GetMapping("/news")
    public String newsManagementPage(Model model,
                                     HttpSession session) {

        model.addAttribute("title", "판매자 : 투자 새소식");
        model.addAttribute("contentsTitle", "투자 새소식");
        String memberId = (String)session.getAttribute("SID");
        List<InvestmentInfo> investmentInfo = investmentService.getInvestmentInfo(memberId);
        model.addAttribute("investmentInfo", investmentInfo);
        List<NewsList> newsList = investmentService.getNews();
        model.addAttribute("newsList", newsList);

        return "seller/investment/news/main";
    }


    @GetMapping("/comment")
    public String getInvestComment(Model model) {

        model.addAttribute("title", "판매자 : 투자 댓글관리");
        model.addAttribute("contentsTitle", "투자 댓글관리");

        return "seller/investment/comment/main";
    }

    @GetMapping("/delete/investment")
    public String removeInvestment(@RequestParam(value = "investmentCode") String investmentCode
                                  ,@RequestParam(value = "investmentContentCode") String investmentContentCode
                                  ,Model model) {

        investmentService.removeInvestment(investmentCode, investmentContentCode);

        model.addAttribute("investmentCode", investmentCode);
        model.addAttribute("investmentContentCode",investmentContentCode);

        return "redirect:/seller/investment/invest-main";
    }

    @PostMapping("/delete/investment")
    public String removeInvestment(@RequestParam(value = "investmentCode") String investmentCode
                                  ,@RequestParam(value = "investmentContentCode") String investmentContentCode
                                  ,RedirectAttributes redirectAttributes) {

        investmentService.removeInvestment(investmentCode, investmentContentCode);

        redirectAttributes.addAttribute("investmentCode", investmentCode);
        redirectAttributes.addAttribute("investmentContentCode", investmentContentCode);

        return "redirect:/seller/investment/invest-main";
    }

    @GetMapping("/delete/judge")
    public String reomveInvestmentJudge(@RequestParam(value = "investmentRequestJudgeCode") String investmentRequestJudgeCode, Model model) {

        investmentService.reomveInvestmentJudge(investmentRequestJudgeCode);

        model.addAttribute("title", "판매자 : 투자펀딩 심사요청 삭제");
        model.addAttribute("contentsTitle","투자펀딩 심사요청 삭제");
        model.addAttribute("investmentRequestJudgeCode", investmentRequestJudgeCode);

        return "redirect:/seller/investment/search/judge";
    }

    @PostMapping("/delete/judge")
    public String reomveInvestmentJudge(@RequestParam(value = "investmentRequestJudgeCode") String investmentRequestJudgeCode, RedirectAttributes redirectAttributes) {

        investmentService.reomveInvestmentJudge(investmentRequestJudgeCode);

        redirectAttributes.addAttribute("investmentRequestJudgeCode", investmentRequestJudgeCode);

        return "redirect:/seller/investment/search/judge";
    }

    @GetMapping("/delete/after-fund-revenue")
    public String removeAfterFundRevenue(@RequestParam(value = "afterFundRevenueStockCode", required = false) String afterFundRevenueStockCode
                                        ,@RequestParam(value = "afterFundRevenueBondCode", required = false) String afterFundRevenueBondCode
                                        ,Model model) {

        if(afterFundRevenueStockCode != null) {
            investmentService.removeAfterFundRevenueStock(afterFundRevenueStockCode);
        }
        else if(afterFundRevenueBondCode != null) {
            investmentService.removeAfterFundRevenueBond(afterFundRevenueBondCode);
        }

        model.addAttribute("afterFundRevenueStockCode", afterFundRevenueStockCode);
        model.addAttribute("afterFundRevenueBondCode", afterFundRevenueBondCode);

        return "redirect:/seller/investment/search/after-fund-revenue";
    }

    @PostMapping("/delete/after-fund-revenue")
    public String removeAfterFundRevenue(@RequestParam(value = "afterFundRevenueStockCode", required = false) String afterFundRevenueStockCode
                                        ,@RequestParam(value = "afterFundRevenueBondCode", required = false) String afterFundRevenueBondCode
                                        ,RedirectAttributes redirectAttributes) {

        if(afterFundRevenueStockCode != null) {
            investmentService.removeAfterFundRevenueStock(afterFundRevenueStockCode);
        }
        else if(afterFundRevenueBondCode != null) {
            investmentService.removeAfterFundRevenueBond(afterFundRevenueBondCode);
        }

        redirectAttributes.addAttribute("afterFundRevenueStockCode", afterFundRevenueStockCode);
        redirectAttributes.addAttribute("afterFundRevenueBondCode", afterFundRevenueBondCode);

        return "redirect:/seller/investment/search/after-fund-revenue";
    }

    @GetMapping("/check/{investmentCode}")
    @ResponseBody
    public AdminInvestment getInvestmentDetail(@PathVariable(value = "investmentCode", required = false) String investmentCode, HttpSession session, Model model) {

        String loginId = (String) session.getAttribute("SID");

        AdminInvestment investmentDetail = investmentService.getInvestementByCode(loginId, investmentCode);

        return investmentDetail;
    }

}
