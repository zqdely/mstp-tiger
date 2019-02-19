package com.threepicture.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threepicture.dao.model.User;
import com.threepicture.feignClient.UploadFeignClient;
import com.threepicture.server.impl.ProductService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/query-product")
public class ProductController {
	
	private Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	//注入服务
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UploadFeignClient productFeignClient;
	
	/**
	 * 查询所有会员信息
	 * @return
	 */
	@RequestMapping("/queryAllInfo")
	public List<User> queryAllUser(){
		logger.info("进入controller...");
		return this.productService.queryAllUser();
	}
	
	/**
	 * 调用图片上传模块查询所有图片信息
	 * @return
	 */
	@RequestMapping("/queryPictureAllInfo")
	public Object getProductAllInfo(){
		return this.productFeignClient.getPictureAllInfo();
	}
	
	
	@RequestMapping("/test")
	@HystrixCommand(fallbackMethod = "fallBackInfo")
	public String getException() throws Exception{
		throw new Exception("测试hystrix断路功能...");
	}
	
	public String fallBackInfo(){
		return "服务暂时不可用，请稍后再试";
	}

}
