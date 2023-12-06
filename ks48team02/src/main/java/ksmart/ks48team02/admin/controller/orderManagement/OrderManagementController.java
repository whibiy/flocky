package ksmart.ks48team02.admin.controller.orderManagement;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.common.dto.*;
import ksmart.ks48team02.common.service.delivery.DeliveryService;
import ksmart.ks48team02.common.service.order.OrderService;
import ksmart.ks48team02.common.service.payments.PaymentsService;
import ksmart.ks48team02.user.dto.RewardOption;
import ksmart.ks48team02.user.service.reward.RewardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("adminOrderManagement")
@RequestMapping("/admin/order")
public class OrderManagementController {

    // 로그 추가
    private static final Logger log = LoggerFactory.getLogger(OrderManagementController.class);

    private final OrderService orderService;
    private final PaymentsService paymentsService;
    public final DeliveryService deliveryService;
    public final RewardService rewardService;

    public OrderManagementController(OrderService orderService,
                                     PaymentsService paymentsService,
                                     DeliveryService deliveryService,
                                     RewardService rewardService){

        this.orderService = orderService;
        this.paymentsService = paymentsService;
        this.deliveryService = deliveryService;
        this.rewardService = rewardService;
    }

    // 주문 검색 ajax
    @PostMapping(value="/ajax/search")
    @ResponseBody
    public Map<String, Object> adminOrderSearchAjax(@RequestBody Map<String, Object> searchForm,
                                                    HttpSession session){

        String sid = (String)session.getAttribute("SID");
        String stypecode = (String)session.getAttribute("STYPECODE");
        String sstorecode = (String)session.getAttribute("SSTORECODE");

        searchForm.put("sid", sid);
        searchForm.put("stypecode", stypecode);

        if(sstorecode == null){
            searchForm.put("sstorecode", "empty");
        } else {
            searchForm.put("sstorecode", sstorecode);
        }

        log.info("searchForm : {}", searchForm);

        Map<String, Object> list = orderService.getOrderList(searchForm);
        log.info("검색 결과 목록 : {}", list);

        return list;
    }

    // 주문 대시보드
    @GetMapping(value = {"","/"})
    public String adminOrderDashBoard(Model model){
        model.addAttribute("title","주문 대시보드");
        model.addAttribute("contentsTitle","주문 대시보드");
        model.addAttribute("contentsSubTitle","주문 대시보드");
        return null;
    }

    // 주문 목록
    @GetMapping( "/list")
    public String adminOrderList(Model model,
                                 HttpSession session){

        /*
        * 답변감사합니다..아래 방법으로 해결했습니다.. 간단하게 걍 뻔히 보이는거만 막고싶은거라.. 이런식으로 하는게 제일 좋을거 같네요..
        * out.println("인코딩 : ");
        * out.println(java.net.URLEncoder.encode("한글"));
        * String de = java.net.URLEncoder.encode("한글");
        * out.println("디코딩 : ");
        * out.println(java.net.URLDecoder.decode( de ));
        * */

        String sid = (String) session.getAttribute("SID");
        String stypecode = (String) session.getAttribute("STYPECODE");
        String sstorecode = (String) session.getAttribute("SSTORECODE");

        if(sstorecode == null){
            sstorecode = "empty";
        }

        log.info("sessionId {}", sid);
        log.info("sessionType {}", stypecode);
        log.info("sessionStoreCode {}", sstorecode);

        // default param setting
        model.addAttribute("title","주문 목록");
        model.addAttribute("contentsTitle","주문 목록");
        model.addAttribute("contentsSubTitle","주문 전체 목록");
        model.addAttribute("actionValue","/list");

        String orderby = "orderby";
        int currentPage = 1;
        int rowPerPage = 15;

        Map<String, Object> paramMap = new HashMap<String, Object>();

        paramMap.put("orderby", orderby);
        paramMap.put("currentPage", currentPage);
        paramMap.put("rowPerPage", rowPerPage);
        paramMap.put("sid", sid);
        paramMap.put("stypecode", stypecode);
        paramMap.put("sstorecode", sstorecode);

        log.info("paramMap : {}", paramMap);

        // 주문 목록 진열
        Map<String, Object> resultMap = orderService.getOrderList(paramMap);
        log.info("주문 목록 : {}", resultMap.get("orderList"));
        model.addAttribute("OrderList",resultMap.get("orderList"));
        model.addAttribute("lastPage",resultMap.get("lastPage"));
        model.addAttribute("startPageNum",resultMap.get("startPageNum"));
        model.addAttribute("endPageNum",resultMap.get("endPageNum"));
        model.addAttribute("currentPage",resultMap.get("currentPage"));

        return "admin/order/list";

    }

