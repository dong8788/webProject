package com.spring.webprj.persistence;

import java.util.List;

import com.spring.webprj.domain.SellerVo;

public interface SellerDao {

	//Seller 리스트를 가져오기 위한 기능
	public List<SellerVo> selectAll();
	
	//Seller 상세 조회 기능
	public SellerVo select(String id);
	
	//Seller 취소 기능
	public void delete(int sellerSeq);
	
	//Seller 생성기능
	public void insert(SellerVo seller);
}
