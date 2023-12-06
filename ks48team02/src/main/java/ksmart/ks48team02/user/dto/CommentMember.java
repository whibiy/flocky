package ksmart.ks48team02.user.dto;

import lombok.Data;

@Data
public class CommentMember {
    private String memberId;
    private String memberTypeCode;
    private String memberName;
    private String memberPw;
    private String memberRegDate;
    private String memberEmail;
    private String contactInfo;
    private String unregDate;
    private String unregStatus;
}
