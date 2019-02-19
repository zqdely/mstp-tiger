package com.threepicture.server;

import java.util.List;
import java.util.Map;

import com.threepicture.dao.model.User;

public interface ProductController {

	List<User> queryAllUser();
	
	Map<String, Object> queryUserById(String id);
	
}
