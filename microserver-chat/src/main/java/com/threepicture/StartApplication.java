package com.threepicture;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 启动加载，必须放在项目根目录
 * @author 杏仁拌饭
 *
 */
@SpringBootApplication
//eureka客户端注册（此注解属于组合注解包含@EnableDiscoveryClient）
@EnableEurekaClient
//开启hystrix断路功能-需要在contrller中配置HystrixCommand
@EnableCircuitBreaker
//Feign负载
@EnableFeignClients
//定义扫描的路径从中找出标识了需要装配的类自动装配到spring的bean容器中
//@ComponentScan( basePackages = "com.threepicture.frame.*")
//将项目中对应的mapper类的路径加进来就可以了
@MapperScan("com.threepicture.dao.mapper")
public class StartApplication {

	private static Logger logger = LoggerFactory.getLogger(StartApplication.class);
	
	public static void main(String[] args) {
		
		logger.info("进入cust....");
		
		SpringApplication.run(StartApplication.class, args);
	}

}

