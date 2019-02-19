package com.threepicture.feignClient;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.threepicture.util.ProductConstants;

import feign.hystrix.FallbackFactory;

@Component
public class UploadFeignClientFallback implements FallbackFactory<UploadFeignClient> {

	@Override
	public UploadFeignClient create(Throwable cause) {
		
		return new UploadFeignClient() {
			
			@Override
			public Object getPictureAllInfo() {
				
				Map<String, Object> responseMap = new HashMap<String, Object>();
				
				responseMap.put(ProductConstants.OPT_ID, "/query-Info/queryPictureInfoById");
				
				return fallback(responseMap);
				
			}
			
			@Override
			public Object getPictureInfoById(Map<String, Object> requestMap, String id) {
				
				Map<String, Object> responseMap = new HashMap<String, Object>();
				
				responseMap.put(ProductConstants.OPT_ID, "/query-Info/queryPictureAllInfo");
				
				return fallback(responseMap);
				
			}
			
			public Object fallback(Map<String, Object> responseMap){
				
//				Optional<T>
				
				responseMap.put(ProductConstants.RESPONSE_MSSAGE_KEY, ProductConstants.RESPONSE_ERROR_MESSAGE_INFO_OF_HYSTRIX);
				
				responseMap.put(ProductConstants.RESPONSE_TYPE, ProductConstants.RESPONSE_TYPE_E);
				
				return responseMap;
				
			}
		};
		
	}
	
}
