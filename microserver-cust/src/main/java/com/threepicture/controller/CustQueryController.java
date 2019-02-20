package com.threepicture.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threepicture.server.QueryCustService;
import com.threepicture.util.CustConstants;

/**
 * 会员信息查询控制器
 * @author 杏仁拌饭
 *
 */
@RestController
@RequestMapping("/query-cust")
public class CustQueryController {
	
	private static Logger logger = LoggerFactory.getLogger(CustQueryController.class);

	@Autowired
	private QueryCustService custService;
	
	/**
	 * 根据昵称查询会员简要信息
	 * @param nickName
	 * @return
	 */
	@RequestMapping("/queryCustInfoByNickName")
	public Map<String, Object> queryCustInfoByNickName(String nickName){
		logger.info("查询会员信息，根据昵称：" + nickName);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(CustConstants.CUST_NICK_NAME, nickName);
		return custService.queryCustInfoByNickName(paramMap);
	}
	
	/**
	 * 根据会员Id查询所有信息
	 * @param CustId
	 * @return
	 */
	@RequestMapping("/queryCustAllInfoById")
	public Map<String, Object> queryCustAllInfoById(String custId){
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(CustConstants.CUST_ID, custId);
		return custService.queryCustAllInfoById(paramMap);
	}
	
}
