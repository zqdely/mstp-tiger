package com.threepicture.server;

import java.util.List;

import com.threepicture.dao.model.User;

public interface ProductController {

	List<User> queryAllUser();
	
//	Object getPage(int pageNum, int pageSize);
	
}
