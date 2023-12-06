package ksmart.ks48team02.user.controller;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.user.dto.*;
import ksmart.ks48team02.user.service.main.UserMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("userMainController")
@RequestMapping("/user")
public class MainController {

	// 로그 추가
	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	// DI 의존성 추가
	public final UserMainService userMainService;

	public MainController(UserMainService userMainService){
		this.userMainService = userMainService;
	}

	@PostMapping(value="/ajax/rankCategory")
	@ResponseBody
	public List<OrderRank> getRankCategory(Model model,
										   @RequestParam(name="rankCategory",
													 required = false,
													 defaultValue = "achievementPercent") String rankCategory){
//		System.out.println(rankCategory);
		List<OrderRank> list = userMainService.getRankList(rankCategory);
//		System.out.println(list);
		return list;
	}

	@GetMapping(value = {"" , "/"})
	public String mainPage(Model model,
						   HttpSession session,
						   @RequestParam(name="rankCategory",
								   		 required = false,
								   		 defaultValue = "achievementPercent") String rankCategory) {

		// 추천 콘텐츠
		String sid = (String) session.getAttribute("SID");
		List<RecommendCategory> getRecommendCtList = null;

		if(sid != null){
			getRecommendCtList = userMainService.getRecommendCtList(sid);
		}
		log.info("getRecommendCtList {}", getRecommendCtList);

		List<TotalRecommendProject> getRecommendPjgList = userMainService.getRecommendPjgList(getRecommendCtList);

		log.info("getRecommendPjgList {}", getRecommendPjgList);

		model.addAttribute("getRecommendPjgList", getRecommendPjgList);

		// 랭크 데이터
		List<OrderRank> rankList = userMainService.getRankList(rankCategory);

		log.info("랭크 데이터 :{}", rankList);
		model.addAttribute("rankList", rankList);

		// 스토어 추천
		List<TotalRecommendProject> getStorePrjList = userMainService.getStorePrjList();
		log.info("getStorePrjList {}", getStorePrjList);
		model.addAttribute("storeList", getStorePrjList);

		// 리워드 추천 프로젝트
		List<RewardProject> getRewardProjectList = userMainService.getRewardPrjList();

		log.info("getRewardProjectList {}", getRewardProjectList);
		model.addAttribute("rewardProjectList", getRewardProjectList);

		// 기부 추천 프로젝트
		List<DonationRegistration> getDonationPrjList = userMainService.getDonationPrjList();
		log.info("getDonationPrjList {}", getDonationPrjList);
		model.addAttribute("donationPrjList", getDonationPrjList);

		// 투자 추천 프로젝트
		List<InvestmentInfo> getInvestPrjList = userMainService.getInvestPrjList();
		log.info("getInvestPrjList {}", getInvestPrjList);
		model.addAttribute("investPrjList", getInvestPrjList);

		return "user/index";
	}

	@GetMapping("/upload")
	public String uploadPage(){

		return "fileupload/upload";
	}


}
