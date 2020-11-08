package com.spring.webprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
public class SellerController {

	@GetMapping("/prodWrite")
	public void prodWrite() {
		System.out.println("get : prodwrite");
	}
	
	@GetMapping("/prodList")
	public void prodList() {
		System.out.println("get : prodList");
	}
}
