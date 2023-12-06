package ksmart.ks48team02.seller.service.investment;

import ksmart.ks48team02.admin.dto.*;
import ksmart.ks48team02.seller.dto.*;
import ksmart.ks48team02.seller.mapper.investment.SellerInvestmentMapper;
import ksmart.ks48team02.user.dto.AllDonationInfo;
import ksmart.ks48team02.user.dto.InvestmentInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sellerInvestmemtService")
@Transactional
public class InvestmentService {

    // DI(의존성 주입)
    private final SellerInvestmentMapper sellerInvestmentMapper;

    // 생성자메소드를 통한 DI
    public InvestmentService(SellerInvestmentMapper sellerInvestmentMapper){

        this.sellerInvestmentMapper = sellerInvestmentMapper;
    }

    //  판매자 투자펀딩 공고 목록 조회(페이징 x)
    public List<AdminInvestment> getInvestmentListOnly(String memberIdSeller) {
        List<AdminInvestment> investmentListOnly = sellerInvestmentMapper.getInvestmentListOnly(memberIdSeller);

        return investmentListOnly;
    }

    // 판매자 투자펀딩 공고 목록 조회
    public Map<String, Object> getInvestmentList(String memberIdSeller, int currentPage) {

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = sellerInvestmentMapper.getInvestmentRequestJudgeCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminInvestment> investmentList = sellerInvestmentMapper.getInvestmentList(memberIdSeller, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("investmentList", investmentList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 판매자 검색조건에 따른 투자펀딩 공고 조회
    public Map<String, Object> getInvestmentList(String memberIdSeller, String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, String searchSelectValue, int currentPage) {

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
        double rowCnt = sellerInvestmentMapper.getInvestmentRequestJudgeCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminInvestment> investmentList = sellerInvestmentMapper.getInvestmentListBySearch(memberIdSeller, searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, searchSelectValue, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("investmentList", investmentList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 판매자 특정 투자펀딩 공고 조회
    public AdminInvestment getInvestementByCode(String memberIdSeller, String investmentCode) {
        AdminInvestment investmentInfo = sellerInvestmentMapper.getInvestementByCode(memberIdSeller, investmentCode);

        return investmentInfo;
    }

    // 판매자 투자펀딩 심사요청 목록 조회
    public Map<String, Object> getInvestmentRequestJudgeList(String memberIdSeller, int currentPage) {

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = sellerInvestmentMapper.getInvestmentRequestJudgeCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminInvestmentRequestJudge> investmentRequestJudgeList = sellerInvestmentMapper.getInvestmentRequestJudgeList(memberIdSeller, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("investmentRequestJudgeList", investmentRequestJudgeList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;

    }

    // 판매자 검색조건에 따른 투자펀딩 심사요청 목록 조회
    public Map<String, Object> getInvestmentRequestJudgeList(String memberIdSeller, String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, String searchSelectValue, int currentPage) {

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
        double rowCnt = sellerInvestmentMapper.getInvestmentRequestJudgeCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<AdminInvestmentRequestJudge> investmentRequestJudgeList = sellerInvestmentMapper.getInvestmentRequestJudgeListBySearch(memberIdSeller, searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, searchSelectValue, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("investmentRequestJudgeList", investmentRequestJudgeList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 판매자 특정 투자펀딩 심사요청 조회
    public AdminInvestmentRequestJudge getInvestmentRequestJudgeByCode(String memberIdSeller, String investmentRequestJudgeCode) {
        AdminInvestmentRequestJudge investmentRequestJudgeInfo = sellerInvestmentMapper.getInvestmentRequestJudgeByCode(memberIdSeller, investmentRequestJudgeCode);

        return investmentRequestJudgeInfo;
    }

    // 판매자 투자후 기업정보 공개(주식) 목록 조회
    public  Map<String, Object> getAfterFundRevenueStockList(String memberId, int currentPage) {

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = sellerInvestmentMapper.getAfterFundRevenueStockCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<SellerAfterFundRevenueStock> sellerAfterFundRevenueStockList = sellerInvestmentMapper.getAfterFundRevenueStockList(memberId, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sellerAfterFundRevenueStockList", sellerAfterFundRevenueStockList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 판매자 검색조건에 따른 투자후 기업정보 공개(주식) 목록 조회
    public  Map<String, Object> getAfterFundRevenueStockList(String memberId, String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, int currentPage) {

        switch (searchKey) {
            case "afterFundRevenueCode":
                searchKey = "af.after_fund_revenue_stock_code";
                break;
            case "memberId":
                searchKey = "af.member_id";
                break;
            case "investmentCode":
                searchKey = "af.investment_code";
                break;
        }

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = sellerInvestmentMapper.getAfterFundRevenueStockCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<SellerAfterFundRevenueStock> sellerAfterFundRevenueStockList = sellerInvestmentMapper.getAfterFundRevenueStockListBySearch(memberId, searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sellerAfterFundRevenueStockList", sellerAfterFundRevenueStockList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 판매자 특정 기업정보 공개(주식) 조회
    public SellerAfterFundRevenueStock getAfterFundRevenueStockByCode(String memberId, String afterFundRevenueStockCode) {
        SellerAfterFundRevenueStock afterFundRevenueStockInfo = sellerInvestmentMapper.getAfterFundRevenueStockByCode(memberId, afterFundRevenueStockCode);

        return afterFundRevenueStockInfo;
    }

    // 판매자 투자후 기업정보 공개(채권) 목록 조회
    public  Map<String, Object> getAfterFundRevenueBondList(String memberId, int currentPage) {

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = sellerInvestmentMapper.getAfterFundRevenueBondCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<SellerAfterFundRevenueBond> sellerAfterFundRevenueBondList = sellerInvestmentMapper.getAfterFundRevenueBondList(memberId, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sellerAfterFundRevenueBondList", sellerAfterFundRevenueBondList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 판매자 검색조건에 따른 투자후 기업정보 공개(채권) 목록 조회
    public  Map<String, Object> getAfterFundRevenueBondList(String memberId, String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, int currentPage) {

        switch (searchKey) {
            case "afterFundRevenueCode":
                searchKey = "af.after_fund_revenue_bond_code";
                break;
            case "memberId":
                searchKey = "af.member_id";
                break;
            case "investmentCode":
                searchKey = "af.investment_code";
                break;
        }

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = sellerInvestmentMapper.getAfterFundRevenueBondCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<SellerAfterFundRevenueBond> sellerAfterFundRevenueBondList = sellerInvestmentMapper.getAfterFundRevenueBondListBySearch(memberId, searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sellerAfterFundRevenueBondList", sellerAfterFundRevenueBondList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 판매자 특정 기업정보 공개(채권) 조회
    public SellerAfterFundRevenueBond getAfterFundRevenueBondByCode(String memberId, String afterFundRevenueBondCode) {
        SellerAfterFundRevenueBond afterFundRevenueBondInfo = sellerInvestmentMapper.getAfterFundRevenueBondByCode(memberId, afterFundRevenueBondCode);

        return afterFundRevenueBondInfo;
    }

    // 판매자 특정 증권발행조건(주식) 조회
    public SellersecuritiesIssuanceStock getsecuritiesIssuanceStockListByCode(String memberId, String investmentCode) {
        SellersecuritiesIssuanceStock securitiesIssuanceStockInfo = sellerInvestmentMapper.getsecuritiesIssuanceStockListByCode(memberId, investmentCode);

        return securitiesIssuanceStockInfo;
    }

    // 판매자 자본시장법 범위충족기준 목록 조회
    public List<AdminLawSatistifyReason> getLawSatistifyList() {
        List<AdminLawSatistifyReason> lawSatistifyReasonList = sellerInvestmentMapper.getLawSatistifyList();

        return lawSatistifyReasonList;
    }

    // 판매자 투자후 분배 목록 조회
    public Map<String, Object> getAfterInvestDivision(String memberId, int currentPage) {

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = sellerInvestmentMapper.getAfterInvestDivisionCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<SellerAfterInvestDivision> sellerAfterInvestDivisionList = sellerInvestmentMapper.getAfterInvestDivision(memberId, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("sellerAfterInvestDivisionList", sellerAfterInvestDivisionList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 판매자 검색조건에 따른 투자후 분배 목록 조회
    public Map<String, Object> getAfterInvestDivisionBySearch(String memberId, String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, int currentPage) {

        switch (searchKey) {
            case "afterInvestDivisionCode":
                searchKey = "a.after_invest_division_code";
                break;
            case "memberId":
                searchKey = "a.member_id";
                break;
            case "investmentCode":
                searchKey = "a.investment_code";
                break;
        }

        // 보여줄 행의 갯수
        int rowPerpage = 15;

        // 전체 행의 갯수
        double rowCnt = sellerInvestmentMapper.getAfterInvestDivisionCnt();

        Map<String, Integer> pagingInfo = calculatePagingInfo(currentPage, rowCnt, rowPerpage);

        int startRowNum = pagingInfo.get("startRowNum");
        int lastPage = pagingInfo.get("lastPage");
        int startPageNum = pagingInfo.get("startPageNum");
        int endPageNum = pagingInfo.get("endPageNum");

        List<SellerAfterInvestDivision> sellerAfterInvestDivisionList = sellerInvestmentMapper.getAfterInvestDivisionBySearch(memberId, searchKey, searchValue, amDateSettStartDate, amDateSettEndDate, startRowNum, rowPerpage);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("sellerAfterInvestDivisionList", sellerAfterInvestDivisionList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);

        return resultMap;
    }

    // 판매자 부적합 업종 목록 조회
    public List<AdminIncongruitySectors> getIncogruitySectorsList() {
        List<AdminIncongruitySectors> incongruitySectorsList = sellerInvestmentMapper.getIncogruitySectorsList();

        return incongruitySectorsList;
    }

    // 판매자 특정 기업가치 평가결과 조회
    public AdminCorporateValueEvaluation getCorporateValueEvaluationByCode(String corporateValueEvaluationCode) {
        AdminCorporateValueEvaluation corporateValueEvaluationInfo = sellerInvestmentMapper.getCorporateValueEvaluationByCode(corporateValueEvaluationCode);

        return  corporateValueEvaluationInfo;
    }

    // 판매자 투자펀딩 공고 수정
    public void modifyInvestment(AdminInvestment adminInvestment) {
        sellerInvestmentMapper.modifyInvestment(adminInvestment);
    }

    // 판매자 투자펀딩 공고 상세 수정
    public void modifyInvestmentContent(SellerInvestmentContent sellerInvestmentContent) {
        sellerInvestmentMapper.modifyInvestmentContent(sellerInvestmentContent);
    }

    // 판매자 투자펀딩 심사요청 수정
    public void modifyInvestmentRequestJudge(AdminInvestmentRequestJudge adminInvestmentRequestJudge) {
        sellerInvestmentMapper.modifyInvestmentRequestJudge(adminInvestmentRequestJudge);
    }

    // 판매자 투자후 기업정보 공개(주식) 수정
    public void modifyAfterFundRevenueStock(SellerAfterFundRevenueStock sellerAfterFundRevenueStock) {
        sellerInvestmentMapper.modifyAfterFundRevenueStock(sellerAfterFundRevenueStock);
    }

    // 판매자 투자후 기업정보 공개(주식) 수정
    public void modifyAfterFundRevenueBond(SellerAfterFundRevenueBond sellerAfterFundRevenueBond) {
        sellerInvestmentMapper.modifyAfterFundRevenueBond(sellerAfterFundRevenueBond);
    }

    // 판매자 투자펀딩 공고 삭제
    public void removeInvestment(String investmentCode, String investmentContentCode) {

        sellerInvestmentMapper.removeInvestmentContent(investmentContentCode);
        sellerInvestmentMapper.removeInvestment(investmentCode);
    }

    // 판매자 투자펀딩 심사요청 삭제
    public void reomveInvestmentJudge(String investmentRequestJudgeCode) {
        sellerInvestmentMapper.removeInvestmentRequestJudge(investmentRequestJudgeCode);
    }

    // 판매자 투자후 기업정보 공개(주식) 삭제
    public void removeAfterFundRevenueStock(String afterFundRevenueStockCode) {
        sellerInvestmentMapper.removeAfterFundRevenueStock(afterFundRevenueStockCode);
    }

    public void removeAfterFundRevenueBond(String afterFundRevenueBondCode) {
        sellerInvestmentMapper.removeAfterFundRevenueBond(afterFundRevenueBondCode);
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

    public List<InvestmentInfo> getInvestmentInfo(String memberId){
        List<InvestmentInfo> investmentInfo = sellerInvestmentMapper.getInvestmentInfo(memberId);
        return investmentInfo;
    }

    // 새소식
    public List<NewsList> getNews(){
        return sellerInvestmentMapper.getNews();
    };


}
