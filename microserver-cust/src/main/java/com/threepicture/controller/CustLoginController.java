package com.threepicture.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.StringUtil;
import com.threepicture.server.CustCommandServer;
import com.threepicture.util.CustConstants;

/**
 * 登陆控制类
 * @author 杏仁拌饭
 *
 */
@RestController
@RequestMapping("/cust-login")
public class CustLoginController {

	private static Logger logger = LoggerFactory.getLogger(CustLoginController.class);
	
	@Autowired
	public CustCommandServer custCommandServer;
	
	/**
	 * 用户登陆(成功返回Token/失败返回null)
	 * @param nickName
	 * @param password
	 * @return
	 */
	@RequestMapping("/custLoginstatus")
	public Map<String, Object> custLoginstatus(String nickName, String password){
		logger.info("登陆者昵称：" + nickName);
		Map<String, Object> custInfo = new HashMap<>();
		custInfo.put(CustConstants.CUST_NICK_NAME, nickName);
		custInfo.put(CustConstants.CUST_PASSWORD, password);
		return custCommandServer.custLoginCommand(custInfo);
	}
	
}
