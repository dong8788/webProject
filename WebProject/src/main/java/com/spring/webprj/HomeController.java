package com.spring.webprj;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.webprj.domain.CustomerVo;
import com.spring.webprj.service.CartService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private CartService cartservice;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {
		if(session.getAttribute("seller1") != null) {
			return "/seller/main";
		}else {
			if(session.getAttribute("login") != null) {
				System.out.println(((CustomerVo)session.getAttribute("login")).getCusSeq());
				int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
				model.addAttribute("cartSize", cartSize);
			}
			return "home";
		}
	}
	

	
}
