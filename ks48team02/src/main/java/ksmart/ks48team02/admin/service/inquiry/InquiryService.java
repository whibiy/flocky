package ksmart.ks48team02.admin.service.inquiry;

import ksmart.ks48team02.admin.dto.Inquiry;
import ksmart.ks48team02.admin.dto.InquiryPage;
import ksmart.ks48team02.admin.mapper.inquiry.InquiryMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class InquiryService {

    public InquiryService(InquiryMapper inquiryMapper){
        this.inquiryMapper = inquiryMapper;
    }

    @Autowired
    private InquiryMapper inquiryMapper;

    // 문의 관리 목록 조회
    public List<Inquiry> getInquiryList(){

        return inquiryMapper.getInquiryList();
    }

    // 문의관리
    public List<Inquiry> getInquiryPage(){

        return inquiryMapper.getInquiryPage();
    }

    // 문의 관리 답변
    public List<Inquiry> getInquiryModifyList(){

        return inquiryMapper.getInquiryModifyList();
    }
    // 특정 문의 관리 답변
    public Inquiry getInquiryModifyListByCode(String inquireCode){

        return inquiryMapper.getInquiryModifyListByCode(inquireCode);
    }

    // 문의 관리 답변 post
    public void inquiryModiPost(Inquiry inquiry){
        inquiryMapper.inquiryModiPost(inquiry);
    }


}
