package ksmart.ks48team02.admin.service.donation;

import ksmart.ks48team02.admin.dto.AllProjectList;
import ksmart.ks48team02.admin.dto.Donation;
import ksmart.ks48team02.admin.dto.DonationJudgementReason;
import ksmart.ks48team02.admin.mapper.donation.AdminDonationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminDonationService {

    private final AdminDonationMapper adminDonationMapper;

    public AdminDonationService(AdminDonationMapper adminDonationMapper){
        this.adminDonationMapper = adminDonationMapper;
    }

    public List<Donation> getDonationList(){
        List<Donation> donationList = adminDonationMapper.getDonationList();
        return donationList;
    }

    public void judgementApprove(String donationCode, String adminId){
        adminDonationMapper.judgementApprove(donationCode, adminId);
    }

    public void judgementReject(String donationCode, String judgeRejectReason, String judgeRejectReasonDetail ,String adminId){
        adminDonationMapper.judgementReject(donationCode, judgeRejectReason, judgeRejectReasonDetail, adminId);
    }
    public List<DonationJudgementReason> judgementReason(){
        return adminDonationMapper.judgementReason();
    }

    public List<AllProjectList> getAllprojectList(){
        return adminDonationMapper.getAllprojectList();
    }



}
