package ksmart.ks48team02.admin.dto;

public class AdminIncongruitySectors {

    private String incongruitySectorsCode;
    private String incongruitySectorsBusiness;
    private String memberId;
    private int incongruitySectorsWhether;
    private String codeRegDay;

    public String getIncongruitySectorsCode() {
        return incongruitySectorsCode;
    }
    public void setIncongruitySectorsCode(String incongruitySectorsCode) {
        this.incongruitySectorsCode = incongruitySectorsCode;
    }
    public String getIncongruitySectorsBusiness() {
        return incongruitySectorsBusiness;
    }
    public void setIncongruitySectorsBusiness(String incongruitySectorsBusiness) {
        this.incongruitySectorsBusiness = incongruitySectorsBusiness;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public int getIncongruitySectorsWhether() {
        return incongruitySectorsWhether;
    }
    public void setIncongruitySectorsWhether(int incongruitySectorsWhether) {
        this.incongruitySectorsWhether = incongruitySectorsWhether;
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
        builder.append("Icosdfn [incongruitySectorsCode=");
        builder.append(incongruitySectorsCode);
        builder.append(", incongruitySectorsBusiness=");
        builder.append(incongruitySectorsBusiness);
        builder.append(", memberId=");
        builder.append(memberId);
        builder.append(", incongruitySectorsWhether=");
        builder.append(incongruitySectorsWhether);
        builder.append(", codeRegDay=");
        builder.append(codeRegDay);
        builder.append("]");
        return builder.toString();
    }
}
