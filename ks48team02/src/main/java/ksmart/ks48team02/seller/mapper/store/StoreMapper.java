package ksmart.ks48team02.seller.mapper.store;

import ksmart.ks48team02.seller.dto.Store;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreMapper {
    public String getStoreCodeById(String memberId);

}
