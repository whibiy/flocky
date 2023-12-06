package ksmart.ks48team02.admin.controller.site;

import ksmart.ks48team02.admin.dto.Category;
import ksmart.ks48team02.admin.service.category.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller("adminSiteController")
@RequestMapping("/admin/site")
public class SiteController {

    @Autowired
    private CategoryService categoryService;
    private static final Logger log = LoggerFactory.getLogger(SiteController.class);


    public SiteController( CategoryService categoryService){
        this.categoryService = categoryService;
    }

    // 카테고리 수정 post
    @PostMapping("/categoryModify")
    // ResponseEntity 메소드의 반환형
    public ResponseEntity<String> categoryUpdatePost(Model model, Category category){
        categoryService.updateCategory(category);
        model.addAttribute("title", "카테고리 수정");
        try {// 상태코드가 200 이면 ResponseEntity 객체를 생성
            categoryService.updateCategory(category);
            // 문제없이 잘 되면 Success 표시
            return ResponseEntity.ok().body("{\"message\": \"Success\"}");  // JSON 형태의 응답을 반환
        } catch (Exception e) {
            // try 실행시 문제 있으면 에러 표시 (if문 else 랑 비슷한 개념
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"Error\"}");  // 에러가 발생했을 때 에러 응답을 반환
        }
    }

    // 카테고리 수정
    @GetMapping("/categoryModify")
    public String categoryUpdate(@RequestParam(name = "totalCategoryCode", required = false) String totalCateogryCode,
                                 Model model){
        log.info("totalCategory: {}", totalCateogryCode);

        List<Category> categoryUpdate = categoryService.getCategoryCodeById(totalCateogryCode);

        log.info("특정 카테고리 정보 조회: {}", categoryUpdate);

        model.addAttribute("title", "카테고리 수정");
        model.addAttribute("categoryUpdate", categoryUpdate);

        return "admin/site/categoryModify";
    }



    // 카테고리 목록
    @GetMapping("/category")
    public String categoryPage(Model model){
        List<Category> categoryList = categoryService.getCategoryList("total");

        model.addAttribute("title", "카테고리 목록");
        model.addAttribute("categoryList", categoryList);


        return "admin/site/category";
    }


    // 카테고리 목록 ajax
    @PostMapping("/ajaxCategory")
    @ResponseBody
    public List<Category> categoryAjax(@RequestParam(name = "cateSelect") String cateSelect,
                                       Model model){
        // 객체 소환
        List<Category> list = categoryService.getCategoryList(cateSelect);

        log.info("카테고리 목록 : {}", list);
        return list;
    }

    // 카테고리 등록 ajax
    @PostMapping("/ajaxCategoryAdd")
    @ResponseBody
    public List<Category> categoryAddAjax(@RequestParam(name = "projectPatition") String projectPatition,
                                      Model model){

        List<Category> list = categoryService. getCategoryDepth2(projectPatition);
        log.info("중분류 조회 : {}", list);
        model.addAttribute("title", "카테고리 등록");

        return list;
}

    // 카테고리 등록 post
    @PostMapping("/categoryAdd")
    public String categoryAddPost(@ModelAttribute Category category, Model model){

        model.addAttribute("title", "카테고리 등록");
        categoryService.createCategory(category);

        return "redirect:/admin/site/categoryAdd";
    }

    // 카테고리 등록
    @GetMapping("/categoryAdd")
    public String categoryAddPage(Model model){

        List<Category> categoryAdd = categoryService.getCategoryAdd();

        model.addAttribute("title", "카테고리 등록");
        model.addAttribute("categoryAdd", categoryAdd);

        return "admin/site/categoryAdd";

}

    // 알림 관리
    @GetMapping("/notification")
    public String notifiPage(){

        return "admin/site/notification";
    }

    // 알림 등록
    @GetMapping("/notificationAdd")
    public String notifiAddPage(){

        return "admin/site/notificationAdd";
    }
}
