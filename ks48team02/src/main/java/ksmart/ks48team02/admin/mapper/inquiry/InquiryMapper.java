package ksmart.ks48team02.admin.mapper.inquiry;
import ksmart.ks48team02.admin.dto.Inquiry;
import ksmart.ks48team02.admin.dto.InquiryPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InquiryMapper {

    // 문의 관리
    public List<Inquiry> getInquiryPage();

    // 문의 관리 목록 조회
    public List<Inquiry> getInquiryList();

    // 문의 관리 답변 페이지
    public List<Inquiry> getInquiryModifyList();

    // 특정 문의 관리 답변 페이지
    public Inquiry getInquiryModifyListByCode(String inquireCode);

    // 문의 관리 답변 post
    void inquiryModiPost(Inquiry inquiry);

}
