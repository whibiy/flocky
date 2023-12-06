package ksmart.ks48team02.admin.service.coupon;


import ksmart.ks48team02.admin.dto.Coupon;
import ksmart.ks48team02.admin.mapper.coupon.AdminCouponMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminCouponService {
    // DI 의존성
    private final AdminCouponMapper adminCouponMapper;

    // 생성자 메소드를 통한 DI
    public AdminCouponService(AdminCouponMapper adminCouponMapper){
        this.adminCouponMapper = adminCouponMapper;
    }

    // 쿠폰 삭제
    public void deleteCoupon(String couponCode){
        adminCouponMapper.deleteCoupon(couponCode);
    }


    // 쿠폰 수정
    public int updateCoupon(Coupon coupon){
        System.out.println(coupon);
        return adminCouponMapper.updateCoupon(coupon);
    }

    // 쿠폰 등록
    public void insertCoupon(Coupon coupon) {
        adminCouponMapper.insertCoupon(coupon);
    }

    // 쿠폰 목록
    public List<Coupon> getCouponList(){
        List<Coupon> couponList = adminCouponMapper.getCouponList();

        return couponList;
    }

    //회원 아이디 별 보유 쿠폰목록 조회
    public List<Coupon> MemberHaveCouponById(String memberId) {
        List<Coupon> memberHaveCouponList = adminCouponMapper.MemberHaveCouponById(memberId);

        return memberHaveCouponList;
    }

    // 특정 쿠폰 조회
    public Coupon getCouponCodeById(String couponCode) {
        Coupon getCouponCodeById = adminCouponMapper.getCouponCodeById(couponCode);

        return getCouponCodeById;
    }

}
