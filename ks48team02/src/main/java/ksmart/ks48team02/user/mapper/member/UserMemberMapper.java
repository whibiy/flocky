package ksmart.ks48team02.user.mapper.member;


import ksmart.ks48team02.user.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMemberMapper {

    //회원 아이디로 특정회원 정보 조회.
    public Member getMemberInfoById(String memberId);

    public void addLoginLog(String clientIp, String memberId);

    public void addLogoutLog(String clientIp, String loginId);

}
