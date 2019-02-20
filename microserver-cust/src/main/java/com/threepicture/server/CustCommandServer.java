package com.threepicture.server;

import java.util.Map;
/**
 * 会员口令服务
 * @author 杏仁拌饭
 *
 */
public interface CustCommandServer {
	
	/**
	 * 登陆口令(检查并判断会员信息)
	 * @param paramMap
	 * @return 返回登陆成功/失败
	 */
	Map<String, Object> custLoginCommand(Map<String, Object> paramMap);

}
