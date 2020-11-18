package com.spring.webprj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.webprj.domain.CustomerVo;
import com.spring.webprj.domain.SellerVo;
import com.spring.webprj.service.CartService;
import com.spring.webprj.service.CustomerService;
import com.spring.webprj.service.SellerService;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@ResponseBody
	@RequestMapping(value="/sellerIdChk", method = RequestMethod.POST)
	public int sellerIdChk(SellerVo vo) throws Exception{
		System.out.println(vo);
		int result = sellservice.sellerIdChk(vo);
		return result;
	}
	
	
	@Autowired
	private CustomerService cusservice;
	
	@Autowired
	private SellerService sellservice;
	
	@Autowired
	private CartService cartservice;
	
	@GetMapping("/login")
	public void login() {
		System.out.println("user:login");
	}
	
	@PostMapping("/login")
	public String login(CustomerVo cus, HttpSession session, RedirectAttributes ra) {
		System.out.println("user:login");
		System.out.println(cus);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(cusservice.checkCusId(cus.getCusId()));
		if(cusservice.checkCusId(cus.getCusId())==1) {
			if(encoder.matches(cus.getPassword(), cusservice.select(cus.getCusId()).getPassword())) {
				session.setAttribute("login", cusservice.select(cus.getCusId()));
				return "redirect:/";
			} else {
				ra.addFlashAttribute("msg","not-login");
				return "redirect:/user/login";
			}
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
		if(sellservice.checkSellerId(seller.getId())==1) {
			if(encoder.matches(seller.getPassword(), sellservice.select(seller.getId()).getPassword())) {
				session.setAttribute("login", sellservice.select(seller.getId()));
				session.setAttribute("seller1", "판매자용로그인");
				return "/seller/main";
			}else {
				ra.addFlashAttribute("msg","not-login");
				return "redirect:/user/login";
			}
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
	
	@PostMapping("/cusRegister")
	public String cusregister(CustomerVo cus) {
		System.out.println("user:register 회원가입");
		cusservice.insert(cus);
		return "/user/login";
	}
	
	@GetMapping("/sellerRegister")
	public void sellerRegister() {
		System.out.println("user:sellerRegister");
	}
	
	@PostMapping("/sellerRegister")
	public String register(SellerVo seller) {
		System.out.println("user:register 회원가입");
		System.out.println(seller);
		sellservice.insert(seller);
		return "/user/login";
	}
	
	@GetMapping("/cusModify")
	public String cusModify(HttpSession session, RedirectAttributes ra, Model model) {
		System.out.println("user:cusModify");
		if(session.getAttribute("login") == null) {
			ra.addFlashAttribute("msg", "not-login");
			return "redirect:/";
		} else {
			if(session.getAttribute("seller1") == null) {
				int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
				model.addAttribute("cartSize", cartSize);
			}
			return "/user/cusModify";
		}
	}
	
	@PostMapping("/cusModify")
	public String cusModify(CustomerVo cus) {
		System.out.println("user:cusModify Post");
		cusservice.update(cus);
			return "/home";
	}
	
	@GetMapping("/cusDelete")
	public String cusDelete(HttpSession session, RedirectAttributes ra) {
		System.out.println("user:cusDelete");
		if(session.getAttribute("login") == null) {
			ra.addFlashAttribute("msg", "not-login");
			return "redirect:/";
		} else {
			return "/user/cusDelete";
		}
	}
	
	@PostMapping("/cusDelete")
	public String cusDelete(HttpSession session, String password, RedirectAttributes ra ) {
		System.out.println("user:cusModify Post");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(password, ((CustomerVo)session.getAttribute("login")).getPassword())) {
			cusservice.delete(((CustomerVo)session.getAttribute("login")).getCusSeq());
			session.removeAttribute("login");
			session.invalidate();
			return "/home";
		} else {
			ra.addAttribute("msg","passwordError");
			return "redirect:/user/cusDelete";
		}
		
		
		
	}
	
	
}
