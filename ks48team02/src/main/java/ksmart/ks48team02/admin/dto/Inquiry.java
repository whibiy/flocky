package ksmart.ks48team02.admin.dto;

public class Inquiry {
    private String contactAnswerCode;
    private String inquireCode;
    private String memberId;
    private String iqSubject;
    private String iqContent;
    private String iqDatetime;

    private InquiryPage inquiryPage;

    @Override
    public String toString() {
        return "Inquiry{" +
                "contactAnswerCode='" + contactAnswerCode + '\'' +
                ", inquireCode='" + inquireCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", iqSubject='" + iqSubject + '\'' +
                ", iqContent='" + iqContent + '\'' +
                ", iqDatetime='" + iqDatetime + '\'' +
                ", inquiryPage=" + inquiryPage +
                '}';
    }

    public String getContactAnswerCode() {
        return contactAnswerCode;
    }

    public Inquiry setContactAnswerCode(String contactAnswerCode) {
        this.contactAnswerCode = contactAnswerCode;
        return this;
    }

    public String getInquireCode() {
        return inquireCode;
    }

    public Inquiry setInquireCode(String inquireCode) {
        this.inquireCode = inquireCode;
        return this;
    }

    public String getMemberId() {
        return memberId;
    }

    public Inquiry setMemberId(String memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getIqSubject() {
        return iqSubject;
    }

    public Inquiry setIqSubject(String iqSubject) {
        this.iqSubject = iqSubject;
        return this;
    }

    public String getIqContent() {
        return iqContent;
    }

    public Inquiry setIqContent(String iqContent) {
        this.iqContent = iqContent;
        return this;
    }

    public String getIqDatetime() {
        return iqDatetime;
    }

    public Inquiry setIqDatetime(String iqDatetime) {
        this.iqDatetime = iqDatetime;
        return this;
    }

    public InquiryPage getInquiryPage() {
        return inquiryPage;
    }

    public Inquiry setInquiryPage(InquiryPage inquiryPage) {
        this.inquiryPage = inquiryPage;
        return this;
    }
}
