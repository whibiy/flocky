package ksmart.ks48team02.user.service.storePage;

import ksmart.ks48team02.user.dto.StorePageDto;

import java.util.List;

public interface StorePageService {

    List<StorePageDto> storePageNewsList(String storeCode);

}