    // 주문 목록 정렬 ajax
    @PostMapping(value="/list/ajax")
    @ResponseBody
    public Map<String, Object> getOrderListOrderBy(@RequestBody Map<String, Object> paramMap, HttpSession session){
        log.info("currentPage {}", paramMap.get("currentPage"));
        log.info("rowPerPage {}", paramMap.get("rowPerPage"));

        String sid = (String)session.getAttribute("SID");
        String stypecode = (String)session.getAttribute("STYPECODE");
        String sstorecode = (String)session.getAttribute("SSTORECODE");

        paramMap.put("sid", sid);
        paramMap.put("stypecode", stypecode);

        if(sstorecode == null){
            paramMap.put("sstorecode", "empty");
        } else {
            paramMap.put("sstorecode", sstorecode);
        };

        log.info("searchForm : {}", paramMap);

        Map<String, Object> list = orderService.getOrderList(paramMap);
        log.info("ajax list {}", list);

        return list;
    }

    // 주문 상세
    @GetMapping( "/detail")
    public String adminOrderDetail(Model model,
                                   @RequestParam(name="orderCode") String orderCode,
                                   @RequestParam(name="goodsPartition") String goodsPartition){
        log.info("주문 코드 {}", orderCode);

        // 주문 상세 조회
        OrderTotal OrderInfoById = orderService.getOrderInfoById(orderCode);
        log.info("주문 상세 조회 {}", OrderInfoById);

        model.addAttribute("OrderInfoById", OrderInfoById);

        // 주문 분류 모델 (필요 없으니 나중에 체크)
        String orderPartition = OrderInfoById.getGoodsCode();
        orderPartition = orderPartition.substring(0,3);
        log.info("orderPartition {}", orderPartition);
        model.addAttribute("orderPartition", orderPartition);

        // 특정 결제 정보 및 배송 정보조회
        switch(goodsPartition){
            case "RWD":
                // 옵션 정보
                List<RewardOrderDetail> getRewardOptionByOrderCode = orderService.getRewardOptionByOrderCode(orderCode);
                log.info("getRewardOptionByOrderCode {}", getRewardOptionByOrderCode);
                model.addAttribute("getRewardOptionByOrderCode", getRewardOptionByOrderCode);

                // 공고 옵션 조회
                String rewardProjectCode = OrderInfoById.getGoodsCode();
                List<RewardOption> getRewardOptionByCode = rewardService.getRewardOptionByCode(rewardProjectCode);
                log.info("getRewardOptionByCode {}", getRewardOptionByCode);
                model.addAttribute("getRewardOptionByCode", getRewardOptionByCode);

                // 결제 정보
                RewardPayments getRewardPaymentsById = paymentsService.getRewardPaymentsById(orderCode);
                log.info("paymentsInfo {}", getRewardPaymentsById);
                model.addAttribute("paymentsInfo", getRewardPaymentsById);

                // 배송 카테고리 조회
                List<DeliveryCourierCategory> deliveryCourierCategory = deliveryService.getDeliveryCourierCategory();

                log.info("DeliveryCourierCategory : {}", deliveryCourierCategory);

                model.addAttribute("deliveryCourierCategory", deliveryCourierCategory);

                // 배송 정보
                OrderDelivery getDeliveryByCode = deliveryService.getDeliveryByCode(null, orderCode);
                model.addAttribute("getDeliveryByCode", getDeliveryByCode);
                break;
            case "don":
                // 결제 정보
                DonationPayments getDonationPaymentsById = paymentsService.getDonationPaymentsById(orderCode);
                log.info("paymentsInfo {}", getDonationPaymentsById);
                model.addAttribute("paymentsInfo", getDonationPaymentsById);
                break;

            case "inv":
                // 결제 정보
                InvestPayments getInvestPaymentsById = paymentsService.getInvestPaymentsById(orderCode);
                log.info("paymentsInfo {}", getInvestPaymentsById);
                model.addAttribute("paymentsInfo", getInvestPaymentsById);
                break;
        }


        model.addAttribute("title","주문 상세");
        model.addAttribute("contentsTitle","주문 상세");
        model.addAttribute("contentsSubTitle","주문 상세");

        return "admin/order/orderDetailInfo";
    }

