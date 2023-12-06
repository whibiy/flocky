package ksmart.ks48team02.common.mapper.payments;

import ksmart.ks48team02.common.dto.DonationPayments;
import ksmart.ks48team02.common.dto.InvestPayments;
import ksmart.ks48team02.common.dto.RewardPayments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentsMapper {

    // 리워드 결제 정보 목록 조회
    public List<RewardPayments> getRewardPayments();

    // 특정 리워드 결제 정보 조회
    public RewardPayments getRewardPaymentsById(String orderCode);

    // 특정 기부 결제 정보 조회
    public DonationPayments getDonationPaymentsById(String orderCode);

    // 특정 투자 결제 정보 조회
    public InvestPayments getInvestPaymentsById(String orderCode);
}
