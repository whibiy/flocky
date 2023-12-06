package ksmart.ks48team02.admin.mapper.reward;

import ksmart.ks48team02.admin.dto.RewardJudegmentReson;
import ksmart.ks48team02.user.dto.RewardProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminRewardMapper {

    //심사 대기중 리워드 프로젝트 조회
    public List<RewardProject> rewardProjectListNotJudge(Map<String,Object> inquirMap);

    //심사 사유 조회
    public List<RewardJudegmentReson> judegmentReson();

    //프로젝트 전체 행의 갯수
    public int projectPageCnt();

    //심사 승인
    public int rewardProjectConfirmAndReject(String rewardProjectCode, String judgement, String adminMemberId,
                                             String judgeRejectReasonCode, String judgeRejectReasonDetail);

    //심사 거절
    public int rewardProjectReject();
}
