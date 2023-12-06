package ksmart.ks48team02.common.service.delivery;

import ksmart.ks48team02.admin.controller.orderManagement.OrderManagementController;
import ksmart.ks48team02.common.dto.DeliveryCourierCategory;
import ksmart.ks48team02.common.dto.OrderDelivery;
import ksmart.ks48team02.common.mapper.delivery.DeliveryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeliveryService {

    // 로그 추가
    private static final Logger log = LoggerFactory.getLogger(OrderManagementController.class);


    // DI 의존성 주입
    private final DeliveryMapper deliveryMapper;

    public DeliveryService(DeliveryMapper deliveryMapper){
        this.deliveryMapper = deliveryMapper;
    }
    // 배송 목록 조회
    public Map<String, Object> getDeliveryList(Map<String, Object> paramMap) {

        Map<String, Object> resultMap = null;

        int currentPage = 0;
        int rowPerPage = 0;
        if (paramMap != null) {
            String orderby = (String) paramMap.get("orderbyValue");
            Object currentPageObj = paramMap.get("currentPage");
            Object rowPerPageObj = paramMap.get("rowPerPage");

            if (currentPageObj != null) {
                try {
                    double currentPageDouble = Double.parseDouble(currentPageObj.toString());
                    currentPage = (int) currentPageDouble;
                    double rowPerPageDouble = Double.parseDouble(rowPerPageObj.toString());
                    rowPerPage = (int) rowPerPageDouble;
                } catch (NumberFormatException e) {
                    // currentPageObj가 숫자로 변환될 수 없는 경우의 예외 처리
                    System.out.println(e);
                }
            }

        }

        log.info("currentPage : {}", currentPage);
        log.info("rowPerPage : {}", rowPerPage);
        // 행의 시작점
        int startRowNum = (currentPage - 1) * rowPerPage; // (1 - 1) * 15 = 0

        // 전체 행의 갯수
        double rowCnt = deliveryMapper.getDeliveryCnt(paramMap);

        // 마지막 페이지 수
        int lastPage = 0;

        if(rowCnt == 0){
            lastPage = 1;
        } else {
            lastPage = (int) Math.ceil(rowCnt / rowPerPage); // 25 / 15;
        }

        // 보여줄 페이지 번호 초깃값
        int startPageNum = 1;

        // 마지막 페이지 번호
        int endPageNum = (lastPage < 10) ? lastPage : lastPage * currentPage;

        paramMap.put("startRowNum", startRowNum);
        paramMap.put("rowCnt", rowCnt);
        paramMap.put("lastPage", lastPage);
        paramMap.put("startPageNum", startPageNum);
        paramMap.put("endPageNum", endPageNum);

        log.info("paramMap : {}", paramMap);

        resultMap = new HashMap<String, Object>();

        List<OrderDelivery> deliveryList = null;
        deliveryList = deliveryMapper.getDeliveryList(paramMap);

        resultMap.put("deliveryList", deliveryList); // 조회 객체
        resultMap.put("lastPage", lastPage); // 마지막 페이지
        resultMap.put("startPageNum", startPageNum); // 시작 페이지
        resultMap.put("currentPage", currentPage); // 현재 페이지
        resultMap.put("endPageNum", endPageNum); // 끝 페이지

        return resultMap;

    }

    // 특정 배송 정보 조회
    public OrderDelivery getDeliveryByCode(String orderDeliveryCode, String orderCode){
        OrderDelivery  getDeliveryByCode = null;
        if(orderDeliveryCode != null){
            getDeliveryByCode = deliveryMapper.getDeliveryByCode(orderDeliveryCode, null);
        } else if(orderCode != null){
            getDeliveryByCode = deliveryMapper.getDeliveryByCode(null, orderCode);
        }
        return getDeliveryByCode;
    };

    // 배송 택배사 카테고리 조회
    public List<DeliveryCourierCategory> getDeliveryCourierCategory(){
        List<DeliveryCourierCategory> DeliveryCourierCt = null;
        DeliveryCourierCt = deliveryMapper.getDeliveryCourierCategory();
        return DeliveryCourierCt;
    };
}
