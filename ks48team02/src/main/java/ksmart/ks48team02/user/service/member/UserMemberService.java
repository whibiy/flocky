package ksmart.ks48team02.user.service.member;


import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.mapper.member.UserMemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserMemberService {

    private final UserMemberMapper userMemberMapper;

    public UserMemberService(UserMemberMapper userMemberMapper) {
        this.userMemberMapper = userMemberMapper;
    }

    // 로그인 시 아이디, 비밀번호 일치 확인+ 회원의 권한과 이름 리턴
    public Map<String, Object> checkMemberInfo(String memberId, String memberPw){
        Map<String, Object> resultMap = new HashMap<String, Object>();

        boolean isChecked = false;
        Member memberInfo = userMemberMapper.getMemberInfoById(memberId);
        if(memberInfo != null) {

            String checkPw = memberInfo.getMemberPw();
            if(checkPw.equals(memberPw)) {
                isChecked = true;
                resultMap.put("memberTypeCode", memberInfo.getMemberTypeCode());
                resultMap.put("memberName", memberInfo.getMemberName());
            }
        }

        if(!isChecked) resultMap.put("msg", "일치하는 회원의 정보가 없습니다.");

        resultMap.put("isChecked", isChecked);

        return resultMap;
    }

    // 로그인시 로그인로그 업데이트
    public void addLoginLog(String clientIp, String memberId){
        userMemberMapper.addLoginLog(clientIp, memberId);
    }

    // 로그아웃시 로그아웃로그 업데이트
    public void addLogoutLog(String clientIp, String loginId){
        userMemberMapper.addLogoutLog(clientIp, loginId);
    }

}
