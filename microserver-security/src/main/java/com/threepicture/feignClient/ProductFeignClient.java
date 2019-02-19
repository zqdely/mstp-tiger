package com.threepicture.feignClient;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 请求产品工程客户端
 * @author 杏仁拌饭
 *
 */
@FeignClient(name="tp-product")
public interface ProductFeignClient {
	
	/**
	 * 使用post方式调用带参构造方法
	 * @param requestMap
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/query-product/ProductInfoById", method=RequestMethod.POST)
	public Object getProductInfoById(@RequestBody Map<String, Object> requestMap, @RequestParam("id") String id);
	
	/**
	 * 使用get方式调用方法
	 * @return
	 */
	@RequestMapping(value="/query-product/queryAllInfo", method=RequestMethod.GET)
	public Object getproductAllInfo();
}
