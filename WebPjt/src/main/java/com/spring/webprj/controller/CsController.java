package com.spring.webprj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.webprj.common.Criteria;
import com.spring.webprj.common.PageMaker;
import com.spring.webprj.common.SearchVO;
import com.spring.webprj.domain.CenQueryVo;
import com.spring.webprj.domain.CustomerVo;
import com.spring.webprj.service.CartService;
import com.spring.webprj.service.CenQueryService;
import com.spring.webprj.service.FaqService;
import com.spring.webprj.service.NoticeService;

@Controller
@RequestMapping("/cs")
public class CsController {
	
	@Autowired
	private NoticeService noticeservice;
	
	@Autowired
	private CenQueryService cenQueryservice;
	
	@Autowired
	private FaqService faqservice;
	
	@Autowired
	private CartService cartservice;
	
	@GetMapping("/cenquery")
	public String cenquery(SearchVO search, HttpSession session, Model model) {
		
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
				int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
				model.addAttribute("cartSize", cartSize);
		}
		
		PageMaker pm = new PageMaker();
		pm.setCri(search);
		System.out.println(search.getRowStart());
		System.out.println("parameter(페이지번호) : "+search.getPage());
		System.out.println("검색 조건 : "+ search.getCondition());
		System.out.println("검색어 : "+ search.getKeyword());
		System.out.println("rowStart : "+ search.getRowStart());
		System.out.println("rowEnd : "+ search.getRowEnd());
		
		List<CenQueryVo> cenQueryList = cenQueryservice.list(search);
		pm.setTotalCount(cenQueryservice.listCount(search));
		System.out.println(cenQueryservice.list(search).size());
		model.addAttribute("userCenQueryList", cenQueryList);
		System.out.println(cenQueryList);
		model.addAttribute("pageMaker", pm);
		
		return "cs/cenquery";
	}

	
	@GetMapping("/faq")
	public String faq(Model model, HttpSession session, SearchVO search) {
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		PageMaker pm = new PageMaker();
		pm.setCri(search);
		System.out.println(search.getRowStart());
		System.out.println("parameter(페이지번호) : "+search.getPage());
		System.out.println("검색 조건 : "+ search.getCondition());
		System.out.println("검색어 : "+ search.getKeyword());
		System.out.println("rowStart : "+ search.getRowStart());
		System.out.println("rowEnd : "+ search.getRowEnd());
		pm.setTotalCount(faqservice.listCount(search));
		model.addAttribute("faqList", faqservice.selectAll(search));
		model.addAttribute("pageMaker", pm);
		return "cs/faq";
	}
	
	@GetMapping("/notice")
	public String notice(Model model, HttpSession session, SearchVO search) {
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		PageMaker pm = new PageMaker();
		pm.setCri(search);
		System.out.println(search.getRowStart());
		System.out.println("parameter(페이지번호) : "+search.getPage());
		System.out.println("검색 조건 : "+ search.getCondition());
		System.out.println("검색어 : "+ search.getKeyword());
		System.out.println("rowStart : "+ search.getRowStart());
		System.out.println("rowEnd : "+ search.getRowEnd());
		pm.setTotalCount(noticeservice.listCount(search));
		model.addAttribute("noticeList", noticeservice.selectAll(search));
		model.addAttribute("pageMaker", pm);
		return "cs/notice";
	}
	
	@GetMapping("/main")
	public String main(HttpSession session, Model model){
		if(session.getAttribute("seller1") == null && session.getAttribute("login") != null) {
			int cartSize = cartservice.select(((CustomerVo)session.getAttribute("login")).getCusSeq()).size();
			model.addAttribute("cartSize", cartSize);
		}
		return "cs/support";
	}

}
