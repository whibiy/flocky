package ksmart.ks48team02.admin.mapper.category;

import ksmart.ks48team02.admin.dto.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    // 카테고리 전체 조회
    public List<Category> getCategoryList(String cateSelect);

    // ajax 카테고리 등록
    public List<Category> getCategoryAdd();

    // ajax category depth 2
    public List<Category> getCategoryDepth2(String projectPatition);

    // 특정 카테고리 조회
    List<Category> getCategoryCodeById(String totalCategoryCode);

    // 카테고리 수정 post
    void updateCategory(Category category);

    // 카테고리 등록
    void createCategory(Category category);
}
