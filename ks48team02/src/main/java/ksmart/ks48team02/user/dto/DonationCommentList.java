package ksmart.ks48team02.user.dto;

import lombok.Data;

@Data
public class DonationCommentList {
    public String donationCommentCode;
    public String memberId;
    private String donationCode;
    private String memberName;
    private String commentContent;
    private String commentDatetime;
    private String commentModifyDatetime;
    private String commentDeleteDatetime;
    private String commentCode;
    private String commentClass;
}
