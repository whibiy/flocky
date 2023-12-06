package ksmart.ks48team02.seller.service.settlement;

import ksmart.ks48team02.admin.controller.orderManagement.OrderManagementController;
import ksmart.ks48team02.common.dto.SettlementPrjList;
import ksmart.ks48team02.seller.dto.DonationList;
import ksmart.ks48team02.seller.mapper.donation.SellerDonationMapper;
import ksmart.ks48team02.seller.mapper.reward.SellerRewardMapper;
import ksmart.ks48team02.seller.mapper.settlement.SelSettlementMapper;
import ksmart.ks48team02.user.dto.InvestmentInfo;
import ksmart.ks48team02.user.dto.RewardProject;
import ksmart.ks48team02.user.mapper.investment.UserInvestmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SelSettlementService {

    // 로그 추가
    private static final Logger log = LoggerFactory.getLogger(OrderManagementController.class);


    // DI
    private final SelSettlementMapper selSettlementMapper;
    private final SellerRewardMapper sellerRewardMapper;
    private final SellerDonationMapper sellerDonationMapper;
    private final UserInvestmentMapper userInvestmentMapper;

    // 의존성 주입
    public SelSettlementService(SelSettlementMapper selSettlementMapper,
                                SellerRewardMapper sellerRewardMapper,
                                SellerDonationMapper sellerDonationMapper,
                                UserInvestmentMapper userInvestmentMapper){
        this.selSettlementMapper = selSettlementMapper;
        this.sellerRewardMapper = sellerRewardMapper;
        this.sellerDonationMapper = sellerDonationMapper;
        this.userInvestmentMapper = userInvestmentMapper;
    }

    /**
     * 정산 신청 가능 공고 진열
     * @param sstorecode
     * @return settPrjListByCode
     */
    public List<SettlementPrjList> getSettPrjListByCode(String sstorecode){

        List<SettlementPrjList> settPrjListByCode = selSettlementMapper.getSettPrjListByCode(sstorecode);
        return settPrjListByCode;

    }

    public Map<String, Object> getInfoByProjectCode(String projectPartition, String projectCode){
        Map<String, Object> resultMap = new HashMap<String, Object>();

        // 프로젝트 조회
        switch(projectPartition){
            case "리워드":
                RewardProject rwdPrjInfo = sellerRewardMapper.getRwdPrjInfoByCode(projectCode);
                resultMap.put("list", rwdPrjInfo);
                break;
            case "기부":
                DonationList donPrjInfo = sellerDonationMapper.getDonPrjInfoByCode(projectCode);
                resultMap.put("list", donPrjInfo);
                break;
            case "투자":
                InvestmentInfo invPrjInfo =  userInvestmentMapper.getInvPrjInfoByCode(projectCode);
                resultMap.put("list", invPrjInfo);
                break;
        }

        return resultMap;
    }

}
