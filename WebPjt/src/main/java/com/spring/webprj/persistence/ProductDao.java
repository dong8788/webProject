package com.spring.webprj.persistence;

import java.util.List;

import com.spring.webprj.domain.ProductVo;

public interface ProductDao {

	//Product 리스트를 가져오기 위한 기능
	public List<ProductVo> list(int sellerSeq);
	
	//Product 상세 조회 기능
	public ProductVo getProd(int prodSeq);
	
	//Product 취소 기능
	public void delete(int prodSeq);
	
	//Product 생성기능
	public void insert(ProductVo prod);
}
