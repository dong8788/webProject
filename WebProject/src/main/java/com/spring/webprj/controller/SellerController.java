package com.spring.webprj.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.webprj.domain.PoProductVo;
import com.spring.webprj.domain.PoVo;
import com.spring.webprj.domain.ProductVo;
import com.spring.webprj.domain.SellerVo;
import com.spring.webprj.service.PoService;
import com.spring.webprj.service.ProductService;
import com.spring.webprj.service.SellerService;
import com.spring.webprj.util.UploadFileUtils;

@Controller
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	private ProductService prodservice;
	
	@Autowired
	private SellerService sellerservice;
	
	@Autowired
	private PoService poservice;
	
	@Resource(name="uploadPath")
	private String uploadPath;

	@GetMapping("/prodWrite")
	public void prodWrite() {
		System.out.println("get : prodwrite");
	}
	
	@PostMapping("/prodWrite")
	public String prodWrite(ProductVo prod, MultipartFile file) throws Exception {
		String imgUploadPath = uploadPath;
		String fileName = null;
		System.out.println("post : prodwrite");
		System.out.println(prod);
		
		if(file != null) {
		fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes()); 
	} else {
//		fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		fileName = uploadPath + File.separator + "none.png";
	}
	
		prod.setPhotoUrl(fileName);
	
		prodservice.insert(prod);
		
		return "/seller/main";
	}
	
	@GetMapping("/prodList")
	public void prodList(Model model, HttpSession session) {
		List<ProductVo> prodList = prodservice.list(sellerservice.select(((SellerVo)session.getAttribute("login")).getId()).getSellerSeq());
		System.out.println("get : prodList");
		System.out.println(prodList);
		model.addAttribute("prodList", prodList);
	}
	
	@GetMapping("/prodModify/{prodSeq}")
	public String prodModify(@PathVariable int prodSeq,Model model) {
		model.addAttribute("prod", prodservice.getProd(prodSeq));
		return "/seller/prodModify";
	}
	
	@GetMapping("/newOrder")
	public String newOrder(HttpSession session, Model model) {
		System.out.println(((SellerVo)session.getAttribute("login")).getSellerSeq());
		List<PoProductVo> newOrderList = poservice.newOrderlist(((SellerVo)session.getAttribute("login")).getSellerSeq());
		model.addAttribute("newOrderList", newOrderList);
		System.out.println(newOrderList);
		return "/seller/newOrder";
	}
	
	@PostMapping("/newOrder")
	public String newOrder(@RequestParam(value="poNum", required=true) List<Integer> poNumList,@RequestParam(value="poStat") String poStat, Model model, HttpSession session) {
		for(int poNum : poNumList) {
			PoVo po = poservice.getPo(poNum);
			po.setPoStat(poStat);
			poservice.
		}
		
		return "/seller/newOrder";
	}
	
	@GetMapping("/send")
	public String send(HttpSession session, Model model) {
		System.out.println(((SellerVo)session.getAttribute("login")).getSellerSeq());
		List<PoProductVo> newOrderList = poservice.newOrderlist(((SellerVo)session.getAttribute("login")).getSellerSeq());
		model.addAttribute("newOrderList", newOrderList);
		System.out.println(newOrderList);
		return "/seller/newOrder";
	}
}
