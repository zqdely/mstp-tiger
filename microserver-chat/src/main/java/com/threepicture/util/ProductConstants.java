package com.threepicture.util;

public class ProductConstants {
	
	/********** feign常量 ***********/
	//响应类型
	public static final String RESPONSE_TYPE = "Response_Type";
	//请求成功
	public static final String RESPONSE_TYPE_N = "N";
	//请求失败
	public static final String RESPONSE_TYPE_E = "E";
	//响应信息
	public static final String RESPONSE_MSSAGE_KEY = "Response_Info";
	//响应信息-调起熔断处理
	public static final String RESPONSE_ERROR_MESSAGE_INFO_OF_HYSTRIX = "响应错误，进入Hystrix-容错处理...";
	//请求标识
	public static final String OPT_ID = "optId";
	

}
