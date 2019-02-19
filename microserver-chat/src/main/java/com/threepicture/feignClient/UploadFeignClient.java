package com.threepicture.feignClient;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 请求文件上传模块-查询文件信息工程客户端
 * @author 杏仁拌饭
 *
 */
//fallbackFactory-为feign定义检查回退
@FeignClient(name="tp-upload", fallbackFactory=UploadFeignClientFallback.class)
public interface UploadFeignClient {
	
	/**
	 * 使用post方式调用带参构造方法：通过Id查询单个图片信息
	 * @param requestMap
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/query-Info/queryPictureInfoById", method=RequestMethod.POST)
	public Object getPictureInfoById(@RequestBody Map<String, Object> requestMap, @RequestParam("id") String id);
	
	/**
	 * 使用get方式调用方法-查询所有图片信息
	 * @return
	 */
	@RequestMapping(value="/query-Info/queryPictureAllInfo", method=RequestMethod.GET)
	public Object getPictureAllInfo();
	
}
