package ksmart.ks48team02.admin.controller.judgement;

import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.dto.*;
import ksmart.ks48team02.seller.dto.SellerInvestmentContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ksmart.ks48team02.admin.service.investment.InvestmentService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("judgementInvestmentController")
@RequestMapping("/admin/investment")
public class InvestmentController {

    // DI(의존성 주입)
    private final InvestmentService investmentService;

    //생성자메소드를 통한 DI
    public InvestmentController(InvestmentService investmentService){

        this.investmentService = investmentService;
    }

    @GetMapping("/search/investment")
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
            resultMap = investmentService.getInvestmentList(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, searchSelectValue, currentPage);
            investmentList = (List<AdminInvestment>) resultMap.get("investmentList");
        }else {
            resultMap = investmentService.getInvestmentList(currentPage);
            investmentList = (List<AdminInvestment>) resultMap.get("investmentList");
        }
        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");

        model.addAttribute("title", "관리자 : 투자 프로젝트");
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

        return "admin/judgement/investment/list/invesment_list";
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

        session.setAttribute("searchKey", searchKey);
        session.setAttribute("searchValue", searchValue);
        session.setAttribute("amDateSettStartDate", amDateSettStartDate);
        session.setAttribute("amDateSettEndDate", amDateSettEndDate);
        session.setAttribute("searchSelectValue", searchSelectValue);
        
        Map<String, Object> resultMap = null;

        List<AdminInvestmentRequestJudge> investmentRequestJudgeList = null;

        if(searchKey != null) {
            resultMap = investmentService.getInvestmentRequestJudgeList(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, searchSelectValue, currentPage);
            investmentRequestJudgeList = (List<AdminInvestmentRequestJudge>) resultMap.get("investmentRequestJudgeList");
        }else {
            resultMap = investmentService.getInvestmentRequestJudgeList(currentPage);
            investmentRequestJudgeList = (List<AdminInvestmentRequestJudge>) resultMap.get("investmentRequestJudgeList");
        }
        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");

        model.addAttribute("title", "관리자 : 투자 펀딩 심사 요청");
        model.addAttribute("contentsTitle","투자 펀딩 심사 요청");
        model.addAttribute("contentsSubTitle","투자 펀딩 심사 요청을 관리합니다");
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

        return "admin/judgement/investment/list/invest_jduge_list";
    }

    @GetMapping("/search/law-satistify")
    public String getLawSatistifyList(Model model
                                     ,@RequestParam(name = "searchKey", required = false) String searchKey
                                     ,@RequestParam(name = "searchValue", required = false, defaultValue = "") String searchValue
                                     ,@RequestParam(name = "amDateSettStartDate", required = false) String amDateSettStartDate
                                     ,@RequestParam(name = "amDateSettEndDate", required = false) String amDateSettEndDate
                                     ,@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage){

        Map<String, Object> resultMap = null;

        List<AdminLawSatistifyReason> lawSatistifyReasonList = null;

        if(searchKey != null) {
            resultMap = investmentService.getLawSatistifyList(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, currentPage);
            lawSatistifyReasonList = (List<AdminLawSatistifyReason>) resultMap.get("lawSatistifyReasonList");
        }else {
            resultMap = investmentService.getLawSatistifyList(currentPage);
            lawSatistifyReasonList = (List<AdminLawSatistifyReason>) resultMap.get("lawSatistifyReasonList");
        }
        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");

        model.addAttribute("title", "관리자 : 자본시장법 범위충족기준");
        model.addAttribute("contentsTitle","자본시장법 범위충족기준");
        model.addAttribute("contentsSubTitle","자본시장법 범위충족기준을 관리합니다");
        model.addAttribute("lawSatistifyReasonList", lawSatistifyReasonList);
        model.addAttribute("searchKey", searchKey);
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("amDateSettStartDate", amDateSettStartDate);
        model.addAttribute("amDateSettEndDate", amDateSettEndDate);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);

        return "admin/judgement/investment/list/law_satistify_list";
    }

    @GetMapping("/search/incongruity-sectors")
    public String getIncongruitySectorsList(Model model
                                           ,@RequestParam(name = "searchKey", required = false) String searchKey
                                           ,@RequestParam(name = "searchValue", required = false, defaultValue = "") String searchValue
                                           ,@RequestParam(name = "amDateSettStartDate", required = false) String amDateSettStartDate
                                           ,@RequestParam(name = "amDateSettEndDate", required = false) String amDateSettEndDate
                                           ,@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage){

        Map<String, Object> resultMap = null;

        List<AdminIncongruitySectors> incongruitySectorsList = null;

        if(searchKey != null) {
            resultMap = investmentService.getIncogruitySectorsList(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, currentPage);
            incongruitySectorsList = (List<AdminIncongruitySectors>) resultMap.get("incongruitySectorsList");
        }else {
            resultMap = investmentService.getIncogruitySectorsList(currentPage);
            incongruitySectorsList = (List<AdminIncongruitySectors>) resultMap.get("incongruitySectorsList");
        }
        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");

        model.addAttribute("title", "관리자 : 부적합 업종");
        model.addAttribute("contentsTitle","부적합 업종");
        model.addAttribute("contentsSubTitle","부적합 업종을 관리합니다");
        model.addAttribute("incongruitySectorsList", incongruitySectorsList);
        model.addAttribute("searchKey", searchKey);
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("amDateSettStartDate", amDateSettStartDate);
        model.addAttribute("amDateSettEndDate", amDateSettEndDate);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);

        return "admin/judgement/investment/list/incongruity_sectors_list";
    }

    @GetMapping("/search/corporate-value")
    public String getCorporateValueEvaluationList(Model model
                                                 ,@RequestParam(name = "searchKey", required = false) String searchKey
                                                 ,@RequestParam(name = "searchValue", required = false, defaultValue = "") String searchValue
                                                 ,@RequestParam(name = "amDateSettStartDate", required = false) String amDateSettStartDate
                                                 ,@RequestParam(name = "amDateSettEndDate", required = false) String amDateSettEndDate
                                                 ,@RequestParam(name = "searchSelectValue", required = false, defaultValue = "") String searchSelectValue
                                                 ,@RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage) {

        Map<String, Object> resultMap = null;

        List<AdminCorporateValueEvaluation> corporateValueEvaluationList = null;

        if(searchKey != null) {
            resultMap = investmentService.getCorporateValueEvaluationList(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, searchSelectValue, currentPage);
            corporateValueEvaluationList = (List<AdminCorporateValueEvaluation>) resultMap.get("corporateValueEvaluationList");
        }else {
            resultMap = investmentService.getCorporateValueEvaluationList(currentPage);
            corporateValueEvaluationList = (List<AdminCorporateValueEvaluation>) resultMap.get("corporateValueEvaluationList");
        }
        int lastPage = (int) resultMap.get("lastPage");
        int startPageNum = (int) resultMap.get("startPageNum");
        int endPageNum = (int) resultMap.get("endPageNum");

        model.addAttribute("title", "관리자 : 기업가치 평가");
        model.addAttribute("contentsTitle","기업가치 평가");
        model.addAttribute("contentsSubTitle","기업가치 평가를 관리합니다");
        model.addAttribute("corporateValueEvaluationList", corporateValueEvaluationList);
        model.addAttribute("searchKey", searchKey);
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("amDateSettStartDate", amDateSettStartDate);
        model.addAttribute("amDateSettEndDate", amDateSettEndDate);
        model.addAttribute("searchSelectValue", searchSelectValue);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPage", lastPage);
        model.addAttribute("startPageNum", startPageNum);
        model.addAttribute("endPageNum", endPageNum);

        return "admin/judgement/investment/list/corporate_value_evaluation_list";
    }

    @GetMapping("/view/investment")
    public String getInvestementByCode(Model model, String investmentCode, HttpSession session) {

        AdminInvestment investmentInfo = investmentService.getInvestementByCode(investmentCode);

        model.addAttribute("title", "관리자 : 투자펀딩 공고 상세");
        model.addAttribute("contentsTitle","투자펀딩 공고 상세");
        model.addAttribute("contentsSubTitle","투자펀딩 공고 상세 내용을 확인합니다");
        model.addAttribute("investmentInfo", investmentInfo);

        return "admin/judgement/investment/view/investment_view";
    }

    @GetMapping("/view/judge")
    public String getInvestmentJudge(@RequestParam(name = "investmentRequestJudgeCode") String investmentRequestJudgeCode,Model model){

        AdminInvestmentRequestJudge investmentRequestJudgeInfo = investmentService.getInvestmentRequestJudgeByCode(investmentRequestJudgeCode);

        model.addAttribute("title", "관리자 : 투자 펀딩 심사 요청 상세");
        model.addAttribute("contentsTitle","투자 펀딩 심사 요청 상세");
        model.addAttribute("contentsSubTitle","투자 펀딩 심사 요청 상세 내용을 확인 및 관리합니다");
        model.addAttribute("investmentRequestJudgeInfo", investmentRequestJudgeInfo);

        return "admin/judgement/investment/view/invest_jduge_view";
    }

    @GetMapping("/view/law-satistify")
    public String getLawSatistify(@RequestParam(name = "lawSatistifyCode") String lawSatistifyCode, Model model){

        AdminLawSatistifyReason lawSatistifyInfo = investmentService.getLawSatistifyByCode(lawSatistifyCode);

        model.addAttribute("title", "관리자 : 자본시장법 범위충족기준 상세");
        model.addAttribute("contentsTitle","자본시장법 범위충족기준 상세");
        model.addAttribute("contentsSubTitle","자본시장법 범위충족기준 상세 내용을 확인 및 관리합니다");
        model.addAttribute("lawSatistifyInfo", lawSatistifyInfo);

        return "admin/judgement/investment/view/law_satistify_view";
    }

    @GetMapping("/view/incongruity-sectors")
    public String getIncongruitySectors(@RequestParam(name = "incongruitySectorsCode") String incongruitySectorsCode, Model model){

        AdminIncongruitySectors incongruitySectorsInfo = investmentService.getIncogruitySectorsByCode(incongruitySectorsCode);

        model.addAttribute("title", "관리자 : 부적합 업종 상세");
        model.addAttribute("contentsTitle","부적합 업종 상세");
        model.addAttribute("contentsSubTitle","부적합 업종 상세 내용을 확인 및 관리합니다");
        model.addAttribute("incongruitySectorsInfo", incongruitySectorsInfo);

        return "admin/judgement/investment/view/incongruity_sectors_view";
    }

    @GetMapping("/view/corporate-value")
    public String getCorporateValueEvaluation(@RequestParam(name = "corporateValueEvaluationCode") String corporateValueEvaluationCode, Model model){

        AdminCorporateValueEvaluation corporateValueEvaluationInfo = investmentService.getCorporateValueEvaluationByCode(corporateValueEvaluationCode);

        model.addAttribute("title", "관리자 : 기업가치 평가 결과 상세");
        model.addAttribute("contentsTitle","기업가치 평가 결과 상세");
        model.addAttribute("contentsSubTitle","기업가치 평가 결과 상세 내용을 확인 및 관리합니다");
        model.addAttribute("corporateValueEvaluationInfo", corporateValueEvaluationInfo);

        return "admin/judgement/investment/view/corporate_value_evaluation_view";
    }

    @GetMapping("/insert/law-satistify")
    public String addLawSatistify(Model model) {

        model.addAttribute("title", "관리자 : 자본시장법 범위충족기준 등록");
        model.addAttribute("contentsTitle","자본시장법 범위충족기준 등록");

        return "admin/judgement/investment/insert/law_satistify_insert";
    }

    @PostMapping("/insert/law-satistify")
    public String addLawSatistify(AdminLawSatistifyReason adminLawSatistifyReason) {

        investmentService.addLawSatistify(adminLawSatistifyReason);
        return "redirect:/admin/investment/search/law-satistify";
    }

    @GetMapping("/insert/incongruity-sectors")
    public String addIncongruitySectors(Model model){

        model.addAttribute("title", "관리자 : 부적합 업종 등록");
        model.addAttribute("contentsTitle","부적합 업종 등록");

        return "admin/judgement/investment/insert/incongruity_sectors_insert";
    }

    @PostMapping("/insert/incongruity-sectors")
    public String addIncongruitySectors(AdminIncongruitySectors adminIncongruitySectors) {

        investmentService.addIncogruitySector(adminIncongruitySectors);
        return "redirect:/admin/investment/search/incongruity-sectors";
    }

    @GetMapping("/insert/corporate-value")
    public String addCorporateValueEvaluation(Model model) {

        List<AdminInvestmentRequestJudge> investmentRequestJudgeList = investmentService.getInvestmentRequestJudgeListOnly();

        model.addAttribute("title", "관리자 : 기업가치 평가 결과 등록");
        model.addAttribute("contentsTitle","기업가치 평가 결과 등록");
        model.addAttribute("investmentRequestJudgeList",investmentRequestJudgeList);

        return "admin/judgement/investment/insert/corporate_value_evaluation_insert";
    }

    @PostMapping("/insert/corporate-value")
    public String addCorporateValueEvaluation(AdminCorporateValueEvaluation adminCorporateValueEvaluation, AdminInvestmentRequestJudge adminInvestmentRequestJudge) {

        investmentService.addCorporateValueEvaluation(adminCorporateValueEvaluation);
        investmentService.modifyInvestmentRequestCorpValueKey(adminInvestmentRequestJudge);
        return "redirect:/admin/investment/search/corporate-value";
    }

    @GetMapping("/update/investment")
    public String modifyInvestment(Model model, String investmentCode, HttpSession session) {

        AdminInvestment investmentInfo = investmentService.getInvestementByCode(investmentCode);

        model.addAttribute("title", "관리자 : 투자펀딩 공고 수정");
        model.addAttribute("contentsTitle","투자펀딩 공고 수정");
        model.addAttribute("investmentInfo", investmentInfo);

        return "admin/judgement/investment/update/investment_update";
    }

    @PostMapping("/update/investment")
    public String modifyInvestmentJudge(AdminInvestment adminInvestment, SellerInvestmentContent sellerInvestmentContent) {

        investmentService.modifyInvestment(adminInvestment);
        investmentService.modifyInvestmentContent(sellerInvestmentContent);

        return "redirect:/admin/investment/search/investment";
    }

    @GetMapping("/update/judge")
    public String modifyInvestmentJudge(@RequestParam(name = "investmentRequestJudgeCode") String investmentRequestJudgeCode, Model model, @RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage){

        AdminInvestmentRequestJudge investmentRequestJudgeInfo = investmentService.getInvestmentRequestJudgeByCode(investmentRequestJudgeCode);

        Map<String, Object> resultMap = investmentService.getInvestmentRequestJudgeList(currentPage);

        List<AdminLawSatistifyReason> lawSatistifyReasonList = (List<AdminLawSatistifyReason>) resultMap.get("lawSatistifyReasonList");
        List<AdminIncongruitySectors> incongruitySectorsList = (List<AdminIncongruitySectors>) resultMap.get("incongruitySectorsList");

        model.addAttribute("title", "관리자 : 투자펀딩 심사요청 수정");
        model.addAttribute("contentsTitle","투자펀딩 심사요청 수정");
        model.addAttribute("investmentRequestJudgeInfo", investmentRequestJudgeInfo);
        model.addAttribute("lawSatistifyReasonList", lawSatistifyReasonList);
        model.addAttribute("incongruitySectorsList", incongruitySectorsList);

        return "admin/judgement/investment/update/invest_jduge_update";
    }

    @PostMapping("/update/judge")
    public String modifyInvestmentJudge(AdminInvestmentRequestJudge adminInvestmentRequestJudge) {

        investmentService.modifyInvestmentRequestJudge(adminInvestmentRequestJudge);
        return "redirect:/admin/investment/search/judge";
    }

    @GetMapping("/update/law-satistify")
    public String modifyLawSatistify(@RequestParam(name = "lawSatistifyCode") String lawSatistifyCode, Model model){

        AdminLawSatistifyReason lawSatistifyInfo = investmentService.getLawSatistifyByCode(lawSatistifyCode);

        model.addAttribute("title", "관리자 : 자본시장법 범위충족기준 수정");
        model.addAttribute("contentsTitle","자본시장법 범위충족기준 수정");
        model.addAttribute("lawSatistifyInfo", lawSatistifyInfo);

        return "admin/judgement/investment/update/law_satistify_update";
    }

    @PostMapping("/update/law-satistify")
    public String modifyLawSatistify(AdminLawSatistifyReason adminLawSatistifyReason) {

        investmentService.modifyLawSatistify(adminLawSatistifyReason);
        return "redirect:/admin/investment/search/law-satistify";
    }

    @GetMapping("/update/incongruity-sectors")
    public String modifyIncongruitySectors(@RequestParam(name = "incongruitySectorsCode") String incongruitySectorsCode ,Model model){

        AdminIncongruitySectors incongruitySectorsInfo = investmentService.getIncogruitySectorsByCode(incongruitySectorsCode);

        model.addAttribute("title", "관리자 : 부적합 업종 수정");
        model.addAttribute("contentsTitle","부적합 업종 수정");
        model.addAttribute("incongruitySectorsInfo", incongruitySectorsInfo);

        return "admin/judgement/investment/update/incongruity_sectors_update";
    }

    @PostMapping("/update/incongruity-sectors")
    public String modifyIncongruitySectors(AdminIncongruitySectors adminIncongruitySectors) {

        investmentService.modifyIncongruitySectors(adminIncongruitySectors);
        return "redirect:/admin/investment/search/incongruity-sectors";
    }

    @GetMapping("/update/corporate-value")
    public String modifyCorporateValueEvaluation(@RequestParam(name = "corporateValueEvaluationCode") String corporateValueEvaluationCode, Model model) {

        AdminCorporateValueEvaluation corporateValueEvaluationInfo = investmentService.getCorporateValueEvaluationByCode(corporateValueEvaluationCode);

        model.addAttribute("title", "관리자 : 기업가치 평가 결과 수정");
        model.addAttribute("contentsTitle","기업가치 평가 결과 수정");
        model.addAttribute("corporateValueEvaluationInfo", corporateValueEvaluationInfo);

        return "admin/judgement/investment/update/corporate_value_evaluation_update";
    }

    @PostMapping("/update/corporate-value")
    public String modifyCorporateValueEvaluation(AdminCorporateValueEvaluation adminCorporateValueEvaluation) {

        investmentService.modifyCorporateValueEvaluation(adminCorporateValueEvaluation);
        return "redirect:/admin/investment/search/corporate-value";
    }

    @GetMapping("/delete/investment")
    public String removeInvestment(@RequestParam(value = "investmentCode") String investmentCode
            ,@RequestParam(value = "investmentContentCode") String investmentContentCode
            ,Model model) {

        investmentService.removeInvestment(investmentCode, investmentContentCode);

        model.addAttribute("investmentCode", investmentCode);
        model.addAttribute("investmentContentCode",investmentContentCode);

        return "redirect:/admin/investment/search/investment";
    }

    @PostMapping("/delete/investment")
    public String removeInvestment(@RequestParam(value = "investmentCode") String investmentCode
            ,@RequestParam(value = "investmentContentCode") String investmentContentCode
            ,RedirectAttributes redirectAttributes) {

        investmentService.removeInvestment(investmentCode, investmentContentCode);

        redirectAttributes.addAttribute("investmentCode", investmentCode);
        redirectAttributes.addAttribute("investmentContentCode", investmentContentCode);

        return "redirect:/admin/investment/search/investment";
    }

    @GetMapping("/delete/judge")
    public String reomveInvestmentJudge(@RequestParam(value = "investmentRequestJudgeCode") String investmentRequestJudgeCode, Model model) {

        investmentService.reomveInvestmentJudge(investmentRequestJudgeCode);

        model.addAttribute("title", "관리자 : 투자펀딩 심사요청 삭제");
        model.addAttribute("contentsTitle","투자펀딩 심사요청 삭제");
        model.addAttribute("investmentRequestJudgeCode", investmentRequestJudgeCode);

        return "redirect:/admin/investment/search/judge";
    }

    @PostMapping("/delete/judge")
    public String reomveInvestmentJudge(@RequestParam(value = "investmentRequestJudgeCode") String investmentRequestJudgeCode, RedirectAttributes redirectAttributes) {

        investmentService.reomveInvestmentJudge(investmentRequestJudgeCode);

        redirectAttributes.addAttribute("investmentRequestJudgeCode", investmentRequestJudgeCode);

        return "redirect:/admin/investment/search/judge";
    }

    @GetMapping("/delete/law-satistify")
    public String removeLawSatistify(@RequestParam(value = "lawSatistifyCode") String lawSatistifyCode, Model model) {

        investmentService.removeLawSatistify(lawSatistifyCode);

        model.addAttribute("title", "관리자 : 자본시장법 범위충족기준 삭제");
        model.addAttribute("contentsTitle", "자본시장법 범위충족기준 삭제");
        model.addAttribute("lawSatistifyCode", lawSatistifyCode);

        return "redirect:/admin/investment/search/law-satistify";
    }

    @PostMapping("/delete/law-satistify")
    public String removeLawSatistify(@RequestParam(value = "lawSatistifyCode") String lawSatistifyCode, RedirectAttributes redirectAttributes) {

        investmentService.removeLawSatistify(lawSatistifyCode);

        redirectAttributes.addAttribute("lawSatistifyCode", lawSatistifyCode);

        return "redirect:/admin/investment/search/law-satistify";
    }

    @GetMapping("/delete/incongruity-sectors")
    public String removeIncongruitySectors(@RequestParam(value = "incongruitySectorsCode") String incongruitySectorsCode, Model model) {

        investmentService.removeIncogruitySectors(incongruitySectorsCode);

        model.addAttribute("title", "관리자 : 부적합 업종 삭제");
        model.addAttribute("contentsTitle","부적합 업종 삭제");
        model.addAttribute("incongruitySectorsCode", incongruitySectorsCode);

        return "redirect:/admin/investment/search/incongruity-sectors";
    }

    @PostMapping("/delete/incongruity-sectors")
    public String removeIncongruitySectors(@RequestParam(value = "incongruitySectorsCode") String incongruitySectorsCode, RedirectAttributes redirectAttributes) {

        investmentService.removeIncogruitySectors(incongruitySectorsCode);

        redirectAttributes.addAttribute("incongruitySectorsCode", incongruitySectorsCode);

        return "redirect:/admin/investment/search/incongruity-sectors";
    }

    @GetMapping("/delete/corporate-value")
    public String removeCorporateValueEvaluation(@RequestParam(value = "corporateValueEvaluationCode") String corporateValueEvaluationCode, Model model) {

        investmentService.removeCorporateValueEvaluation(corporateValueEvaluationCode);

        model.addAttribute("title", "관리자 : 기업가치 평가 결과 삭제");
        model.addAttribute("contentsTitle","기업가치 평가 결과 삭제");
        model.addAttribute("corporateValueEvaluationCode", corporateValueEvaluationCode);

        return "redirect:/admin/investment/search/corporate-value";
    }

    @PostMapping("/delete/corporate-value")
    public String removeCorporateValueEvaluation(@RequestParam(value = "corporateValueEvaluationCode") String corporateValueEvaluationCode, RedirectAttributes redirectAttributes) {

        investmentService.removeCorporateValueEvaluation(corporateValueEvaluationCode);

        redirectAttributes.addAttribute("corporateValueEvaluationCode", corporateValueEvaluationCode);

        return "redirect:/admin/investment/search/corporate-value";
    }

    @GetMapping("/check/{investmentRequestJudgeCode}")
    @ResponseBody
    public AdminInvestmentRequestJudge getInvestmentRequestJudgeDetail(@PathVariable(value = "investmentRequestJudgeCode", required = false) String investmentRequestJudgeCode) {

        AdminInvestmentRequestJudge investmentRequestJudgeDetail = investmentService.getInvestmentRequestJudgeByCode(investmentRequestJudgeCode);
        return investmentRequestJudgeDetail;
    }

}