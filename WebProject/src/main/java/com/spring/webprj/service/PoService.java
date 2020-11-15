package com.spring.webprj.service;

import java.util.List;

import com.spring.webprj.domain.PoProductVo;
import com.spring.webprj.domain.PoVo;


public interface PoService {

	//PO 리스트를 가져오기 위한 기능
	public List<PoProductVo> list(int cusSeq);

	//PO 전체 리스트를 가져오기 위한 기능
	public List<PoProductVo> listAll();

	//PO 신규 오더 리스트를 가져오기 위한 기능
	public List<PoProductVo> newOrderlist(int sellerSeq);
	
	//PO 상세 조회 기능
	public PoVo getPo(int poNum);
	
	//PO 취소 기능
	public void delete(int poNum);
	
	//PO 생성기능
	public void insert(PoVo po);
	
}
