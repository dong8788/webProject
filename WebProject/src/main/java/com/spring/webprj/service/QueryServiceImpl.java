package com.spring.webprj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.webprj.domain.QueryVo;
import com.spring.webprj.persistence.QueryDao;

@Service
public class QueryServiceImpl implements QueryService {

	@Autowired
	private QueryDao queryDao;

	@Override
	public List<QueryVo> querySelectAll() {
		return queryDao.querySelectAll();
	}

	@Override
	public List<QueryVo> querySelectById(String cusId) {
		return queryDao.querySelectById(cusId);
	}

	@Override
	public QueryVo querySelectOne(int querySeq) {
		return queryDao.querySelectOne(querySeq);
	}

	@Override
	public void queryInsert(QueryVo queryVo) {
		System.out.println("query:insert");
		queryDao.queryInsert(queryVo);
	}

	@Override
	public void queryUpdate(QueryVo queryVo) {
		queryDao.queryUpdate(queryVo);
	}

	@Override
	public void queryDelete(int querySeq) {
		queryDao.queryDelete(querySeq);
	}
	

}