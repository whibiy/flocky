package ksmart.ks48team02.user.mapper.storePage;

import ksmart.ks48team02.user.dto.StorePageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StorePageMapper {
    List<StorePageDto> storePageNewsList(String storeCode);
}
