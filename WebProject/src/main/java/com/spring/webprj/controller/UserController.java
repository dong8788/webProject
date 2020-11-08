package com.spring.webprj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.webprj.domain.CustomerVo;
import com.spring.webprj.domain.SellerVo;
import com.spring.webprj.service.CustomerService;
import com.spring.webprj.service.SellerService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private CustomerService cusservice;
	
	@Autowired
	private SellerService sellservice;
	
	@GetMapping("/login")
	public void login() {
		System.out.println("user:login");
	}
	
	@PostMapping("/login")
	public String login(CustomerVo cus, HttpSession session, RedirectAttributes ra) {
		System.out.println("user:login");
		System.out.println(cus);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(cusservice.select(cus.getCusId()).getPassword());
		if(encoder.matches(cus.getPassword(), cusservice.select(cus.getCusId()).getPassword())) {
			session.setAttribute("login", cusservice.select(cus.getCusId()));
			return "/home";
		}else {
			ra.addFlashAttribute("msg","not-login");
			return "redirect:/user/login";
		}
		
	}
	
	@PostMapping("/sellerLogin")
	public String login(SellerVo seller, HttpSession session, RedirectAttributes ra) {
		System.out.println("seller:login");
		System.out.println(seller);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(sellservice.select(seller.getId()).getPassword());
		if(encoder.matches(seller.getPassword(), sellservice.select(seller.getId()).getPassword())) {
			session.setAttribute("login", sellservice.select(seller.getId()));
			session.setAttribute("seller1", "판매자용로그인");
			return "/seller/main";
		}else {
			ra.addFlashAttribute("msg","not-login");
			return "redirect:/user/login";
		}
		
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("login");
		session.removeAttribute("seller");
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/register")
	public void register() {
		System.out.println("user:register");
	}
	
	@GetMapping("/cusRegister")
	public void cusRegister() {
		System.out.println("user:cusRegister");
	}
	
	@GetMapping("/sellerRegister")
	public void sellerRegister() {
		System.out.println("user:sellerRegister");
	}
	
	@PostMapping("/cusRegister")
	public String cusregister(CustomerVo cus) {
		System.out.println("user:register 회원가입");
		cusservice.insert(cus);
		return "/user/login";
	}
	
	@PostMapping("/sellerRegister")
	public String register(SellerVo seller) {
		System.out.println("user:register 회원가입");
		System.out.println(seller);
		sellservice.insert(seller);
		return "/user/login";
	}
	
	
}
