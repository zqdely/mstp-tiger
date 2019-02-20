package com.threepicture.server.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threepicture.dao.mapper.QueryCustInfoDao;
import com.threepicture.server.CustCommandServer;
import com.threepicture.util.CustConstants;

@Service
public class CustCommandServerImpl implements CustCommandServer {

	@Autowired
	public QueryCustInfoDao queryCustInfoDao;
	
	@Override
	public Map<String, Object> custLoginCommand(Map<String, Object> paramMap) {
		if(StringUtils.isEmpty(String.valueOf(paramMap.get(CustConstants.CUST_NICK_NAME))) ||
				StringUtils.isEmpty(String.valueOf(paramMap.get(CustConstants.CUST_PASSWORD)))){
			paramMap.remove(CustConstants.CUST_PASSWORD);
			paramMap.put(CustConstants.RESPONSE_RESULT, getFailMap());
			return paramMap;
		}
		Map<String, Object> custInfo = queryCustInfoDao.queryCustInfoByNickName(paramMap);
		if(StringUtils.isNotEmpty(String.valueOf(custInfo.get(CustConstants.CUST_PASSWORD))) 
				&& custInfo.get(CustConstants.CUST_PASSWORD).equals(paramMap.get(CustConstants.CUST_PASSWORD))){
			paramMap.put(CustConstants.TOKEN, writeRedisAndGetToken(paramMap));
			paramMap.remove(CustConstants.CUST_PASSWORD);
			paramMap.put(CustConstants.RESPONSE_RESULT, getSuccessMap());
			return paramMap;
		}else{
			paramMap.remove(CustConstants.CUST_PASSWORD);
			paramMap.put(CustConstants.RESPONSE_RESULT, getFailMap());
			return paramMap;
		}
	}

	private String writeRedisAndGetToken(Map<String, Object> paramMap){
		//存储redis
		//生成Token
		return "Token String";
	}
	
	/**
	 * 登陆失败响应结果
	 * @return
	 */
	private Map<String, String> getFailMap(){
		Map<String, String> failMap = new HashMap<>();
		failMap.put(CustConstants.RESPONSE_TYPE, "E");
		failMap.put(CustConstants.RESPONSE_MESSAGE, "登陆异常");
		return failMap;
	}
	
	/**
	 * 登陆成功响应结果
	 * @return
	 */
	private Map<String, String> getSuccessMap(){
		Map<String, String> failMap = new HashMap<>();
		failMap.put(CustConstants.RESPONSE_TYPE, "N");
		failMap.put(CustConstants.RESPONSE_MESSAGE, "登陆成功");
		return failMap;
	}
}
