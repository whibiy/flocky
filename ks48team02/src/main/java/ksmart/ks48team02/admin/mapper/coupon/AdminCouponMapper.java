package ksmart.ks48team02.admin.mapper.coupon;

import ksmart.ks48team02.admin.dto.Coupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminCouponMapper {

    // 쿠폰 삭제
    void deleteCoupon(String couponCode);

    // 쿠폰 수정
    int updateCoupon(Coupon coupon);

    // 쿠폰 등록
    void insertCoupon(Coupon coupon);

    //전체 쿠폰 조회
    public List<Coupon> getCouponList();

    //회원 아이디 별 보유 쿠폰목록 조회
    public List<Coupon> MemberHaveCouponById(String memberId);

    // 특정 쿠폰 조회
    public Coupon getCouponCodeById(String couponCode);

}
