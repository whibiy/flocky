package ksmart.ks48team02.user.service.storePage;

import ksmart.ks48team02.user.dto.StorePageDto;
import ksmart.ks48team02.user.mapper.storePage.StorePageMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/* StorePageService의 구현체 */
@Service
@AllArgsConstructor
public class StorPageServiceImpl implements StorePageService {
    StorePageMapper storePageMapper;

    @Override
    public List<StorePageDto> storePageNewsList(String storeCode){
      return storePageMapper.storePageNewsList(storeCode);
   }

//    @Override
//    public List<StorePageDto> storePageNewsList(){
//        return storePageMapper.storePageNewsList();
//    }
}
