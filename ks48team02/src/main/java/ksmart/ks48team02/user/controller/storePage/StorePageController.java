package ksmart.ks48team02.user.controller.storePage;

import ksmart.ks48team02.user.dto.RewardProject;
import ksmart.ks48team02.user.dto.StorePageDto;
import ksmart.ks48team02.user.service.reward.RewardService;
import ksmart.ks48team02.user.service.storePage.StorePageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller("storePageController")
@RequestMapping("/user/storePage")
@AllArgsConstructor
public class StorePageController {

    private final StorePageService storePageService;
    private final RewardService rewardService;

    // 프로젝트 상세페이지에서 스토어 클릭시 해당 스토어 페이지로 이동 (스토어 코드 이용)
    @GetMapping("/{storeCode}")
    public String storeDetailPage(@PathVariable(name = "storeCode") String storeCode, Model model){
        log.info("storeCode: {}", storeCode);
        // 스토어 코드에 따른 해당 스토어 정보 가져오기 (리워드 / 기부 / 투자 )
        //List<RewardProject> rewardProjectList = rewardService.rewardProjectList(store)
        // (storeCode) -> 스토어 정보 & 스토어가 진행한 전체 프로젝트 정보 & 스토어 뉴스 정보


        return "user/storePage/main";
    }


    @GetMapping(value = {"","/"})
    public String storePage(@RequestParam(name="storeCode") String storeCode, Model model){

            List<StorePageDto> storeNewsList = storePageService.storePageNewsList(storeCode); //  반환된 List<StorePageDto>에는 각 뉴스 항목에 대한 StorePageDto 객체가 포함

            // 게시된 날짜 (오늘로부터 ~일 전)
            LocalDateTime currentDate = LocalDateTime.now();

            Map<String, Long> daysAgoMap = new HashMap<>();

            long daysAgo = 0;
            for(StorePageDto storePageDto : storeNewsList ){
                LocalDateTime createdDatetime = storePageDto.getCreatedDatetime(); // 뉴스 게시 날짜

                daysAgo = Duration.between(createdDatetime, currentDate).toDays();
                daysAgoMap.put("daysAgo", daysAgo);
            }

//            if(!storeNewsList.isEmpty()){
//                StorePageDto storePagedto = storeNewsList.get(0);
//                LocalDateTime createdDatetime = storePagedto.getCreatedDatetime();

//                daysAgo = Duration.between(createdDatetime, currentDate).toDays();
//            }

            model.addAttribute("daysAgo",daysAgo);
            model.addAttribute("daysAgoMap", daysAgoMap);
            model.addAttribute("currentDate", currentDate);
            model.addAttribute("newsList", storeNewsList);

            return "user/storePage/storeName";
    }

    }