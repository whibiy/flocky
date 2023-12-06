package ksmart.ks48team02.user.service.main;

import ksmart.ks48team02.user.dto.*;
import ksmart.ks48team02.user.mapper.main.UserMainMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMainService {

    // DI (의존성 주입)
    private final UserMainMapper userMainMapper;

    public UserMainService(UserMainMapper userMainMapper){
        this.userMainMapper = userMainMapper;
    }


    /**
     * get recommend category list by sid
     * @param sid
     * @return recommendCtList
     */
    public List<RecommendCategory> getRecommendCtList(String sid){
        List<RecommendCategory> recommendCtList = userMainMapper.getRecommendCtList(sid);
        return recommendCtList;
    }

    /**
     * get recommend project list by category list
     * @param categoryCodeList
     * @return recommendPjgList
     */
    public List<TotalRecommendProject> getRecommendPjgList(List<RecommendCategory> categoryCodeList){
        List<TotalRecommendProject> recommendPjgList = userMainMapper.getRecommendPjgList(categoryCodeList);
        return recommendPjgList;
    }


    /**
     * rank list contents
     */
    public List<OrderRank> getRankList(String rankCategory){
        List<OrderRank> rankList = userMainMapper.getRankList(rankCategory);
        return rankList;
    }


    /**
     * get reward list for main
     * @return rewardPrjList
     */
    public List<RewardProject> getRewardPrjList(){
        List<RewardProject> rewardPrjList = userMainMapper.getRewardPrjList();
        return rewardPrjList;
    }

    /**
     * get donation list for main
     * @return donationPrjList
     */
    public List<DonationRegistration> getDonationPrjList(){
      List<DonationRegistration> donationPrjList= userMainMapper.getDonationPrjList();
      return donationPrjList;
    };

    /**
     * get investment list for main
     * @return investPrjList
     */
    public List<InvestmentInfo> getInvestPrjList(){
        List<InvestmentInfo> investPrjList = userMainMapper.getInvestPrjList();
        return investPrjList;
    }


    /**
     * get store rank list for main
     * @return storePrjList
     */
    public List<TotalRecommendProject> getStorePrjList(){
        List<TotalRecommendProject> storePrjList = userMainMapper.getStorePrjList();
        return storePrjList;
    }

}
