package ksmart.ks48team02.admin.controller.settlement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminSettlementController")
@RequestMapping("/admin/settlement")
public class settlementController {
    // 정산 신청 현황 페이지
    @GetMapping(value = {"","/"})
    public String adminSettlementPage(Model model){
        model.addAttribute("title","관리자 : 정산 관리");
        model.addAttribute("contentsTitle","정산 신청 현황");
        model.addAttribute("contentsSubTitle","스토어 전체 정산 신청 현황이 노출됩니다");
        return "admin/settlement/main";
    }
    // 오늘 들어온 정산 신청 관리 페이지
    @GetMapping("/todayList")
    public String adminSettlementTodayList(Model model){
        model.addAttribute("title","관리자 : 오늘 들어온 정산 신청 관리");
        model.addAttribute("contentsTitle","Today 정산 신청 관리");
        model.addAttribute("contentsSubTitle","아직 담당자가 배정 되지 않은 정산 신청 목록이 노출 됩니다");
        return "admin/settlement/today_settlement_list";
    }
    // 처리중 정산 신청 목록 페이지
    @GetMapping("/inProgressList")
    public String adminSettlementProgressList(Model model){
        model.addAttribute("title","관리자 : 처리중 정산 신청 관리");
        model.addAttribute("contentsTitle","처리 중 정산 신청 목록");
        model.addAttribute("contentsSubTitle","자신 에게 배정된 정산 신청 항목만 노출 됩니다");
        return "admin/settlement/inprogress_settlement_list";
    }
    // 처리 완료 정산 신청 목록 페이지
    @GetMapping("/completedList")
    public String adminSettlementCompletedList(Model model){
        model.addAttribute("title","관리자 : 처리 완료 정산 신청 관리");
        model.addAttribute("contentsTitle","처리 완료 정산 신청 목록");
        model.addAttribute("contentsSubTitle","자신 에게 배정된 정산 신청 항목만 노출 됩니다");
        return "admin/settlement/completed_settlement_list";
    }
    // 처리 보류중 정산 신청 목록 페이지
    @GetMapping("/reservationList")
    public String adminSettlementReservationList(Model model){
        model.addAttribute("title","관리자 : 처리 보류 정산 신청 관리");
        model.addAttribute("contentsTitle","처리 보류 정산 신청 목록");
        model.addAttribute("contentsSubTitle","자신 에게 배정된 정산 신청 항목만 노출 됩니다");

        return "admin/settlement/reservation_settlement_list";
    }
    // 정산 신청 건 수정 페이지
    @GetMapping("/remove")
    public String adminSettlementRemoveObj(Model model){
        model.addAttribute("title","관리자 : 정산 신청 항목 수정 관리");
        model.addAttribute("contentsTitle","정산 신청 항목 수정");
        model.addAttribute("contentsSubTitle","선택한 상품 상태 변경 후에는 처리 전 상태로 변경할 수 없습니다");

        return "admin/settlement/remove_settlement_object";
    }
}
