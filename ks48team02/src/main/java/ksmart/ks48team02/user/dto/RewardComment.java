package ksmart.ks48team02.user.dto;


import lombok.Data;

import java.util.List;

@Data
public class RewardComment {

    public String rewardCommentCode;
    public String memberId;
    private String rewardProjectCode;
    private String memberName;
    private String commentContent;
    private String commentDatetime;
    private String commentModifyDatetime;
    private String commentDeleteDatetime;
    private String commentPostNum;
    private String commentClass;

    List<RewardComment> rewardReplyList;

}
