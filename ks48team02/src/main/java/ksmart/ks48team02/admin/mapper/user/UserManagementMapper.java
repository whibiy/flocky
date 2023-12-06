package ksmart.ks48team02.admin.mapper.user;

import ksmart.ks48team02.admin.dto.UserManagement;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserManagementMapper {
    // 로그인 로그 페이지 로드시 전체 로그인 내역 조회
    public List<UserManagement> getLoginLog();
    // 검색 조건 넣어서 회원 로그인 내역 조회
    public List<UserManagement> getLoginLogById(String memberId, String startDate, String endDate, String memberTypeCode);

    // 리워드 등급
    public List<UserManagement> getRewardRank();

    // 기부 등급
    public List<UserManagement> getDonationRank();

    //
    public List<UserManagement> getMemberList();
}
