package com.spring.webprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cs")
public class CsController {
	
	@GetMapping("/cenquery")
	public String cenquery() {
		return "cs/cenquery";
	}
	
	@GetMapping("/faq")
	public String faq() {
		return "cs/faq";
	}
	
	@GetMapping("/notice")
	public String notice() {
		return "cs/notice";
	}
	
	@GetMapping("/main")
	public String main(){
		return "cs/support";
	}

}
