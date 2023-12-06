package ksmart.ks48team02.user.mapper.account;

import ksmart.ks48team02.user.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface AccountMapper {
    // 회원가입
    public int addMember(Member member);

    // 회원아이디 중복체크
     public boolean idCheck(String memberId);

     // 회원 비밀번호 일치 확인
     public boolean pwCheck(String loginId, String memberPw);

     //회원 계정 비활성화
     public int inactivateMember(String loginId);

     // 회원 아이디로 회원정보 조회



}
