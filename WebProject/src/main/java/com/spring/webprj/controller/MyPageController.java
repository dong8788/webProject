package com.spring.webprj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	
	@GetMapping("/main")
	public String main(HttpSession session, RedirectAttributes ra) {
		if(session.getAttribute("login")==null) {
			ra.addFlashAttribute("msg", "not-login");
			return "redirect:/";
		} else {
			System.out.println("mypage:main");
			return "mypage/main";
		}

	}
	
	@GetMapping("/cart")
	public String cart(HttpSession session, RedirectAttributes ra) {
		if(session.getAttribute("login")==null) {
			ra.addFlashAttribute("msg", "not-login");
			return "redirect:/";
		} else {
			System.out.println("mypage:cart");
			return "mypage/cart";
		}
	}
	
	@GetMapping("/polist")
	public String polist(HttpSession session, RedirectAttributes ra) {
		if(session.getAttribute("login")==null) {
			ra.addFlashAttribute("msg", "not-login");
			return "redirect:/";
		} else {
			System.out.println("mypage:polist");
			return "mypage/polist";
		}
	}
	
	@GetMapping("/prodquery")
	public String prodquery(HttpSession session, RedirectAttributes ra) {
		if(session.getAttribute("login")==null) {
			ra.addFlashAttribute("msg", "not-login");
			return "redirect:/";
		} else {
			System.out.println("mypage:prodquery");
			return "mypage/prodquery";
		}
	}
}
