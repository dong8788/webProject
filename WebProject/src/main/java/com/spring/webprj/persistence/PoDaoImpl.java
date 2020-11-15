package com.spring.webprj.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.webprj.domain.PoProductVo;
import com.spring.webprj.domain.PoVo;

@Repository
public class PoDaoImpl implements PoDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<PoProductVo> list(int cusSeq) {
		return sqlSessionTemplate.selectList("PoDao.list", cusSeq);
	}
	
	@Override
	public List<PoProductVo> listAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<PoProductVo> newOrderlist(int sellerSeq) {
		return sqlSessionTemplate.selectList("PoDao.newOrderlist", sellerSeq);
	}

	@Override
	public PoVo getPo(int poNum) {
		return sqlSessionTemplate.selectOne("PoDao.getPo");
	}

	@Override
	public void delete(int poNum) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(PoVo po) {
		System.out.println("poDao");
		System.out.println(po);
		sqlSessionTemplate.insert("PoDao.insert",po);

	}

}
