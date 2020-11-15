package com.spring.webprj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.webprj.domain.CustomerVo;
import com.spring.webprj.domain.PoVo;
import com.spring.webprj.domain.QueryVo;
import com.spring.webprj.domain.ReviewVo;
import com.spring.webprj.service.CartService;
import com.spring.webprj.service.PoService;
import com.spring.webprj.service.QueryService;
import com.spring.webprj.service.ReviewService;


@Controller
@RequestMapping("/product")
public class PoController {
	
	@Autowired
	private PoService service;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private QueryService queryService;
	
	@Autowired
	private CartService cartservice;

	@GetMapping("/content")
	public String product(HttpSession session, Model model) {
		System.out.println("get : product");
		List<QueryVo> queryList = queryService.querySelectAll();
		List<ReviewVo> reviewList = reviewService.reviewSelectAll();
		System.out.println(queryList);
		System.out.println(reviewList);
		model.addAttribute("queryList", queryList);
		model.addAttribute("reviewList", reviewList);
		if(session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		return "product/content";
	}
	
	@GetMapping("/po")
	public String order(HttpSession session, RedirectAttributes ra, Model model) {
		System.out.println("get : po");
		if(session.getAttribute("login")==null) {
			ra.addFlashAttribute("msg", "not-login");
			return "redirect:/";
		} else {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
			return "product/po";
		}
		
	}
	
	@PostMapping("/po")
	public String order(PoVo po, HttpSession session, Model model) {
		System.out.println("post: po");
		System.out.println(po.getCusSeq());
		service.insert(po);
		if(session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		return "product/po";
	}
	
	@PostMapping("/query")
	public String query(QueryVo query) {
		System.out.println("post: query");
		System.out.println(query);
		queryService.queryInsert(query);
		return "redirect:/product/content";
	}
	
	@GetMapping("/search")
	public String search(HttpSession session, Model model) {
		System.out.println("get : search");
		if(session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		return "product/search";
	}

}
