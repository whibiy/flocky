package ksmart.ks48team02.admin.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminMainController")
@RequestMapping("/admin")
public class MainController {
	
	@GetMapping(value = {"", "/"})
	public String adminMainPage(Model model,
								HttpSession session) {

		// 세션 기본값 설정
		String getSid = (String) session.getAttribute("SID");
		String getStype = (String) session.getAttribute("STYPECODE");
		session.removeAttribute("SSTORECODE");

		if(getSid == null){
			session.setAttribute("SID", "id001");
			session.setAttribute("STYPECODE", "mem_type_01");
			session.setAttribute("SNAME", "채송아");
		}
		if(getStype != null && !getStype.equals("mem_type_01")){
			session.removeAttribute("SID");
			session.removeAttribute("STYPECODE");
			session.removeAttribute("SNAME");
			session.setAttribute("SID", "id001");
			session.setAttribute("STYPECODE", "mem_type_01");
			session.setAttribute("SNAME", "채송아");
		}


		return "admin/index";
	}
}
