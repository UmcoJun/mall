package com.mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mall.domain.AdminVO;
import com.mall.service.AdminService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/admin/*")
@Controller
public class AdminController {

	@Setter(onMethod_ = {@Autowired})
	private AdminService adminService;
	
	@Setter(onMethod_ = {@Autowired})
	private PasswordEncoder passwordEncoder;
	
	// 관리자 로그인페이지
	@GetMapping("")
	public String adLogin() {
		
		return "/admin/adLogin";
	}
	
	@GetMapping("/admin_menu")
	public String  admin_menu() {
		
		return "/admin/admin_menu";
	}
	
	@PostMapping("/login_ok")
	public String login_ok(AdminVO vo, HttpSession session, RedirectAttributes rttr) {
		
		AdminVO dbvo = adminService.adLogin(vo.getAdmin_id());
		
		String url = "";
		String msg = "";
		
		if(dbvo != null) {
			
			if(passwordEncoder.matches(vo.getAdmin_pw(), dbvo.getAdmin_pw())) {
				
				// 어드민 세션작업은 일반로그인 세션작업과 이름을 다르게 해야한다.
				session.setAttribute("adminStatus", dbvo);

				// 현재 접속(로그인)시간 업데이트 작업
				adminService.login_update(vo.getAdmin_id());
				
				String dest = (String) session.getAttribute("dest");
				url = (dest == null) ? "/admin/admin_menu" : dest;
				msg = "관리자 로그인 성공";
				
				log.info("인증정보");
				
			}else {
				url = "/admin/";
				msg = "비밀번호 불일치";
			}

		}else {
			url = "/admin/";
			msg = "아이디 불일치";
		}
		
		rttr.addFlashAttribute("msg", msg);
		
		return "redirect:" + url;
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes rttr) {
		
		session.invalidate();
		
		return "redirect:/admin/";
	}
}
