package ksmart.ks48team02.admin.controller;

import ksmart.ks48team02.admin.dto.AllProjectList;
import ksmart.ks48team02.admin.service.donation.AdminDonationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class ProjectController {
    AdminDonationService adminDonationService;
    @GetMapping("/projectManagement")
    public String projectManagement(Model model){
        model.addAttribute("title", "프로젝트 조회");
        model.addAttribute("contentsTitle", "프로젝트 조회");
        List<AllProjectList> allProjectListList = adminDonationService.getAllprojectList();
        model.addAttribute("allProjectListList", allProjectListList);

        return "admin/project/project_management";
    }

}
