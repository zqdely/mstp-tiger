package com.threepicture.dao.mapper;

import java.util.List;
import java.util.Map;

//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;

import com.threepicture.dao.model.User;

@Deprecated//测试类已经废弃
//@Mapper
public interface ProductDao {
	
	//插入用户
//    int insert(User user);
    //查询所有
    //@Select("select id,username,address from tb_user")
    List<User> queryAllUser();

    //根据id查询
    Map<String, Object> selectById(String id);

}
