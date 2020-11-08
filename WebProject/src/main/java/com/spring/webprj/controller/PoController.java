package com.spring.webprj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.webprj.domain.PoVo;
import com.spring.webprj.domain.QueryVo;
import com.spring.webprj.domain.ReviewVo;
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

	@GetMapping("/content")
	public String product(Model model) {
		System.out.println("get : product");
		List<QueryVo> queryList = queryService.querySelectAll();
		List<ReviewVo> reviewList = reviewService.reviewSelectAll();
		System.out.println(queryList);
		System.out.println(reviewList);
		model.addAttribute("queryList", queryList);
		model.addAttribute("reviewList", reviewList);		
		return "product/content";
	}
	
	@GetMapping("/po")
	public String order() {
		System.out.println("get : po");
		return "product/po";
	}
	
	@PostMapping("/po")
	public String order(PoVo po) {
		System.out.println("post: po");
		System.out.println(po.getCusId());
		service.insert(po);
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
	public String search() {
		System.out.println("get : search");
		return "product/search";
	}

}
