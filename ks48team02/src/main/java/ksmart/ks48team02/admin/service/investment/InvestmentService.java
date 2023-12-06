package ksmart.ks48team02.admin.service.investment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import ksmart.ks48team02.admin.dto.*;
import ksmart.ks48team02.seller.dto.SellerAfterFundRevenueStock;
import ksmart.ks48team02.seller.dto.SellerInvestmentContent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart.ks48team02.admin.mapper.investment.AdminInvestmentMapper;

@Service("adminInvestmemtService")
@Transactional
public class InvestmentService {

    // DI(의존성 주입)
    private final AdminInvestmentMapper adminInvestmentMapper;

    // 생성자메소드를 통한 DI
    public InvestmentService(AdminInvestmentMapper adminInvestmentMapper){

        this.adminInvestmentMapper = adminInvestmentMapper;
    }

    // 투자펀딩 공고 조회
    public Map<String, Object> getInvestmentList(int currentPage) {

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = adminInvestmentMapper.getInvestmentRequestJudgeCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminInvestment> investmentList = adminInvestmentMapper.getInvestmentList(startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("investmentList", investmentList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 검색조건에 따른 투자펀딩 공고 조회
    public Map<String, Object> getInvestmentList(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, String searchSelectValue, int currentPage) {

        switch (searchKey) {
            case "investmentCode":
                searchKey = "i.investment_code";
                break;
            case "investmentRequestJudgeCode":
                searchKey = "i.investment_request_judge_code";
                break;
            case "memberIdSeller":
                searchKey = "i.member_id_seller";
                break;
            case "investmentSubject":
                searchKey = "i.investment_subject";
                break;
            case "investmentCompany":
                searchKey = "i.investment_company";
                break;
            case "securitiesClassification":
                searchKey = "i.securities_classification";
                break;
            case "investJudgeSituation":
                searchKey = "i.invest_judge_situation";
                break;
        }

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = adminInvestmentMapper.getInvestmentRequestJudgeCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminInvestment> investmentList = adminInvestmentMapper.getInvestmentListBySearch(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, searchSelectValue, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("investmentList", investmentList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 판매자 특정 투자펀딩 공고 조회
    public AdminInvestment getInvestementByCode(String investmentCode) {
        AdminInvestment investmentInfo = adminInvestmentMapper.getInvestementByCode(investmentCode);

        return investmentInfo;
    }

    // 투자펀딩 심사요청 목록 조회
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeListOnly() {
        List<AdminInvestmentRequestJudge> investmentRequestJudgeInfoOnly = adminInvestmentMapper.getInvestmentRequestJudgeListOnly();

        return investmentRequestJudgeInfoOnly;
    }

    // 투자펀딩 심사요청 목록 조회(페이징)
    public Map<String, Object> getInvestmentRequestJudgeList(int currentPage) {

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = adminInvestmentMapper.getInvestmentRequestJudgeCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminInvestmentRequestJudge> investmentRequestJudgeList = adminInvestmentMapper.getInvestmentRequestJudgeList(startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("investmentRequestJudgeList", investmentRequestJudgeList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;

    }

    // 검색조건에 따른 투자펀딩 심사요청 목록 조회
    public Map<String, Object> getInvestmentRequestJudgeList(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, String searchSelectValue, int currentPage) {
        switch (searchKey) {
            case "investmentRequestJudgeCode":
                searchKey = "i.investment_request_judge_code";
                break;
            case "investmentRequestSubject":
                searchKey = "i.investment_request_subject";
                break;
            case "memberIdSeller":
                searchKey = "i.member_id_seller";
                break;
            case "storeName":
                searchKey = "s.store_name";
                break;
            case "investmentCompany":
                searchKey = "i.investment_company";
                break;
            case "representativeName":
                searchKey = "s.representative_name";
                break;
            case "investJudgeResult":
                searchKey = "i.invest_judge_result";
                break;
        }

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = adminInvestmentMapper.getInvestmentRequestJudgeCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminInvestmentRequestJudge> investmentRequestJudgeList = adminInvestmentMapper.getInvestmentRequestJudgeListBySearch(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, searchSelectValue, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("investmentRequestJudgeList", investmentRequestJudgeList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 특정 투자펀딩 심사요청 조회
    public AdminInvestmentRequestJudge getInvestmentRequestJudgeByCode(String investmentRequestJudgeCode) {
        AdminInvestmentRequestJudge investmentRequestJudgeInfo = adminInvestmentMapper.getInvestmentRequestJudgeByCode(investmentRequestJudgeCode);

        return investmentRequestJudgeInfo;
    }

    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeByResult(String rejectCnt) {
        List<AdminInvestmentRequestJudge> investmentRequestJudgeInfoByResult = adminInvestmentMapper.getInvestmentRequestJudgeByResult(rejectCnt);

        return investmentRequestJudgeInfoByResult;
    }

    // 자본시장법 범위충족기준 목록 조회
    public Map<String, Object> getLawSatistifyList(int currentPage) {

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = adminInvestmentMapper.getLawSatistifyCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminLawSatistifyReason> lawSatistifyReasonList = adminInvestmentMapper.getLawSatistifyList(startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("lawSatistifyReasonList", lawSatistifyReasonList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 검색조건에 따른 자본시장법 범위충족기준 목록 조회
    public Map<String, Object> getLawSatistifyList(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, int currentPage) {

        switch (searchKey) {
            case "lawSatistifyCode":
                searchKey = "l.law_satistify_code";
                break;
            case "lawSatistifyReason":
                searchKey = "l.law_satistify_reason";
                break;
            case "memberId":
                searchKey = "l.member_id";
                break;
        }

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = adminInvestmentMapper.getLawSatistifyCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminLawSatistifyReason> lawSatistifyReasonList = adminInvestmentMapper.getLawSatistifyListBySearch(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("lawSatistifyReasonList", lawSatistifyReasonList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 특정 자본시장법 범위충족기준 조회
    public AdminLawSatistifyReason getLawSatistifyByCode(String lawSatistifyCode) {
        AdminLawSatistifyReason lawSatistifyInfo = adminInvestmentMapper.getLawSatistifyByCode(lawSatistifyCode);

        return lawSatistifyInfo;
    }

    // 부적합 업종 목록 조회
    public Map<String, Object> getIncogruitySectorsList(int currentPage) {

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = adminInvestmentMapper.getIncogruitySectorsCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminIncongruitySectors> incongruitySectorsList = adminInvestmentMapper.getIncogruitySectorsList(startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("incongruitySectorsList", incongruitySectorsList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 검색조건에 따른 부적합 업종 목록
    public Map<String, Object> getIncogruitySectorsList(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, int currentPage) {
        switch (searchKey) {
            case "incongruitySectorsCode":
                searchKey = "i.incongruity_sectors_code";
                break;
            case "incongruitySectorsBusiness":
                searchKey = "i.incongruity_sectors_business";
                break;
            case "memberId":
                searchKey = "i.member_id";
                break;
        }

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = adminInvestmentMapper.getIncogruitySectorsCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminIncongruitySectors> incongruitySectorsList = adminInvestmentMapper.getIncogruitySectorsListBySearch(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("incongruitySectorsList", incongruitySectorsList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 특정 부적합 업종 조회
    public AdminIncongruitySectors getIncogruitySectorsByCode(String incongruitySectorsCode) {
        AdminIncongruitySectors incongruitySectorsInfo = adminInvestmentMapper.getIncogruitySectorsByCode(incongruitySectorsCode);

        return incongruitySectorsInfo;
    }

    // 기업가치 평가결과 목록 조회
    public Map<String, Object> getCorporateValueEvaluationList(int currentPage) {

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = adminInvestmentMapper.getCorporateValueEvaluation();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminCorporateValueEvaluation> corporateValueEvaluationList = adminInvestmentMapper.getCorporateValueEvaluationList(startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("corporateValueEvaluationList", corporateValueEvaluationList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 검색조건에 따른 기업가치 평가결과 목록 조회
    public Map<String, Object> getCorporateValueEvaluationList(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, String searchSelectValue, int currentPage) {
        switch (searchKey) {
            case "investmentRequestJudgeCode":
                searchKey = "i.investment_request_judge_code";
                break;
            case "investmentRequestSubject":
                searchKey = "i.investment_request_subject";
                break;
            case "memberIdSeller":
                searchKey = "i.member_id_seller";
                break;
            case "corporateValueEvaluationCode":
                searchKey = "c.corporate_value_evaluation_code";
                break;
            case "memberId":
                searchKey = "c.member_id";
                break;
            case "corpValueFulfill":
                searchKey = "c.corp_value_fulfill";
                break;
        }

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = adminInvestmentMapper.getCorporateValueEvaluation();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminCorporateValueEvaluation> corporateValueEvaluationList = adminInvestmentMapper.getCorporateValueEvaluationListBySearch(searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, searchSelectValue, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("corporateValueEvaluationList", corporateValueEvaluationList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 특정 기업가치 평가결과 조회
    public AdminCorporateValueEvaluation getCorporateValueEvaluationByCode(String corporateValueEvaluationCode) {
        AdminCorporateValueEvaluation corporateValueEvaluationInfo = adminInvestmentMapper.getCorporateValueEvaluationByCode(corporateValueEvaluationCode);

        return  corporateValueEvaluationInfo;
    }

    // 자본시장법 범위충족기준 등록
    public void addLawSatistify(AdminLawSatistifyReason adminLawSatistifyReason) {
        adminInvestmentMapper.addLawSatistify(adminLawSatistifyReason);
    }

    // 부적합 업종 등록
    public void addIncogruitySector(AdminIncongruitySectors adminIncongruitySectors) {
        adminInvestmentMapper.addIncogruitySector(adminIncongruitySectors);
    }

    // 기업가치 평가결과 등록
    public void addCorporateValueEvaluation(AdminCorporateValueEvaluation adminCorporateValueEvaluation) {
        adminInvestmentMapper.addCorporateValueEvaluation(adminCorporateValueEvaluation);
    }

    // 기업가치 평가 등록 후 심사요청에 평가코드 등록
    public void modifyInvestmentRequestCorpValueKey(AdminInvestmentRequestJudge adminInvestmentRequestJudge) {
        adminInvestmentMapper.modifyInvestmentRequestCorpValueKey(adminInvestmentRequestJudge);
    }

    // 투자펀딩 공고 수정
    public void modifyInvestment(AdminInvestment adminInvestment) {
        adminInvestmentMapper.modifyInvestment(adminInvestment);
    }

    // 판매자 투자펀딩 공고 상세 수정
    public void modifyInvestmentContent(SellerInvestmentContent sellerInvestmentContent) {
        adminInvestmentMapper.modifyInvestmentContent(sellerInvestmentContent);
    }

    // 투자펀딩 심사요청 수정
    public void modifyInvestmentRequestJudge(AdminInvestmentRequestJudge adminInvestmentRequestJudge) {
        adminInvestmentMapper.modifyInvestmentRequestJudge(adminInvestmentRequestJudge);
    }

    // 자본시장법 범위충족기준 수정
    public void modifyLawSatistify(AdminLawSatistifyReason adminLawSatistifyReason) {
        adminInvestmentMapper.modifyLawSatistify(adminLawSatistifyReason);
    }

    // 부적합 업종 수정
    public void modifyIncongruitySectors(AdminIncongruitySectors adminIncongruitySectors) {
        adminInvestmentMapper.modifyIncongruitySectors(adminIncongruitySectors);
    }

    // 기업가치 평가 수정
    public void modifyCorporateValueEvaluation(AdminCorporateValueEvaluation adminCorporateValueEvaluation) {
        adminInvestmentMapper.modifyCorporateValueEvaluation(adminCorporateValueEvaluation);
    }

    // 투자펀딩 공고 삭제
    public void removeInvestment(String investmentCode, String investmentContentCode) {

        adminInvestmentMapper.removeInvestmentContent(investmentContentCode);
        adminInvestmentMapper.removeInvestment(investmentCode);
    }

    // 투자펀딩 심사요청 삭제
    public void reomveInvestmentJudge(String investmentRequestJudgeCode) {
        adminInvestmentMapper.removeInvestmentRequestJudge(investmentRequestJudgeCode);
    }

    // 자본시장 범위충족기준 삭제
    public void removeLawSatistify(String lawSatistifyCode) {
        adminInvestmentMapper.removeLawSatistify(lawSatistifyCode);
    }

    // 부적합 업종 삭제
    public void removeIncogruitySectors(String incongruitySectorsCode) {
        adminInvestmentMapper.removeIncogruitySectors(incongruitySectorsCode);
    }

    // 기업가치 평가 결과 삭제
    public void removeCorporateValueEvaluation(String corporateValueEvaluationCode) {
        adminInvestmentMapper.removeCorporateValueEvaluation(corporateValueEvaluationCode);
    }

    // 페이징 처리
    private Map<String, Integer> calculatePagingInfo(int currentPage, double rowCnt, int rowPerpage) {

        // 보여줄 행의 시작점
        int startRowNum = (currentPage - 1) * rowPerpage;

        // 마지막페이지: (전체 행의 갯수/보여줄 행의 갯수) 올림처리
        int lastPage = (int) Math.ceil(rowCnt / rowPerpage);

        // 보여줄 페이지 번호 초기값:1
        int startPageNum = 1;

        // 마지막 페이지 번호 초기값:10(10 미만일경우 마지막페이지만큼)
        int endPageNum = (lastPage < 10) ? lastPage : 10;

        // 동적으로 페이지번호 구성
        if (currentPage > 6 && lastPage > 9) {
            startPageNum = currentPage - 5;
            endPageNum = currentPage + 4;
            if (endPageNum >= lastPage) {
                startPageNum = lastPage - 9;
                endPageNum = lastPage;
            }
        }

        Map<String, Integer> pagingInfo = new HashMap<>();
        pagingInfo.put("startRowNum", startRowNum);
        pagingInfo.put("lastPage", lastPage);
        pagingInfo.put("startPageNum", startPageNum);
        pagingInfo.put("endPageNum", endPageNum);

        return pagingInfo;
    }

}