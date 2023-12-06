package ksmart.ks48team02.seller.service.donation;

import ksmart.ks48team02.admin.dto.Donation;
import ksmart.ks48team02.seller.dto.DonationList;
import ksmart.ks48team02.seller.dto.NewsList;
import ksmart.ks48team02.seller.mapper.donation.SellerDonationMapper;
import ksmart.ks48team02.user.dto.AllDonationInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class SellerDonationService {
    SellerDonationMapper sellerDonationMapper;

    // 판매자 자기 자신의 프로젝트 목록을 가져오는 함수
    public List<DonationList> getDonationProjectList(String memberId){
        List<DonationList> donationList = sellerDonationMapper.getDonationProjectList();
        List<DonationList> getCurIdList = new ArrayList<DonationList>();
        for (DonationList dl : donationList){
            if(dl.getMemberId().equals(memberId)){
                getCurIdList.add(dl);
            }
        }
        return getCurIdList;
    }

    public void startProject(String donationCode){
        sellerDonationMapper.startProject(donationCode);
    }

    public List<AllDonationInfo> getAllDonationInfo(String memberId){
        List<AllDonationInfo> allDonationInfo = sellerDonationMapper.getAllDonationInfo(memberId);
        return allDonationInfo;
    }

    public void addNews(String detailSubject, String detailComent, String donationCode){
        sellerDonationMapper.addNews(detailSubject, detailComent, donationCode);
    }

    public List<NewsList> getNews(){
        return sellerDonationMapper.getNews();
    };

    public void updateNews(String detailSubject, String detailComent, String newsCode){
        sellerDonationMapper.updateNews(detailSubject, detailComent, newsCode);
    }

    public void deleteNews(String newsCode){
        sellerDonationMapper.deleteNews(newsCode);
    }

    public void addCondition(String detailComent, String donationCode){
        sellerDonationMapper.addCondition(detailComent, donationCode);
    }

    public String modifyCondition(String donationCode){
        return sellerDonationMapper.modifyCondition(donationCode);
    }

    public void updateCondition(String detailComent, String donationCode){
        sellerDonationMapper.updateCondition(detailComent, donationCode);
    }

    public int isCondition(String donationCode){
        return sellerDonationMapper.isCondition(donationCode);
    }

}
