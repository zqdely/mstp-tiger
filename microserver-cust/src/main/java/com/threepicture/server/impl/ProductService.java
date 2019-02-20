package com.threepicture.server.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threepicture.dao.mapper.ProductDao;
import com.threepicture.dao.model.User;
import com.threepicture.server.ProductController;

@Deprecated //测试类已废弃
@Service
//@Transactional
public class ProductService implements ProductController{
	
	@Autowired
	private ProductDao productDao;
	
	public List<User> queryAllUser(){
		
		System.out.println("进入service...");
		
		return productDao.queryAllUser();
		
	}

	@Override
	public Map<String, Object> queryUserById(String id) {
		
		return productDao.selectById(id);
	}

	
	/*public Object getPage(int pageNum, int pageSize) {
		
		 配置分页参数 
		PageHelper.startPage(pageNum,pageSize);

		List<User> users = productDao.queryAllUser();
		
		return new PageInfo<>(users);
	}*/

}
