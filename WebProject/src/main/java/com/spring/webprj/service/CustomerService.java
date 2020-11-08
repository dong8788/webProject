package com.spring.webprj.service;

import java.util.List;

import com.spring.webprj.domain.CustomerVo;


public interface CustomerService {

	//PO 리스트를 가져오기 위한 기능
	public List<CustomerVo> selectAll();
	
	//PO 상세 조회 기능
	public CustomerVo select(String cusId);
	
	//PO 취소 기능
	public void delete(int cusSeq);
	
	//PO 생성기능
	public void insert(CustomerVo cus);
}
