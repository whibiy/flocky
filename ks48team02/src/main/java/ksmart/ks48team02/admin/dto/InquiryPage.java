package ksmart.ks48team02.admin.dto;

public class InquiryPage {
    private String inquireCode;
    private String memberId;
    private String contactCategoryNumber;
    private String iqSubject;
    private String moreInformation;
    private String inquiryProjectCode;
    private String replyEmailAddress;
    private String replyContact;
    private String inquiryStatus;
    private String inquiryDate;
    private String answerCompletionDate;

    @Override
    public String toString() {
        return "InquiryPage{" +
                "inquireCode='" + inquireCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", contactCategoryNumber='" + contactCategoryNumber + '\'' +
                ", iqSubject='" + iqSubject + '\'' +
                ", moreInformation='" + moreInformation + '\'' +
                ", inquiryProjectCode='" + inquiryProjectCode + '\'' +
                ", replyEmailAddress='" + replyEmailAddress + '\'' +
                ", replyContact='" + replyContact + '\'' +
                ", inquiryStatus='" + inquiryStatus + '\'' +
                ", inquiryDate='" + inquiryDate + '\'' +
                ", answerCompletionDate='" + answerCompletionDate + '\'' +
                '}';
    }

    public String getInquireCode() {
        return inquireCode;
    }

    public InquiryPage setInquireCode(String inquireCode) {
        this.inquireCode = inquireCode;
        return this;
    }

    public String getMemberId() {
        return memberId;
    }

    public InquiryPage setMemberId(String memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getContactCategoryNumber() {
        return contactCategoryNumber;
    }

    public InquiryPage setContactCategoryNumber(String contactCategoryNumber) {
        this.contactCategoryNumber = contactCategoryNumber;
        return this;
    }

    public String getIqSubject() {
        return iqSubject;
    }

    public InquiryPage setIqSubject(String iqSubject) {
        this.iqSubject = iqSubject;
        return this;
    }

    public String getMoreInformation() {
        return moreInformation;
    }

    public InquiryPage setMoreInformation(String moreInformation) {
        this.moreInformation = moreInformation;
        return this;
    }

    public String getInquiryProjectCode() {
        return inquiryProjectCode;
    }

    public InquiryPage setInquiryProjectCode(String inquiryProjectCode) {
        this.inquiryProjectCode = inquiryProjectCode;
        return this;
    }

    public String getReplyEmailAddress() {
        return replyEmailAddress;
    }

    public InquiryPage setReplyEmailAddress(String replyEmailAddress) {
        this.replyEmailAddress = replyEmailAddress;
        return this;
    }

    public String getReplyContact() {
        return replyContact;
    }

    public InquiryPage setReplyContact(String replyContact) {
        this.replyContact = replyContact;
        return this;
    }

    public String getInquiryStatus() {
        return inquiryStatus;
    }

    public InquiryPage setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
        return this;
    }

    public String getInquiryDate() {
        return inquiryDate;
    }

    public InquiryPage setInquiryDate(String inquiryDate) {
        this.inquiryDate = inquiryDate;
        return this;
    }

    public String getAnswerCompletionDate() {
        return answerCompletionDate;
    }

    public InquiryPage setAnswerCompletionDate(String answerCompletionDate) {
        this.answerCompletionDate = answerCompletionDate;
        return this;
    }
}
