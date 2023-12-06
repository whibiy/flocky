package ksmart.ks48team02.user.service.donation;

import ksmart.ks48team02.admin.dto.DonationInfo;
import ksmart.ks48team02.common.dto.OrderTableList;
import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.user.controller.donation.KaKaoPayProperties;
import ksmart.ks48team02.user.dto.*;
import ksmart.ks48team02.user.mapper.donation.DonationUserMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Transactional
public class DonationService{
    private final DonationUserMapper donationUserMapper;

    // DI (의존성주입)
    DonationService(DonationUserMapper donationUserMapper){

        this.donationUserMapper = donationUserMapper;
    }

    public void addDonation(DonationRegistration donationRegistration){
        System.out.println(donationRegistration);
        int result = donationUserMapper.addDonation(donationRegistration);
    }
    public DonationInfo getDonationInfo(String donationCode){
        return donationUserMapper.getDonationInfo(donationCode);
    }

    public CategoryAndCompany getCateAndCompany(String donationCode){
        CategoryAndCompany cateAndCompany = donationUserMapper.getCateAndCompany(donationCode);
        return cateAndCompany;
    }

    public List<AllDonationInfo> getAllDonationInfo(){
        List<AllDonationInfo> allDonationInfo = donationUserMapper.getAllDonationInfo();
        return allDonationInfo;
    }

    public String getCondition(String donationCode){
        return donationUserMapper.getCondition(donationCode);
    }

    public List<NewsList> getNewsList(String donationCode){
        return donationUserMapper.getNewsList(donationCode);
    }

    public NewsList getDetailNews(String newsCode){
        return donationUserMapper.getDetailNews(newsCode);
    }

    public CommentMember getMember(String memberId){
        return donationUserMapper.getMember(memberId);
    }

    public void CommentAdd(String memberId, String donationCode,String memberName,String commentContent){
        donationUserMapper.CommentAdd(memberId, donationCode, memberName, commentContent);
    }

    public List<DonationCommentList> getCommentList(String donationCode){
        return donationUserMapper.getCommentList(donationCode);
    }

    public void replyAdd(String reply, String donationCode, String parentCommentCode, String memberId, String memberName){
        donationUserMapper.replyAdd(reply, donationCode, parentCommentCode, memberId, memberName);
    }

    public int getFlover(String memberId){
        return donationUserMapper.getFlover(memberId);
    }

    public void deductFlover(Map<String,Object> deductData){
        donationUserMapper.deductFlover(deductData);
    }

    public void addOrderTable(String memberId, String donationCode, String orderTotalPrice){
        donationUserMapper.addOrderTable(memberId, donationCode, orderTotalPrice);
    }

    public void addDonationPayment(String donationCode, String floverAmount, String floverToMoney){
        donationUserMapper.addDonationPayment(donationCode, floverAmount, floverToMoney);
    }

    public void updateMoney(String donationCode, String acvMoney, String acvPercent){
        donationUserMapper.updateMoney(donationCode, acvMoney, acvPercent);
    }

    public int getNumberOfParticipants(String donationCode){
        return donationUserMapper.getNumberOfParticipants(donationCode);
    }

    public void chargeFlover(String memberId, String floverCount){
        donationUserMapper.chargeFlover(memberId, floverCount);
    }

    public void searchCountUpdate(String donationCode, String searchCount){
        donationUserMapper.searchCountUpdate(donationCode , searchCount);
    }

    public void removeOrderInfo(String orderCode){
        donationUserMapper.removeOrderInfo(orderCode);
    }

    public OrderTableList getOrderInfo(String orderCode){
        return donationUserMapper.getOrderInfo(orderCode);
    }

    public Customer getCustomerInfo(String memberId){
        return donationUserMapper.getCustomerInfo(memberId);
    }

}
