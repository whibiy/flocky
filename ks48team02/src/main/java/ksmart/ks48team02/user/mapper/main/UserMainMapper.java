package ksmart.ks48team02.user.mapper.main;

import ksmart.ks48team02.user.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMainMapper {

    /**
     * get recommend category list by sid
     * @param sid
     * @return
     */
    public List<RecommendCategory> getRecommendCtList(String sid);

    /**
     * get recommend project list by category list
     * @param categoryCodeList
     * @return
     */
    public List<TotalRecommendProject> getRecommendPjgList(List<RecommendCategory> categoryCodeList);

    /**
     * rank list contents
     */
    public List<OrderRank> getRankList(String rankCategory);

    /**
     * get reward list for main
     * @return rewardPrjList
     */
    public List<RewardProject> getRewardPrjList();

    /**
     * get donation list for main
     * @return donationPrjList
     */
    public List<DonationRegistration> getDonationPrjList();

    /**
     * get investment list for main
     * @return investPrjList
     */
    public List<InvestmentInfo> getInvestPrjList();

    public List<TotalRecommendProject> getStorePrjList();
}
