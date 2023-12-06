package ksmart.ks48team02.admin.dto;

public class AdminLawSatistifyReason {

    private String lawSatistifyCode;
    private String lawSatistifyReason;
    private String memberId;
    private int lawSatistifyWhether;
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
    public int getLawSatistifyWhether() {
        return lawSatistifyWhether;
    }
    public void setLawSatistifyWhether(int lawSatistifyWhether) {
        this.lawSatistifyWhether = lawSatistifyWhether;
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
        builder.append("Icosdfn [lawSatistifyCode=");
        builder.append(lawSatistifyCode);
        builder.append(", lawSatistifyReason=");
        builder.append(lawSatistifyReason);
        builder.append(", memberId=");
        builder.append(memberId);
        builder.append(", lawSatistifyWhether=");
        builder.append(lawSatistifyWhether);
        builder.append(", codeRegDay=");
        builder.append(codeRegDay);
        builder.append("]");
        return builder.toString();
    }
}
