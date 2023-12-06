package ksmart.ks48team02.admin.mapper.investment;

import java.util.List;

import ksmart.ks48team02.admin.dto.*;
import ksmart.ks48team02.seller.dto.SellerInvestmentContent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminInvestmentMapper {

    // 투자펀딩 공고 목록 조회
    public List<AdminInvestment> getInvestmentList(int startRowNum, int rowPerPage);

    // 투자펀딩 공고 전체 행의 갯수
    public int getInvestment(String memberIdSeller);

    // 검색조건에 따른 투자펀딩 공고 목록 조회
    public List<AdminInvestment> getInvestmentListBySearch(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, String searchSelectValue, int startRowNum, int rowPerPage);

    // 특정 투자펀딩 공고 조회
    public AdminInvestment getInvestementByCode(String investmentCode);

    // 투자펀딩 심사요청 목록 조회
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeListOnly();

    // 투자펀딩 심사요청 목록 조회(페이징)
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeList(int startRowNum, int rowPerPage);

    // 투자펀딩 심사요청 전체 행의 갯수
    public int getInvestmentRequestJudgeCnt();

    // 검색조건에 따른 투자펀딩 심사요청 목록 조회
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeListBySearch(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, String searchSelectValue, int startRowNum, int rowPerPage);

    // 특정 투자펀딩 심사요청 조회
    public AdminInvestmentRequestJudge getInvestmentRequestJudgeByCode(String investmentRequestJudgeCode);

    // 심사결과에 따른 특정 투자펀딩 심사요청 조회
    public List<AdminInvestmentRequestJudge> getInvestmentRequestJudgeByResult(String rejectCnt);

    // 자본시장법 범위충족기준 목록 조회
    public List<AdminLawSatistifyReason> getLawSatistifyList(int startRowNum, int rowPerPage);

    // 자본시장법 범위충족기준 전체 행의 갯수
    public int getLawSatistifyCnt();

    // 검색조건에 따른 자본시장법 범위충족기준 목록 조회
    public List<AdminLawSatistifyReason> getLawSatistifyListBySearch(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, int startRowNum, int rowPerPage);

    // 특정 자본시장 범위충족기준 조회
    public AdminLawSatistifyReason getLawSatistifyByCode(String lawSatistifyCode);

    // 부적합 업종 목록 조회
    public List<AdminIncongruitySectors> getIncogruitySectorsList(int startRowNum, int rowPerPage);

    // 부적합 업종 전체 행의 갯수
    public int getIncogruitySectorsCnt();

    // 검색조건에 따른 부적합 업종 목록 조회
    public List<AdminIncongruitySectors> getIncogruitySectorsListBySearch(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, int startRowNum, int rowPerPage);

    // 특정 부적합 업종 조회
    public AdminIncongruitySectors getIncogruitySectorsByCode(String incongruitySectorsCode);

    // 기업가치 평과결가 목록 조회
    public List<AdminCorporateValueEvaluation> getCorporateValueEvaluationList(int startRowNum, int rowPerPage);

    // 기업가치 평가결과 전체 행의 갯수
    public int getCorporateValueEvaluation();

    // 검색조건에 따른 기업가치 평과결가 목록 조회
    public List<AdminCorporateValueEvaluation> getCorporateValueEvaluationListBySearch(String searchKey, String searchValue, String amDateSettStartDate, String amDateSettEndDate, String searchSelectValue, int startRowNum, int rowPerPage);

    // 특정 기업가치 평가결과 조회
    public AdminCorporateValueEvaluation getCorporateValueEvaluationByCode(String corporateValueEvaluationCode);

    // 자본시장 범위충족기준 등록
    public int addLawSatistify(AdminLawSatistifyReason adminLawSatistifyReason);

    // 부적합 업종 등록
    public int addIncogruitySector(AdminIncongruitySectors adminIncongruitySectors);

    // 기업가치 평가결과 등록
    public int addCorporateValueEvaluation(AdminCorporateValueEvaluation adminCorporateValueEvaluation);

    // 투자펀딩 공고 수정
    public int modifyInvestment(AdminInvestment adminInvestment);

    // 투자펀딩 공고 상세 수정
    public int modifyInvestmentContent(SellerInvestmentContent sellerInvestmentContent);

    // 기업가치 평과결과 등록 후 심사요청 외래키 수정
    public int modifyInvestmentRequestCorpValueKey(AdminInvestmentRequestJudge adminInvestmentRequestJudge);

    // 투자펀딩 심사요청 수정
    public int modifyInvestmentRequestJudge(AdminInvestmentRequestJudge adminInvestmentRequestJudge);

    // 자본시장 범위충족기준 수정
    public int modifyLawSatistify(AdminLawSatistifyReason adminLawSatistifyReason);

    // 부적합 업종 수정
    public int modifyIncongruitySectors(AdminIncongruitySectors adminIncongruitySectors);

    // 기업가치 평가 결과 수정
    public int modifyCorporateValueEvaluation(AdminCorporateValueEvaluation adminCorporateValueEvaluation);

    // 투자펀딩 공고 삭제
    public int removeInvestment(String investmentCode);

    // 투자펀딩 공고 상세 삭제
    public int removeInvestmentContent(String investmentContentCode);

    // 투자펀딩 심사요청 삭제
    public int removeInvestmentRequestJudge(String investmentRequestJudgeCode);

    // 자본시장 범위충족기준 삭제
    public int removeLawSatistify(String lawSatistifyCode);

    // 부적합 업종 삭제
    public int removeIncogruitySectors(String incongruitySectorsCode);

    // 기업가치 평가 결과 삭제
    public int removeCorporateValueEvaluation(String corporateValueEvaluationCode);
}