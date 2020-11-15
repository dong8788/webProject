package com.spring.webprj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.webprj.domain.CartProductVo;
import com.spring.webprj.domain.CustomerVo;
import com.spring.webprj.domain.PoProductVo;
import com.spring.webprj.domain.QueryProductVo;
import com.spring.webprj.service.CartService;
import com.spring.webprj.service.PoService;
import com.spring.webprj.service.QueryService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	
	@Autowired
	private PoService poservice;
	
	@Autowired
	private CartService cartservice;
	
	@Autowired
	private QueryService queryservice;
	
	
	@GetMapping("/main")
	public String main(HttpSession session, RedirectAttributes ra, Model model) {
		if(session.getAttribute("login")==null) {
			ra.addFlashAttribute("msg", "not-login");
			return "redirect:/";
		} else {
			System.out.println("mypage:main");
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			int polistSize = poservice.list(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			int prodquerySize = queryservice.querySelectBySeq(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			int prodreplySize = 0;
			for(QueryProductVo prodquery : queryservice.querySelectBySeq(((CustomerVo)session.getAttribute("login")).getCusSeq())) {
				if(prodquery.getReply() != null) prodreplySize ++;
			}
			model.addAttribute("cartSize", cartSize);
			model.addAttribute("polistSize", polistSize);
			model.addAttribute("prodquerySize", prodquerySize);
			model.addAttribute("prodreplySize", prodreplySize);
			 
			return "mypage/main";
		}

	}
	
	@GetMapping("/cart")
	public String cart(HttpSession session, RedirectAttributes ra, Model model) {
		if(session.getAttribute("login")==null) {
			ra.addFlashAttribute("msg", "not-login");
			return "redirect:/";
		} else {
			System.out.println("mypage:cart");
			List<CartProductVo> cartProductLsit = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq());
			System.out.println(((CustomerVo)session.getAttribute("login")).getCusSeq());
			System.out.println(cartProductLsit);
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
			model.addAttribute("cartProductList", cartProductLsit);
			return "mypage/cart";
		}
	}
	
	@GetMapping("/cartDelete/{cartSeq}")
	public String cartDelete(@PathVariable int cartSeq, RedirectAttributes ra, HttpSession session) {
		if(session.getAttribute("login")==null) {
			ra.addFlashAttribute("msg", "not-login");
			return "redirect:/";
		} else {
			System.out.println("mypage:cartdelete" + cartSeq);
			cartservice.delete(cartSeq);
			return "redirect:/mypage/cart";
		}
	}
	
	@GetMapping("/polist")
	public String polist(Model model, HttpSession session, RedirectAttributes ra) {
		if(session.getAttribute("login")==null) {
			ra.addFlashAttribute("msg", "not-login");
			return "redirect:/";
		} else {
			System.out.println("mypage:polist"+ ((CustomerVo)session.getAttribute("login")).getCusSeq());
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
			List<PoProductVo> poProductList = poservice.list(((CustomerVo)session.getAttribute("login")).getCusSeq());
			model.addAttribute("poProductList", poProductList);
			System.out.println(poProductList);
			return "mypage/polist";
		}
	}
	
	@GetMapping("/prodquery")
	public String prodquery(HttpSession session, RedirectAttributes ra, Model model) {
		if(session.getAttribute("login")==null) {
			ra.addFlashAttribute("msg", "not-login");
			return "redirect:/";
		} else {
			System.out.println("mypage:prodquery " + ((CustomerVo)session.getAttribute("login")).getCusSeq());
			List<QueryProductVo> queryProductList = queryservice.querySelectBySeq(((CustomerVo)session.getAttribute("login")).getCusSeq());
			System.out.println(queryProductList);
			model.addAttribute("queryProductList", queryProductList);
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
			return "mypage/prodquery";
		}
	}
}
