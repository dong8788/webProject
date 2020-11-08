package com.spring.webprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.webprj.domain.PoVo;
import com.spring.webprj.persistence.PoDao;

@Service
public class PoServiceImpl implements PoService {
	
	@Autowired
	private PoDao poDao;
	
	@Override
	public List<PoVo> list() {
		
		return poDao.list();
	}

	@Override
	public PoVo getPo(int poNum) {
		return poDao.getPo(poNum);
	}

	@Override
	public void delete(int poNum) {
		poDao.delete(poNum);

	}

	@Override
	public void insert(PoVo po) {
		System.out.println("service : insert");
		poDao.insert(po);
	}

}
