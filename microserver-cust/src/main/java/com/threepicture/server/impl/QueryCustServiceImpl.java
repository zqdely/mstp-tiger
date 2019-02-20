package com.threepicture.server.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threepicture.dao.mapper.QueryCustInfoDao;
import com.threepicture.server.QueryCustService;

@Service
public class QueryCustServiceImpl implements QueryCustService {

	@Autowired
	public QueryCustInfoDao querycustDao;
	
	@Override
	public Map<String, Object> queryCustInfoByNickName(Map<String, Object> paramMap) {
		return querycustDao.queryCustInfoByNickName(paramMap);
	}

	@Override
	public Map<String, Object> queryCustAllInfoById(Map<String, Object> paramMap) {
		return querycustDao.queryCustAllInfoById(paramMap);
	}

}
