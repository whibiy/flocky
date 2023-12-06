package ksmart.ks48team02.user.dto;

public class RewardCustomerRank {

    private String rewardRankCode;
    private String rankName;
    private float discountRate;
    private int rankUpgradeAmount;
    private float pointSavingRate;

    @Override
    public String toString() {
        return "RewardCustomerRank{" +
                "rewardRankCode='" + rewardRankCode + '\'' +
                ", rankName='" + rankName + '\'' +
                ", discountRate=" + discountRate +
                ", rankUpgradeAmount=" + rankUpgradeAmount +
                ", pointSavingRate=" + pointSavingRate +
                '}';
    }

    public String getRewardRankCode() {
        return rewardRankCode;
    }

    public void setRewardRankCode(String rewardRankCode) {
        this.rewardRankCode = rewardRankCode;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public float getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(float discountRate) {
        this.discountRate = discountRate;
    }

    public int getRankUpgradeAmount() {
        return rankUpgradeAmount;
    }

    public void setRankUpgradeAmount(int rankUpgradeAmount) {
        this.rankUpgradeAmount = rankUpgradeAmount;
    }

    public float getPointSavingRate() {
        return pointSavingRate;
    }

    public void setPointSavingRate(float pointSavingRate) {
        this.pointSavingRate = pointSavingRate;
    }
}
