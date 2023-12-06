package ksmart.ks48team02.seller.service.reward;


import ksmart.ks48team02.seller.dto.PreMember;
import ksmart.ks48team02.seller.mapper.reward.SellerRewardMapper;
import ksmart.ks48team02.user.dto.RewardProject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@AllArgsConstructor
public class SellerRewardService {

    SellerRewardMapper sellerRewardMapper;

    //로그인한 회원 아이디 별 프로젝트 조회
    public Map<String,Object> projectListBySellerID (Map<String,Object> inquirMap){

        // 보여줄 행의 갯수
        int rowPerPage = 10;
        // 현재 페이지 수.
        int currentPage = (int) inquirMap.get("currentPage");
        // 보여줄 행의 시작점
        int startRowNum = (currentPage - 1) * rowPerPage;
        // 전체 행의 갯수
        double rowCnt = sellerRewardMapper.projectPageCnt(inquirMap);
        // 마지막페이지: (전체 행의 갯수/보여줄 행의 갯수) 올림
        int lastPage = (int) Math.ceil(rowCnt/rowPerPage);

        // 보여줄 페이지 번호 초기값:1
        int startPageNum = 1;
        // 마지막 페이지 번호 초기값:10
        int endPageNum = (lastPage < 10) ? lastPage : 10;

        // 동적으로 페이지번호 구성
        if( currentPage > 6 && lastPage > 9) {
            startPageNum = currentPage - 5;
            endPageNum = currentPage + 4;
            if( endPageNum >= lastPage) {
                startPageNum = lastPage - 9;
                endPageNum = lastPage;
            }
        }
        inquirMap.put("startRowNum",startRowNum);
        inquirMap.put("rowPerPage",rowPerPage);
        List<RewardProject> projectList = sellerRewardMapper.projectListBySellerID(inquirMap);

        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("projectList",projectList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);
        resultMap.put("rowCnt", rowCnt);


        return resultMap;
    }

    //프로젝트 시작하기.
    public void startProject(String rewardProjectCode){
        sellerRewardMapper.startProject(rewardProjectCode);
    }

    //로그인 한 회원 아이디별 새소식 조회
    public List<RewardProject> getNewsListBySellerId (String sellerId) {

        List<RewardProject> newsListPerProject = sellerRewardMapper.getNewsListBySellerId(sellerId);
        System.out.println(newsListPerProject);

        return newsListPerProject;
    }

    //사전체험단 추가시 가입된 회원인지 검사
    public int preMemberIdCheck(String memberId) {
        return sellerRewardMapper.preMemberIdCheck(memberId);
    }

    //사전체험단 이미 등록된 회원인지 검사
    public int preMemberRegCheck(String memberId){ return sellerRewardMapper.preMemberRegCheck(memberId); }

    //사전체험단 등록
    public void regPreMember(String storeCode, String memberId, String startDate, String endDate) {
     sellerRewardMapper.regPreMember(storeCode, memberId, startDate, endDate);
    }

    //사전체험단 삭제
    public void delPreMember(String memberId){
        sellerRewardMapper.delPreMember(memberId);
    }

    //사전체험단 조회
    public List<PreMember> preMemberList (String storeCode){
        return sellerRewardMapper.preMemberList(storeCode);
    }
}
