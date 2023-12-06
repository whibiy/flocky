package ksmart.ks48team02.seller.service.store;

import ksmart.ks48team02.seller.dto.Store;
import ksmart.ks48team02.seller.mapper.store.StoreMapper;
import org.springframework.stereotype.Service;

@Service
public class StoreService {

    private final StoreMapper storeMapper;

    public StoreService(StoreMapper storeMapper){
        this.storeMapper = storeMapper;
    }

    public String getStoreCodeById(String memberId){
        return storeMapper.getStoreCodeById(memberId);
    };
}
