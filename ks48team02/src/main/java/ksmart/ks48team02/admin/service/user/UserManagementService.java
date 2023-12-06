package ksmart.ks48team02.admin.service.user;

import ksmart.ks48team02.admin.dto.UserManagement;
import ksmart.ks48team02.admin.mapper.user.UserManagementMapper;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserManagementService {

    private final UserManagementMapper userManagementMapper;


    public List<UserManagement> getLoginLog(){
        return userManagementMapper.getLoginLog();
    }

    public List<UserManagement> getLoginLogById(String memberId, String startDate, String endDate, String memberTypeCode){
        return userManagementMapper.getLoginLogById(memberId, startDate,endDate, memberTypeCode);
    }

    // 리워드 등급
    public List<UserManagement> getRewardRank(){
        return userManagementMapper.getRewardRank();
    }

    // 기부 등급
    public List<UserManagement> getDonationRank(){
        return userManagementMapper.getDonationRank();
    }
    //
    public List<UserManagement> getMemberList(){
        return userManagementMapper.getMemberList();
    }

}
