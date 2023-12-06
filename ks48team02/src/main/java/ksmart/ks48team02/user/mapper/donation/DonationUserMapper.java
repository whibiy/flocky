package ksmart.ks48team02.user.mapper.donation;

import ksmart.ks48team02.admin.dto.DonationInfo;
import ksmart.ks48team02.common.dto.OrderTableList;
import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.user.dto.*;
import org.apache.ibatis.annotations.Mapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface DonationUserMapper {
    public int addDonation(DonationRegistration donationRegistration);
    public DonationInfo getDonationInfo(String donationCode);
    public CategoryAndCompany getCateAndCompany(String donationCode);
    public List<AllDonationInfo> getAllDonationInfo();
    public String getCondition(String donationCode);
    public List<NewsList> getNewsList(String donationCode);
    public NewsList getDetailNews(String newsCode);
    public CommentMember getMember(String memberId);
    public void CommentAdd(String memberId, String donationCode,String memberName,String commentContent);
    public List<DonationCommentList> getCommentList(String donationCode);
    public void replyAdd(String reply, String donationCode, String parentCommentCode, String memberId, String memberName);
    public int getFlover(String memberId);
    public void deductFlover(Map<String,Object> deductData);
    public void addOrderTable(String memberId, String donationCode, String orderTotalPrice);
    public void addDonationPayment(String donationCode, String floverAmount, String floverToMoney);
    public void updateMoney(String donationCode, String acvMoney, String acvPercent);
    public int getNumberOfParticipants(String donationCode);
    public void chargeFlover(String memberId, String floverCount);
    public void searchCountUpdate(String donationCode, String searchCount);
    public void removeOrderInfo(String orderCode);
    public OrderTableList getOrderInfo(String orderCode);
    public Customer getCustomerInfo(String memberId);
}
