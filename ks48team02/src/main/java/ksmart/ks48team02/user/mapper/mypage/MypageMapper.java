package ksmart.ks48team02.user.mapper.mypage;

import ksmart.ks48team02.user.dto.Member;
import ksmart.ks48team02.user.dto.MypageDto;
import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypageMapper {
    public MypageDto getMemberInfoById(String memberId);

    public boolean pwCheck(String loginId, String memberPw);

    // 비밀번호 변경
    public int pwModify(String loginId, String memberPw);

    // 이메일 변경
    public int emailModify(String loginId, String memberEmail);

    // 연락처 변경
    public int contactInfoModify(String loginId, String memberContactInfo);

    // 자기소개 변경

}