    // 배송 관리
    @GetMapping( "/delivery")
    public String adminOrderDelivery(Model model, HttpSession session){
        model.addAttribute("title","배송 관리");
        model.addAttribute("contentsTitle","배송 관리");
        model.addAttribute("contentsSubTitle","배송 관리");
        model.addAttribute("paramActive","noActive");

        String sid = (String) session.getAttribute("SID");
        String stypecode = (String) session.getAttribute("STYPECODE");
        String sstorecode = (String) session.getAttribute("SSTORECODE");

        if(sstorecode == null){
            sstorecode = "empty";
        }

        Map<String, Object> paramMap = new HashMap<String, Object>();

        String orderby = "delived_d";
        int currentPage = 1;
        int rowPerPage = 15;

        paramMap.put("orderby", orderby);
        paramMap.put("currentPage", currentPage);
        paramMap.put("rowPerPage", rowPerPage);
        paramMap.put("sid", sid);
        paramMap.put("stypecode", stypecode);
        paramMap.put("sstorecode", sstorecode);



        // 배송 정보 목록 조회
        Map<String, Object> resultMap = deliveryService.getDeliveryList(paramMap);

        log.info("배송 목록 : {}", resultMap);
        log.info("배송 목록 : {}", resultMap.get("deliveryList"));

        model.addAttribute("deliveryList", resultMap.get("deliveryList"));
        model.addAttribute("lastPage",resultMap.get("lastPage"));
        model.addAttribute("startPageNum",resultMap.get("startPageNum"));
        model.addAttribute("endPageNum",resultMap.get("endPageNum"));
        model.addAttribute("currentPage",resultMap.get("currentPage"));

        return "admin/order/delivery";
    }

    // 배송관리 ajax
    @PostMapping(value = "/delivery/ajax")
    @ResponseBody
    public Map<String, Object> adminOrderDeliveryAjax(@RequestBody Map<String, Object> paramMap,
                                                      HttpSession session){

        String sid = (String)session.getAttribute("SID");
        String stypecode = (String)session.getAttribute("STYPECODE");
        String sstorecode = (String)session.getAttribute("SSTORECODE");

        paramMap.put("sid", sid);
        paramMap.put("stypecode", stypecode);

        if(sstorecode == null){
            paramMap.put("sstorecode", "empty");
        } else {
            paramMap.put("sstorecode", sstorecode);
        }

        log.info("param {}", paramMap);
        log.info("currentPage {}", paramMap.get("currentPage"));
        log.info("rowPerPage {}", paramMap.get("rowPerPage"));
        Map<String, Object> list = deliveryService.getDeliveryList(paramMap);
        log.info("ajax list {}", list);

        return list;
    }

    // 특정 배송 정보 조회
    @GetMapping( "/delivery/detail")
    public String adminOrderDeliveryInfo(Model model,
                                         @RequestParam(name="orderDeliveryCode") String orderDeliveryCode){
        model.addAttribute("title","배송 정보");
        model.addAttribute("contentsTitle","배송 정보");
        model.addAttribute("contentsSubTitle","배송 정보");


        // 특정 배송 정보 조회
        OrderDelivery getDeliveryByCode = deliveryService.getDeliveryByCode(orderDeliveryCode, null);

        log.info("getDeliveryByCode : {}", getDeliveryByCode);

        model.addAttribute("getDeliveryByCode", getDeliveryByCode);

        // 배송 카테고리 조회
        List<DeliveryCourierCategory> deliveryCourierCategory = deliveryService.getDeliveryCourierCategory();

        log.info("DeliveryCourierCategory : {}", deliveryCourierCategory);

        model.addAttribute("deliveryCourierCategory", deliveryCourierCategory);

        return "admin/order/deliveryDetailInfo";
    }


    // 교환 환불 신청 관리 main
    @GetMapping( "/refundSwapping")
    public String adminOrderRefundSwapping(Model model,HttpSession session){
        model.addAttribute("title","교환 환불 관리");
        model.addAttribute("contentsTitle","교환/환불 관리");
        model.addAttribute("contentsSubTitle","교환/환불 관리");

        String sid = (String) session.getAttribute("SID");
        String stypecode = (String) session.getAttribute("STYPECODE");
        String sstorecode = (String) session.getAttribute("SSTORECODE");

        if(sstorecode == null){
            sstorecode = "empty";
        }

        Map<String, Object> paramMap = new HashMap<String, Object>();

        String orderby = "application_d";
        int currentPage = 1;
        int rowPerPage = 15;
        String pageValue = "refund";

        paramMap.put("orderby", orderby);
        paramMap.put("currentPage", currentPage);
        paramMap.put("rowPerPage", rowPerPage);
        paramMap.put("pageValue",  pageValue);
        paramMap.put("sid", sid);
        paramMap.put("stypecode", stypecode);
        paramMap.put("sstorecode", sstorecode);

        Map<String, Object> resultMap = orderService.getApplicationList(paramMap);
        log.info("RefundApplicationList {}", resultMap.get("list"));

        model.addAttribute("RefundApplicationList", resultMap.get("list"));
        model.addAttribute("lastPage",resultMap.get("lastPage"));
        model.addAttribute("startPageNum",resultMap.get("startPageNum"));
        model.addAttribute("endPageNum",resultMap.get("endPageNum"));
        model.addAttribute("currentPage",resultMap.get("currentPage"));

        return "admin/order/refundSwapping";
    }

