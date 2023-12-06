package ksmart.ks48team02.user.service.account;

import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.mapper.account.AccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class AccountService {

    private static final Logger Log = LoggerFactory.getLogger(AccountService.class);
    // DI(의존성 주입)
    private final AccountMapper accountMapper;

    // 생성자메소드를 통한 DI
    public AccountService(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    // 회원가입
    public void addMember(Member member) {
        accountMapper.addMember(member);
    }

    // 아이디 중복체크
    public boolean idCheck(String memberId) {
        return accountMapper.idCheck(memberId);
    }

    // 비밀번호 일치 확인
    public boolean pwCheck(String loginId, String memberPw){
        return accountMapper.pwCheck(loginId, memberPw);
    }

    public int inactivateMember(String loginId){

        // System.out.printf("====AccountMapper가%d을 반환함====%n", accountMapper.inactivateMember(loginId));
        Log.info("탈퇴 아이디 {} ", loginId);
        return accountMapper.inactivateMember(loginId);
    }


    // 회원 아이디로 회원정보 조회



    }


