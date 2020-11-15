package com.spring.webprj.persistence;

import java.util.List;

import com.spring.webprj.domain.CartProductVo;
import com.spring.webprj.domain.CartVo;

public interface CartDao {

	//Cart 리스트를 가져오기 위한 기능
	public List<CartProductVo> select(int cusSeq);

	//Cart 상세 조회 기능
	public CartProductVo getCart(int CartSeq);
	
	//Cart 취소 기능
	public void delete(int cartSeq);
	
	//Cart 생성기능
	public void insert(CartVo cart);
}
