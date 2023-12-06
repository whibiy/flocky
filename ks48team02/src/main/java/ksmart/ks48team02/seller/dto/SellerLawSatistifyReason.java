package ksmart.ks48team02.seller.dto;

public class SellerLawSatistifyReason {

    private String lawSatistifyCode;
    private String lawSatistifyReason;
    private String memberId;
    private String codeRegDay;

    public String getLawSatistifyCode() {
        return lawSatistifyCode;
    }
    public void setLawSatistifyCode(String lawSatistifyCode) {
        this.lawSatistifyCode = lawSatistifyCode;
    }
    public String getLawSatistifyReason() {
        return lawSatistifyReason;
    }
    public void setLawSatistifyReason(String lawSatistifyReason) {
        this.lawSatistifyReason = lawSatistifyReason;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getCodeRegDay() {
        return codeRegDay;
    }
    public void setCodeRegDay(String codeRegDay) {
        this.codeRegDay = codeRegDay;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LawSatistifyReason [lawSatistifyCode=");
        builder.append(lawSatistifyCode);
        builder.append(", lawSatistifyReason=");
        builder.append(lawSatistifyReason);
        builder.append(", memberId=");
        builder.append(memberId);
        builder.append(", codeRegDay=");
        builder.append(codeRegDay);
        builder.append("]");
        return builder.toString();
    }
}
