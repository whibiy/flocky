package ksmart.ks48team02.admin.dto;

import ksmart.ks48team02.user.dto.Member;
import lombok.Data;

@Data
public class UserManagement {
    /* 로그인 로그 */
    private String loginLogCode;
    private String memberId;
    private String loginTime;
    private String clientNetAddress;

    // member dto
    private Member member;

    /* 리워드 등급 */
    private String rewardRankCode;
    private String rewardRankName;
    private Float discountRate;
    private int rewardRankUpgradeAmount;
    private Float pointSavingRate;

    /* 기부 등급 */
    private String donationRankCode;
    private String donationRankName;
    private int donationRankUpgradeAmount;
    private Float floverSavingRate;
}
