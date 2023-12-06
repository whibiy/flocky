package ksmart.ks48team02.admin.mapper;


import ksmart.ks48team02.admin.dto.TotalCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TotalCategoryMapper {



    //프로젝트 타입에 따른 카테고리 조회.
    public List<TotalCategory> categoryByPatition (String patition);


}
