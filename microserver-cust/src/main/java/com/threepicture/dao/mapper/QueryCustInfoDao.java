package com.threepicture.dao.mapper;

import java.util.Map;

/**
 * 查询会员信息
 * @author 杏仁拌饭
 *
 */
public interface QueryCustInfoDao {
	
	/**
	 * 根据会员昵称查询简要信息
	 * @param paramMap
	 * @return
	 */
	Map<String, Object> queryCustInfoByNickName(Map<String, Object> paramMap);
	
	/**
	 * 根据会员ID查询会员全部信息
	 * @param paramMap
	 * @return
	 */
	Map<String, Object> queryCustAllInfoById(Map<String, Object> paramMap);

}
