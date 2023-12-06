package ksmart.ks48team02.user.mapper.investment;

import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.user.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInvestmentMapper {

    public InvestmentInfo getInvPrjInfoByCode(String projectCode);

    // 투자 심사요청 등록
    public int addInvestmentJudge(InvestmentJudge investmentJudge);

    // 투자 프로젝트 등록
    public int addInvestment(InvestmentInfo investmentInfo);

    // 투자 프로젝트 상세내용 등록
    public int addInvestmentContent(InvestmentContent investmentContent);

    // 투자 프로젝트 조회
    public List<InvestmentInfo> getInvestmentInfo();

    // 상세페이지

    public InvestmentInfo investmentProjectDetail(String investmentCode);

    public SecuritiesIssuanceStock securitiesStock(String securitiesStock);
    public SecuritiesIssuanceBond securitiesBond(String securitiesBond);



    // 추천순, 최신순, 인기순, 모집금액순, 마감임박순 정렬
    public List<InvestmentInfo> getSortedList(String status, String securities, String orderBy);



    // 투자 업종 조회
    public List<UserCompanyBusinessType> getUserCompanyBusinessType();

    // 자본시장법 범위충족기준 조회
    public List<UserLawSatistifyReason> getUserLawSatistifyReason();

    // 새소식
    List<NewsList> getNewsList(String investmentCode);

    public NewsList getDetailNews(String newsCode);

    // 댓글 등록
    public void CommentAdd(String memberId, String investmentCode,String memberName,String commentContent);

    // 댓글 리스트
    public List<InvestmentComment> getCommentList(String investmentCode);

    // 대댓글 등록
    public void replyAdd(String reply, String investmentCode, String parentCommentCode, String memberId, String memberName);


    public CommentMember getMember(String memberId);

}