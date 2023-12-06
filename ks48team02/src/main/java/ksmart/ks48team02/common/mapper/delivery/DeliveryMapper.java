package ksmart.ks48team02.common.mapper.delivery;

import ksmart.ks48team02.common.dto.DeliveryCourierCategory;
import ksmart.ks48team02.common.dto.OrderDelivery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeliveryMapper {

    // 배송 목록 조회
    public List<OrderDelivery> getDeliveryList(Map<String, Object> paramMap);

    // 전체 배송 목록 수 조회
    public int getDeliveryCnt(Map<String, Object> paramMap);

    // 특정 배송 목록 조회
    public OrderDelivery getDeliveryByCode(String orderDeliveryCode, String orderCode);

    // 배송 택배사 카테고리 조회
    public List<DeliveryCourierCategory> getDeliveryCourierCategory();
}
