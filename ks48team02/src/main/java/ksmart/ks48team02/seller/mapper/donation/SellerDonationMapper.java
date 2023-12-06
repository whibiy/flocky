package ksmart.ks48team02.seller.mapper.donation;

import ksmart.ks48team02.seller.dto.DonationList;
import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.user.dto.AllDonationInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellerDonationMapper {
    public List<DonationList> getDonationProjectList();
    public void startProject(String donationCode);
    public List<AllDonationInfo> getAllDonationInfo(String memberId);
    public void addNews(String detailSubject, String detailComent, String donationCode);
    public List<NewsList> getNews();
    public void updateNews(String detailSubject, String detailComent, String newsCode);
    public void deleteNews(String newsCode);
    public void addCondition(String detailComent, String donationCode);
    public String modifyCondition(String donationCode);
    public void updateCondition(String detailComent, String donationCode);
    public int isCondition(String donationCode);

    public DonationList getDonPrjInfoByCode(String projectCode);
}
