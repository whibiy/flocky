package ksmart.ks48team02.seller.mapper.investment;

import ksmart.ks48team02.admin.dto.*;
import ksmart.ks48team02.seller.dto.*;
import ksmart.ks48team02.user.dto.InvestmentInfo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellerInvestmentMapper {

    // 판매자 투자펀딩 공고 목록 조회(페이징 x)
    public List<AdminInvestment> getInvestmentListOnly(String memberIdSeller);
    
    // 판매자 투자펀딩 공고 목록 조회
    public List<AdminInvestment> getInvestmentList(String memberIdSeller, int startRowNum, int rowPerPage);

    // 판매자 투자펀딩 공고 전체 행의 갯수
    public int getInvestment(String memberIdSeller);

    // 판매자 검색조건에 따른 투자펀딩 공고 목록 조회
    public List<AdminInvestment> getInvestmentListBySearch(String memberIdSeller, String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, String searchSelectValue, int startRowNum, int rowPerPage);

    // 판매자 특정 투자펀딩 공고 조회
    public AdminInvestment getInvestementByCode(String memberIdSeller, String investmentCode);

    // 판매자 투자펀딩 심사요청 목록 조회
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeList(String memberIdSeller, int startRowNum, int rowPerPage);

    // 판매자 투자펀딩 심사요청 전체 행의 갯수
    public int getInvestmentRequestJudgeCnt();

    // 판매자 검색조건에 따른 투자펀딩 심사요청 목록 조회
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeListBySearch(String memberIdSeller, String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, String searchSelectValue, int startRowNum, int rowPerPage);

    // 판매자 특정 투자펀딩 심사요청 조회
    public AdminInvestmentRequestJudge getInvestmentRequestJudgeByCode(String memberIdSeller, String investmentRequestJudgeCode);

    // 판매자 투자후 기업정보 공개(주식) 목록 조회
    public List<SellerAfterFundRevenueStock> getAfterFundRevenueStockList(String memberId, int startRowNum, int rowPerPage);

    // 판매자 투자후 기업정보 공개(주식) 전체 행의 갯수
    public int getAfterFundRevenueStockCnt();

    // 판매자 검색조건에 따른 투자후 기업정보 공개(주식) 목록 조회
    public List<SellerAfterFundRevenueStock> getAfterFundRevenueStockListBySearch(String memberId, String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, int startRowNum, int rowPerPage);

    // 판매자 특정 기업정보 공개(주식) 조회
    public SellerAfterFundRevenueStock getAfterFundRevenueStockByCode(String memberId, String afterFundRevenueStockCode);

    // 판매자 투자후 기업정보 공개(채권) 목록 조회
    public List<SellerAfterFundRevenueBond> getAfterFundRevenueBondList(String memberId, int startRowNum, int rowPerPage);

    // 판매자 특정 증권발행조건(주식) 조회
    public SellersecuritiesIssuanceStock getsecuritiesIssuanceStockListByCode(String memberId, String investmentCode);

    // 판매자 투자후 기업정보 공개(채권) 전체 행의 갯수
    public int getAfterFundRevenueBondCnt();

    // 판매자 검색조건에 따른 투자후 기업정보 공개(채권) 목록 조회
    public List<SellerAfterFundRevenueBond> getAfterFundRevenueBondListBySearch(String memberId, String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, int startRowNum, int rowPerPage);

    // 판매자 특정 기업정보 공개(채권) 조회
    public SellerAfterFundRevenueBond getAfterFundRevenueBondByCode(String memberId, String afterFundRevenueBondCode);

    // 판매자 투자 후 분배 목록 조회
    public List<SellerAfterInvestDivision> getAfterInvestDivision(String memberId, int startRowNum, int rowPerPage);

    // 판매자 투자 후 분배 전체 행의 갯수
    public int getAfterInvestDivisionCnt();

    // 판매자 검색조건에 따른 투자후 분배 목록 조회
    public List<SellerAfterInvestDivision> getAfterInvestDivisionBySearch(String memberId, String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, int startRowNum, int rowPerPage);

    // 판매자 자본시장법 범위충족기준 목록 조회
    public List<AdminLawSatistifyReason> getLawSatistifyList();

    // 판매자 부적합 업종 목록 조회
    public List<AdminIncongruitySectors> getIncogruitySectorsList();

    // 판매자 특정 기업가치 평가결과 조회
    public AdminCorporateValueEvaluation getCorporateValueEvaluationByCode(String corporateValueEvaluationCode);

    // 투자후 기업정보 공개(주식) 등록
    public int addAfterFundRevenueStock(SellerAfterFundRevenueStock sellerAfterFundRevenueStock);

    // 판매자 투자펀딩 공고 수정
    public int modifyInvestment(AdminInvestment adminInvestment);

    // 판매자 투자펀딩 공고 상세 수정
    public int modifyInvestmentContent(SellerInvestmentContent sellerInvestmentContent);

    // 판매자 투자펀딩 심사요청 수정
    public int modifyInvestmentRequestJudge(AdminInvestmentRequestJudge adminInvestmentRequestJudge);

    // 판매자 투자후 기업정보 공개(주식) 수정
    public int modifyAfterFundRevenueStock(SellerAfterFundRevenueStock sellerAfterFundRevenueStock);

    // 판매자 투자후 기업정보 공개(채권) 수정
    public int modifyAfterFundRevenueBond(SellerAfterFundRevenueBond sellerAfterFundRevenueBond);

    // 판매자 투자펀딩 공고 삭제
    public int removeInvestment(String investmentCode);

    // 판매자 투자펀딩 공고 상세 삭제
    public int removeInvestmentContent(String investmentContentCode);

    // 판매자 투자펀딩 심사요청 삭제
    public int removeInvestmentRequestJudge(String investmentRequestJudgeCode);

    // 판매자 투자후 기업정보 공개(주식) 삭제
    public int removeAfterFundRevenueStock(String afterFundRevenueStockCode);

    // 판매자 투자후 기업정보 공개(채권) 삭제
    public int removeAfterFundRevenueBond(String afterFundRevenueBondCode);

    public List<InvestmentInfo> getInvestmentInfo(String memberId);

    // 새소식
    public List<NewsList> getNews();
}
