package ksmart.ks48team02.admin.mapper.donation;

import ksmart.ks48team02.admin.dto.AllProjectList;
import ksmart.ks48team02.admin.dto.Donation;
import ksmart.ks48team02.admin.dto.DonationJudgementReason;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminDonationMapper {

    public List<Donation> getDonationList();

    public void judgementApprove(String donationCode,String adminId);
    public void judgementReject(String donationCode , String judgeRejectReason, String judgeRejectReasonDetail, String adminId);
    public List<DonationJudgementReason> judgementReason();
    public List<AllProjectList> getAllprojectList();

}
