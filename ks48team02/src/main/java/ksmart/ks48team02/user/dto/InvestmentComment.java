package ksmart.ks48team02.user.dto;


import lombok.Data;

@Data
public class InvestmentComment {
    private String investCommentCode;
    private String memberId;
    private String investmentCode;
    private String memberName;
    private String commentContent;
    private String commentDatetime;
    private String commentModifyDatetime;
    private String commentDeleteDatetime;
    private String commentCode;
    private String commentClass;
}