    // 교환 환불 신청 관리 ajax
    @PostMapping(value = "/rfndSwap/ajax")
    @ResponseBody
    public Map<String, Object> admRefdSwapAjax(@RequestBody Map<String, Object> paramMap,
                                               HttpSession session){

        String sid = (String)session.getAttribute("SID");
        String stypecode = (String)session.getAttribute("STYPECODE");
        String sstorecode = (String)session.getAttribute("SSTORECODE");

        paramMap.put("sid", sid);
        paramMap.put("stypecode", stypecode);

        if(sstorecode == null){
            paramMap.put("sstorecode", "empty");
        } else {
            paramMap.put("sstorecode", sstorecode);
        }

        log.info("param {}", paramMap);

        Map<String, Object> list = orderService.getApplicationList(paramMap);
        log.info("refund swapping list {}", list);
        return list;
    }

    // 자동 환불 목록 조회
    @GetMapping("/autorfnd")
    public String admAutoRefdList(Model model, HttpSession session){

        model.addAttribute("title","자동 환불 관리");
        model.addAttribute("contentsTitle","자동 환불 관리");
        model.addAttribute("contentsSubTitle","프로젝트 실패 자동 환불 관리");

        String sid = (String) session.getAttribute("SID");
        String stypecode = (String) session.getAttribute("STYPECODE");
        String sstorecode = (String) session.getAttribute("SSTORECODE");

        if(sstorecode == null){
            sstorecode = "empty";
        }

        Map<String, Object> paramMap = new HashMap<String, Object>();

        String orderby = "application_d";
        int currentPage = 1;
        int rowPerPage = 15;

        paramMap.put("orderby", orderby);
        paramMap.put("currentPage", currentPage);
        paramMap.put("rowPerPage", rowPerPage);
        paramMap.put("sid", sid);
        paramMap.put("stypecode", stypecode);
        paramMap.put("sstorecode", sstorecode);

        Map<String, Object> resultMap = orderService.getAutoRefdList(paramMap);

        log.info("list {}", resultMap.get("list"));

        model.addAttribute("list", resultMap.get("list"));
        model.addAttribute("lastPage",resultMap.get("lastPage"));
        model.addAttribute("startPageNum",resultMap.get("startPageNum"));
        model.addAttribute("endPageNum",resultMap.get("endPageNum"));
        model.addAttribute("currentPage",resultMap.get("currentPage"));

        return "admin/order/autoRefund";
    }

    // 자동 환불 ajax
    @PostMapping(value = "/autoRfnd/ajax")
    @ResponseBody
    public Map<String, Object> admAutoRefdListAjax(@RequestBody Map<String, Object> paramMap,
                                                   HttpSession session){
        String sid = (String)session.getAttribute("SID");
        String stypecode = (String)session.getAttribute("STYPECODE");
        String sstorecode = (String)session.getAttribute("SSTORECODE");

        paramMap.put("sid", sid);
        paramMap.put("stypecode", stypecode);

        if(sstorecode == null){
            paramMap.put("sstorecode", "empty");
        } else {
            paramMap.put("sstorecode", sstorecode);
        }

        log.info("param {}", paramMap);


        Map<String, Object> list = orderService.getAutoRefdList(paramMap);
        return list;
    }

    // 주문 확정 목록 조회
    @GetMapping( "/completedList")
    public String adminOrderCompletedList(Model model){
        model.addAttribute("title","주문 확정 목록");
        model.addAttribute("contentsTitle","주문 확정 목록");
        model.addAttribute("contentsSubTitle","주문 확정 목록");

        Map<String, Object> paramMap = new HashMap<String, Object>();

        String orderby = "order_d";
        int currentPage = 1;
        int rowPerPage = 15;

        paramMap.put("orderby", orderby);
        paramMap.put("currentPage", currentPage);
        paramMap.put("rowPerPage", rowPerPage);

        Map<String, Object> resultMap = orderService.getOrderConfLogList(paramMap);

        model.addAttribute("confLogList", resultMap.get("confLogList"));
        model.addAttribute("lastPage",resultMap.get("lastPage"));
        model.addAttribute("startPageNum",resultMap.get("startPageNum"));
        model.addAttribute("endPageNum",resultMap.get("endPageNum"));
        model.addAttribute("currentPage",resultMap.get("currentPage"));

        return "admin/order/orderCompletedList";
    }

    // 주문 확정 조회 ajax
    @PostMapping("/completedList/ajax")
    @ResponseBody
    public Map<String, Object> admOrderCmptedListAjax(@RequestBody Map<String, Object> paramMap){

        log.info("param {}", paramMap);

        Map<String, Object> list = orderService.getOrderConfLogList(paramMap);
        log.info("list : {}", list);

        return list;
    }


}

