package ksmart.ks48team02.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.dto.TotalCategory;
import ksmart.ks48team02.admin.service.TotalCategoryService;
import ksmart.ks48team02.user.dto.*;
import ksmart.ks48team02.user.service.donation.DonationService;
import ksmart.ks48team02.user.service.investment.UserInvestmentService;
import ksmart.ks48team02.user.service.reward.RewardService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import java.util.*;
@Controller
@RequestMapping("/user/projectRegistration")
public class PojectRegistrationContoller {

    private static final Logger log = LoggerFactory.getLogger(PojectRegistrationContoller.class);
    private final DonationService donationService;

    private final UserInvestmentService userInvestmentService;

    private final TotalCategoryService totalCategoryService;

    private final RewardService rewardService;

    public PojectRegistrationContoller(DonationService donationService, TotalCategoryService totalCategoryService, UserInvestmentService userInvestmentService, RewardService rewardService){
        this.donationService = donationService;
        this.totalCategoryService = totalCategoryService;
        this.userInvestmentService = userInvestmentService;
        this.rewardService = rewardService;
    }

    //프로젝트 등록 메인 페이지
    @GetMapping(value = {"" , "/"})
    public String mainPage(Model model, HttpSession session) {

        String memberType = (String)session.getAttribute("STYPECODE");
        String returnAddr = "user/account/login";

        //리워드 프로젝트 추천 리스트 조회
        List<RewardProject> recommendProjectList = rewardService.projectRecommendList();

        model.addAttribute("recommendProjectList",recommendProjectList);

        return "user/projectRegistration/main";
    }

    //리워드 프로젝트 등록 페이지
    @GetMapping(value = {"/reward"})
    public String rewardRegistrationPage(Model model) {

        List<TotalCategory> categoryList = totalCategoryService.categoryByPatition("reward");

        model.addAttribute("categoryList",categoryList);

        return "user/projectRegistration/reward/reward_insert";
    }

    //리워드 프로젝트 등록 진행.
    @PostMapping(value= "/reward")
    @ResponseBody
    public String rewardRegistrationPage(@RequestBody RewardProject parameters) throws JsonProcessingException {

        rewardService.addRewardProject(parameters);

        return "/user/projectRegistration/reward/success";
    }

    //리워드 프로젝트 등록 완료 페이지
    @GetMapping("/reward/success")
    public String rewardProjectSuccessPage(){

        return "user/projectRegistration/reward/reward_insert_success";
    }



    //투자 프로젝트 심사 요청, 공고등록 페이지
    @GetMapping(value = {"/investment/judge"})
    public String investmentJudgePage(Model model, HttpSession httpSession) {
        String memberId = (String) httpSession.getAttribute("SID");

        if(memberId == null) {
            return "user/account/login";
        }

        List<UserCompanyBusinessType> userCompanyBusinessType = userInvestmentService.getUserCompanyBusinessType();
        List<UserLawSatistifyReason> userLawSatistifyReason = userInvestmentService.getUserLawSatistifyReason();

        model.addAttribute("userCompanyBusinessType", userCompanyBusinessType);
        model.addAttribute("userLawSatistifyReason", userLawSatistifyReason);

        model.addAttribute("title", "투자펀딩 심사 요청 페이지");

        return "user/projectRegistration/investment/invest_judge_insert";
    }

    // 투자 프로젝트 등록
    @PostMapping(value = {"/investment/judge"})
    public String investmentRegistrationPage(InvestmentJudge investmentJudge, InvestmentInfo investmentInfo, InvestmentContent investmentContent, HttpSession session){

        String memberId = (String) session.getAttribute("SID");
        investmentJudge.setMemberIdSeller(memberId);


        System.out.println(investmentJudge);

        // 투자 심사 요청 등록
        userInvestmentService.addInvestmentJudge(investmentJudge);

        // 투자 프로젝트 등록
        investmentInfo.setInvestmentRequestJudgeCode(investmentJudge.getInvestmentRequestJudgeCode());
        investmentInfo.setInvestmentSubject(investmentJudge.getInvestmentRequestSubject());
        userInvestmentService.addInvestment(investmentInfo);

        // 투자 프로젝트 상세내용 등록
        investmentContent.setInvestmentCode(investmentInfo.getInvestmentCode());
        userInvestmentService.addInvestmentContent(investmentContent);

        return "redirect:/user/projectRegistration/investment/success";
    }
    //투자 프로젝트 등록 완료 페이지
    @GetMapping(value = "investment/success")
    public String investmentRegistrationSuccessPage(){
        return "user/projectRegistration/investment/investment_insert_success";
    }


    // 기부 프로젝트 완료 포스트맵핑으로 받기
    @PostMapping("/donation")
    public String donationRegistrationPage(DonationRegistration donationRegistration){
        donationService.addDonation(donationRegistration);
        return "redirect:/user/projectRegistration/donation/success";
    }
    // 기부 프로젝트 완료 페이지
    @GetMapping("/donation/success")
    public String donationRegistrationSuccessPage(){
        return "user/projectRegistration/donation/donation_insert_success";
    }
    // 기부 프로젝트 등록 폼
    @GetMapping("/donation")
    public String donationRegistrationPage(Model model) {
        List<TotalCategory> categoryList = totalCategoryService.categoryByPatition("donation");
        model.addAttribute("categoryList",categoryList);

        return "user/projectRegistration/donation/donation_insert";
    }
    @PostMapping(value = "/uploadSummernoteImageFile", produces = "application/json")
    @ResponseBody
    public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile,
                                                HttpServletRequest request) {
        JsonObject jsonObject = new JsonObject();

        String fileRoot = getOsFileRootPath();	//저장될 외부 파일 경로
        // 우분투 파일 루트 file:////home/springboot/resource
        String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
        String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
        File targetFile = new File(fileRoot + savedFileName);
        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
            jsonObject.addProperty("url", "/summernoteImage/"+savedFileName);
            jsonObject.addProperty("fileName", savedFileName);
            jsonObject.addProperty("responseCode", "success");

        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
            jsonObject.addProperty("responseCode", "error");
            e.printStackTrace();
        }

        return jsonObject;
    }

    @RequestMapping(value = "/deleteSummernoteImageFile", produces = "application/json; charset=utf8")
    @ResponseBody
    public void deleteSummernoteImageFile(@RequestParam("file") String fileName) {
        // 폴더 위치
        String filePath = getOsFileRootPath();

        // 해당 파일 삭제
        deleteFile(filePath, fileName);
    }

    // 파일 하나 삭제
    private void deleteFile(String filePath, String fileName) {
        Path path = Paths.get(filePath, fileName);
        try {
            Files.delete(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getOsFileRootPath(){
        String os = System.getProperty("os.name").toLowerCase();
        String rootPath = "/home/springboot/resources/summernote_image/";
        if (os.contains("win")) {
            rootPath = "C:\\summernote_image\\";
        } else if (os.contains("mac")) {
            rootPath = "/Users/Shared/summernote_image/";
        }

        return rootPath;
    }

}