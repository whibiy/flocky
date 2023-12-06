package ksmart.ks48team02.seller.controller.settlement;

import jakarta.servlet.http.HttpSession;
import ksmart.ks48team02.admin.controller.orderManagement.OrderManagementController;
import ksmart.ks48team02.common.dto.*;
import ksmart.ks48team02.seller.service.settlement.SelSettlementService;
import ksmart.ks48team02.user.dto.RewardOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller("sellerSettlementController")
@RequestMapping("/seller/settlement")
public class settlementController {

    // 로그 추가
    private static final Logger log = LoggerFactory.getLogger(OrderManagementController.class);

    // DI
    private final SelSettlementService selSettlementService;

    // 의존성 주입
    public settlementController(SelSettlementService selSettlementService){
        this.selSettlementService = selSettlementService;
    }

    @GetMapping(value = {"","/"})
    public String sellerSettlementPage(Model model,
                                       HttpSession session){

        model.addAttribute("title","판매자 : 정산 대시보드");
        model.addAttribute("contentsTitle","정산 대시보드");
        model.addAttribute("contentsSubTitle","정산 신청 전체 항목");

        String sstorecode = (String) session.getAttribute("SSTORECODE");




        return "seller/settlement/main";
    }
    @GetMapping("/addSettlement")
    public String sellerInfoRemove(Model model,
                                   HttpSession session){
        model.addAttribute("title","판매자 : 정산 신청");
        model.addAttribute("contentsTitle","정산 신청");
        model.addAttribute("contentsSubTitle","펀딩 성공한 프로젝트만 정산 신청할 수 있습니다");

        String sstorecode = (String) session.getAttribute("SSTORECODE");

        // 공고 조회
        List<SettlementPrjList> getSettPrjListByCode = selSettlementService.getSettPrjListByCode(sstorecode);

        log.info("getSettPrjListByCode {}", getSettPrjListByCode);
        model.addAttribute("getSettPrjList", getSettPrjListByCode);

        return "seller/settlement/addSettlement";
    }

    // 정산 신청 정보 수정
    @GetMapping("/applicationRemove")
    public String sellerSettlementApplecationRemove(Model model){
        model.addAttribute("title","판매자 : 정산 신청 정보 수정");
        model.addAttribute("contentsTitle","정산 신청 정보 수정");
        model.addAttribute("contentsSubTitle","처리중 상태의 정산 신청은 정산 정보를 수정할 수 없습니다");



        return "seller/settlement/remove_settlement_object";
    }
    // 정산 신청 정보 입력
    @GetMapping("/addSettlement/info")
    public String sellerSettlementAdd(Model model,
                                      @RequestParam(name="projectCode") String projectCode,
                                      @RequestParam(name="projectPartition") String projectPartition){
        model.addAttribute("title","판매자 : 정산 신청 정보 입력");
        model.addAttribute("contentsTitle","정산 신청 정보 입력");
        model.addAttribute("contentsSubTitle","입력한 정산 정보 수정은 신청 정보 수정 페이지에서 수정 가능합니다");
        model.addAttribute("projectPartition", projectPartition);



        Map<String, Object> resultMap = selSettlementService.getInfoByProjectCode(projectPartition, projectCode);

        log.info("projectInfo.list {}", resultMap.get("list"));

        model.addAttribute("list", resultMap.get("list"));
        return "seller/settlement/addSettlementDetail";
    }
}
