package ksmart.ks48team02.user.service.investment;

import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.user.dto.*;
import ksmart.ks48team02.user.mapper.investment.UserInvestmentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserInvestmentService {

    private final UserInvestmentMapper userInvestmentMapper;
    public UserInvestmentService(UserInvestmentMapper userInvestmentMapper) {
        this.userInvestmentMapper = userInvestmentMapper;
    }

    // 투자 심사요청 등록
    public void addInvestmentJudge(InvestmentJudge investmentJudge){

        System.out.println(investmentJudge);
        int addInvestmentJudge = userInvestmentMapper.addInvestmentJudge(investmentJudge);
        if (addInvestmentJudge <= 0) {
            System.out.println("투자 심사요청 등록에 실패했습니다.");
        }

    }

    // 투자 프로젝트 등록
    public void addInvestment(InvestmentInfo investmentInfo){

        System.out.println(investmentInfo);
        int addInvestment = userInvestmentMapper.addInvestment(investmentInfo);
        if (addInvestment <= 0) {
            System.out.println("투자 프로젝트 등록에 실패했습니다.");
        }

    }

    // 투자 프로젝트 상세 등록
    public void addInvestmentContent(InvestmentContent investmentContent){

        System.out.println(investmentContent);
        int addInvestmentContent = userInvestmentMapper.addInvestmentContent(investmentContent);
        if (addInvestmentContent <= 0) {
            System.out.println("투자 프로젝트 상세 등록에 실패했습니다.");
        }
    }

    // 투자 프로젝트 상세페이지
    public InvestmentInfo investmentProjectDetail(String investmentCode){

        InvestmentInfo investmentInfo = userInvestmentMapper.investmentProjectDetail(investmentCode);

        return investmentInfo;
    }

    public SecuritiesIssuanceStock securitiesStock(String securitiesStock){
        SecuritiesIssuanceStock securitiesIssuanceStock = userInvestmentMapper.securitiesStock(securitiesStock);
        return securitiesIssuanceStock;
    }

    public SecuritiesIssuanceBond securitiesBond(String securitiesBond){
        SecuritiesIssuanceBond securitiesIssuanceBond = userInvestmentMapper.securitiesBond(securitiesBond);
        return securitiesIssuanceBond;
    }

    public List<InvestmentInfo> getInvestmentInfo(){
        List<InvestmentInfo> investmentInfo = userInvestmentMapper.getInvestmentInfo();
        return investmentInfo;
    }



    public List<InvestmentInfo> getSortedList(String status, String securities, String orderBy) {
        return userInvestmentMapper.getSortedList(status, securities, orderBy);
    }

    public List<UserCompanyBusinessType> getUserCompanyBusinessType(){
        List<UserCompanyBusinessType> userCompanyBusinessType = userInvestmentMapper.getUserCompanyBusinessType();
        return userCompanyBusinessType;
    }

    public List<UserLawSatistifyReason> getUserLawSatistifyReason(){
        List<UserLawSatistifyReason> userLawSatistifyReason = userInvestmentMapper.getUserLawSatistifyReason();
        return userLawSatistifyReason;
    }

    public List<NewsList> getNewsList(String investmentCode){
        return userInvestmentMapper.getNewsList(investmentCode);
    }

    public NewsList getDetailNews(String newsCode){
        return userInvestmentMapper.getDetailNews(newsCode);
    }

    public void CommentAdd(String memberId, String investmentCode, String memberName, String commentContent){
        userInvestmentMapper.CommentAdd(memberId, investmentCode, memberName, commentContent);
    }

    public List<InvestmentComment> getCommentList(String investmentCode){
        return userInvestmentMapper.getCommentList(investmentCode);
    }

    public void replyAdd(String reply, String investmentCode, String parentCommentCode, String memberId, String memberName){
        userInvestmentMapper.replyAdd(reply, investmentCode, parentCommentCode, memberId, memberName);
    }


    public CommentMember getMember(String memberId){
        return userInvestmentMapper.getMember(memberId);
    }




}