package ksmart.ks48team02.seller.controller.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("sellerOrderManagementController")
@RequestMapping("/seller")
public class OrderManagementController {

    // 리워드 주문 목록
    @GetMapping("/reword/order/list")
    public String sellerRewardOrderPage(Model model){
        model.addAttribute("title","판매자 : 리워드 주문 목록");
        model.addAttribute("contentsTitle","리워드 주문 목록");
        model.addAttribute("contentsSubTitle","리워드 주문 목록");
        return "/seller/reward/orderManagement/list";
    }
    // 리워드 주문 상세
    @GetMapping("/reword/order/detail")
    public String sellerRewardOrderDetail(Model model){
        model.addAttribute("title","판매자 : 리워드 주문 상세");
        model.addAttribute("contentsTitle","리워드 주문 상세");
        model.addAttribute("contentsSubTitle","리워드 주문 상세");
        return "/seller/reward/orderManagement/orderDetailInfo";
    }

    // 리워드 주문 대시보드
    @GetMapping("/reword/order")
    public String sellerRewardOrderDashboard(Model model){
        model.addAttribute("title","판매자 : 리워드 주문 대시보드");
        model.addAttribute("contentsTitle","리워드 주문 대시보드");
        model.addAttribute("contentsSubTitle","리워드 주문 대시보드");
        return "/seller/reward/orderManagement/main";
    }

    // 리워드 배송 관리
    @GetMapping("/reword/order/delivery")
    public String sellerRewardOrderDelivery(Model model){
        model.addAttribute("title","판매자 : 리워드 배송 관리");
        model.addAttribute("contentsTitle","배송 관리");
        model.addAttribute("contentsSubTitle","리워드 배송 관리");
        return "/seller/reward/orderManagement/delivery";
    }

    // 리워드 배송 정보 등록
    @GetMapping("/reword/order/delivery/add")
    public String sellerRewardOrderDeliveryAdd(Model model){
        model.addAttribute("title","판매자 : 리워드 배송 정보 입력");
        model.addAttribute("contentsTitle","배송 정보 입력");
        model.addAttribute("contentsSubTitle","배송 정보 입력");
        return "/seller/reward/orderManagement/addDelivery";
    }
    // 리워드 배송 정보 상세
    @GetMapping("/reword/order/delivery/detail")
    public String sellerRewardOrderDeliveryDetail(Model model){
        model.addAttribute("title","판매자 : 리워드 배송 정보");
        model.addAttribute("contentsTitle","배송 정보");
        model.addAttribute("contentsSubTitle","배송 정보");
        return "/seller/reward/orderManagement/deliveryDetailInfo";
    }

    // 리워드 교환 환불 신청 관리
    @GetMapping("/reword/order/reFund")
    public String sellerRewardOrderRefund(Model model){
        model.addAttribute("title","판매자 : 교환/환불 신청 관리");
        model.addAttribute("contentsTitle","교환/환불 신청 관리");
        model.addAttribute("contentsSubTitle","리워드 교환 환불 신청 관리");
        return "/seller/reward/orderManagement/refundApplication";
    }

    // 환불 신청 상세
    @GetMapping("/reword/order/refund/detail")
    public String sellerRefundDetailInfo(Model model){
        model.addAttribute("title","판매자 : 환불 상세 정보");
        model.addAttribute("contentsTitle","환불 상세 정보");
        model.addAttribute("contentsSubTitle","리워드 환불 상세 정보");
        return "/seller/reward/orderManagement/refundDetailInfo";
    }


    // 교환 신청 상세
    @GetMapping("/reword/order/Swapping/detail")
    public String sellerSwappingDetailInfo(Model model){
        model.addAttribute("title","판매자 : 교환 상세 정보");
        model.addAttribute("contentsTitle","교환 상세 정보");
        model.addAttribute("contentsSubTitle","리워드 교환 상세 정보");
        return "/seller/reward/orderManagement/swappingDetailInfo";
    }
    // 리워드 자동 환불 신청 관리
    @GetMapping("/reword/order/autoReFund")
    public String sellerRewardOrderAutoRefund(Model model){
        model.addAttribute("title","판매자 : 리워드 자동 환불 목록");
        model.addAttribute("contentsTitle","리워드 자동 환불 목록");
        model.addAttribute("contentsSubTitle","리워드 자동 환불 목록");
        return "/seller/reward/orderManagement/autoRefundList";
    }

    // 기부 주문 목록
    @GetMapping("/donation/order/list")
    public String sellerDonationOrderPage(Model model){
        model.addAttribute("title","판매자 : 기부 주문 목록");
        model.addAttribute("contentsTitle","기부 주문 목록");
        model.addAttribute("contentsSubTitle","기부 주문 목록");
        return "/seller/donation/orderManagement/list";
    }
    // 기부 주문 상세
    @GetMapping("/donation/order/detail")
    public String sellerDonationOrderDetail(Model model){
        model.addAttribute("title","판매자 : 주문 상세");
        model.addAttribute("contentsTitle","주문 상세");
        model.addAttribute("contentsSubTitle","주문 상세");
        return "/seller/donation/orderManagement/orderDetailInfo";
    }
    // 기부 대시보드
    @GetMapping("/donation/order")
    public String sellerDonationOrderDashboard(Model model){
        model.addAttribute("title","판매자 : 기부 주문 대시보드");
        model.addAttribute("contentsTitle","기부 주문 대시보드");
        model.addAttribute("contentsSubTitle","기부 주문 대시보드");
        return "/seller/donation/orderManagement/main";
    }

    // 투자 주문 목록
    @GetMapping("/investment/order/list")
    public String sellerInvestmentOrderPage(Model model){
        model.addAttribute("title","판매자 : 투자 주문 목록");
        model.addAttribute("contentsTitle","투자 주문 목록");
        model.addAttribute("contentsSubTitle","투자 주문 목록");
        return "/seller/investment/order/list";
    }
    // 투자 주문 대시보드
    @GetMapping("/investment/order")
    public String sellerInvestmentOrderDashboard(Model model){
        model.addAttribute("title","판매자 : 투자 주문 대시보드");
        model.addAttribute("contentsTitle","투자 주문 대시보드");
        model.addAttribute("contentsSubTitle","투자 주문 대시보드");
        return "/seller/investment/order/main";
    }
    // 투자 주문 상세
    @GetMapping("/investment/order/detail")
    public String sellerInvestmentOrderDetail(Model model){
        model.addAttribute("title","판매자 : 주문 상세");
        model.addAttribute("contentsTitle","주문 상세");
        model.addAttribute("contentsSubTitle","투자 주문 상세");
        return "/seller/investment/order/orderDetailInfo";
    }
    // 리워드 자동 환불 신청 관리
    @GetMapping("/investment/order/autoReFund")
    public String sellerInvestmentOrderAutoRefund(Model model){
        model.addAttribute("title","판매자 : 투자 자동 환불 목록");
        model.addAttribute("contentsTitle","투자 자동 환불 목록");
        model.addAttribute("contentsSubTitle","투자 자동 환불 목록");
        return "/seller/investment/order/autoRefundList";
    }
}
