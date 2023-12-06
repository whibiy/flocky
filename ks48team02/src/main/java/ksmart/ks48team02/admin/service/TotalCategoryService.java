package ksmart.ks48team02.admin.service;

import ksmart.ks48team02.admin.dto.TotalCategory;
import ksmart.ks48team02.admin.mapper.TotalCategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TotalCategoryService {

    private final TotalCategoryMapper totalCategoryMapper;

    public List<TotalCategory> categoryByPatition (String patition) {

        List<TotalCategory> categoryList = totalCategoryMapper.categoryByPatition(patition);

        return categoryList;
    };


}
