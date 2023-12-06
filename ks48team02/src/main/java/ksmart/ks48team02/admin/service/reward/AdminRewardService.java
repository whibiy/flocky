package ksmart.ks48team02.admin.service.reward;

import ksmart.ks48team02.admin.dto.RewardJudegmentReson;
import ksmart.ks48team02.admin.mapper.reward.AdminRewardMapper;
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
public class AdminRewardService {

    private final AdminRewardMapper adminRewardMapper;

    public Map<String,Object> rewardProjectListNotJudge (Map<String,Object> inquirMap){

        // 보여줄 행의 갯수
        int rowPerPage = 10;
        // 현재 페이지 수.
        int currentPage = (int) inquirMap.get("currentPage");
        // 보여줄 행의 시작점
        int startRowNum = (currentPage - 1) * rowPerPage;
        // 전체 행의 갯수
        double rowCnt = adminRewardMapper.projectPageCnt();
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
        List<RewardProject> projectList = adminRewardMapper.rewardProjectListNotJudge(inquirMap);
        List<RewardJudegmentReson> rewardJudegmentResonList = adminRewardMapper.judegmentReson();

        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("projectList",projectList);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("endPageNum", endPageNum);
        resultMap.put("rewardJudegmentResonList",rewardJudegmentResonList);
        resultMap.put("rowCnt",rowCnt);


        return resultMap;
    }

    //심사 승인
    public void rewardProjectConfirmAndReject(String rewardProjectCode, String judgement, String adminMemberId,
                                              String judgeRejectReasonCode, String judgeRejectReasonDetail){
        adminRewardMapper.rewardProjectConfirmAndReject(rewardProjectCode, judgement, adminMemberId, judgeRejectReasonCode, judgeRejectReasonDetail);
    };
}
