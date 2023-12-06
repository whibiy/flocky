package ksmart.ks48team02.user.dto;

public class OrderRank {
    private int rankCount;
    private String projectCode;
    private String subject;
    private String imageUrl;
    private String projectType;
    private String categoryName;
    private String storeName;
    private int achievementPercent;
    private int likeCount;

    @Override
    public String toString() {
        return "OrderRank{" +
                "rankCount=" + rankCount +
                ", projectCode='" + projectCode + '\'' +
                ", subject='" + subject + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", projectType='" + projectType + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", storeName='" + storeName + '\'' +
                ", achievementPercent=" + achievementPercent +
                ", likeCount=" + likeCount +
                '}';
    }

    public int getRankCount() {
        return rankCount;
    }

    public void setRankCount(int rankCount) {
        this.rankCount = rankCount;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getAchievementPercent() {
        return achievementPercent;
    }

    public void setAchievementPercent(int achievementPercent) {
        this.achievementPercent = achievementPercent;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
