package ksmart.ks48team02.user.service.mypage;


import ksmart.ks48team02.common.dto.OrderTotal;
import ksmart.ks48team02.common.dto.RewardOrderDetail;
import ksmart.ks48team02.common.mapper.order.OrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import ksmart.ks48team02.user.dto.MypageDto;
import ksmart.ks48team02.user.mapper.mypage.MypageMapper;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
@AllArgsConstructor
public class MypageService {

    private final OrderMapper orderMapper;
    private final MypageMapper mypageMapper;

    // 마이페이지 내 주문 내역 조회
    public List<OrderTotal> mypageOrderList (String memberId, String selectFund) {
        List<OrderTotal> mypageOrderList = orderMapper.mypageOrderList(memberId, selectFund);

        //프로젝트가 리워드 이면 주문 상세 같이 조회
        mypageOrderList.forEach((option)->{
            String orderCode = option.getOrderCode();
            String projectCode = option.getGoodsCode();
            if(projectCode.contains("rwd") || projectCode.contains("RWD")) {
                List<RewardOrderDetail> rewardOrderDetailList = orderMapper.mypageOrderDetailList(orderCode);
                option.setRewardOrderDetailList(rewardOrderDetailList);
            }
        });

        return mypageOrderList;
    }


    public Map<String, Object> getMemberInfoById(String memberId){
        Map<String, Object> resultMap = new HashMap<>();
        MypageDto memberInfo = mypageMapper.getMemberInfoById(memberId);
        if(memberInfo != null){
            resultMap.put("memberEmail",memberInfo.getMemberEmail());
            resultMap.put("memberContactInfo", memberInfo.getMemberContactInfo());
        }
        return resultMap;
    }

    // 비밀번호 변경 전 인증
    public boolean pwCheck(String loginId, String memberPw){
        return mypageMapper.pwCheck(loginId, memberPw);
    }

    // 비밀번호 변경
    public int pwModify(String loginId, String memberPw){
        return mypageMapper.pwModify(loginId,memberPw);
    }

    // 이메일 변경
    public int emailModify(String loginId, String memberEmail){
        return mypageMapper.emailModify(loginId,memberEmail);
    }

    // 연락처 변경
    public int contactInfoModify(String loginId, String memberContactInfo){
        return mypageMapper.contactInfoModify(loginId,memberContactInfo);
    }
}
