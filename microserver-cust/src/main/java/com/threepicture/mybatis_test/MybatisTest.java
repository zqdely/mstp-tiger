package com.threepicture.mybatis_test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTest {
	
//	ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();
	SqlSession session = null;
	
	private void getSession(){
		
		//定义mybatis全局配置文件
		String configuration = "classpath:mybatis-config.xml";
		//加载mybatis全局配置文件
		InputStream inputStream = MybatisTest.class.getClassLoader().getResourceAsStream(configuration);
		//构建sqlSession工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//根据factory生产session
		session = sessionFactory.openSession();
		/*if(session != null){
			synchronized(MybatisTest.class){
				if(session != null)
					//根据factory生产session
					session = sessionFactory.openSession();
			}
		}*/
		
//		threadLocal.get().format(new Date());
	}
	
	public void testSqlSession(){
		
		session.selectList("");//使用DefaultSqlSession
		
		session.close();//end close session
		
	}
	
	Connection connection = null;
	/**
	 * 普通jdbc链接
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void getConnection() throws ClassNotFoundException, SQLException{
		
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.获取数据库链接
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/blogdb?characterEncoding=UTF-8", "root", "123");
		
		//3.获取链接之后按照需要关闭事务提交
//		connection.setAutoCommit(false);
		//4.提交变更
//		connection.commit();
		//5.回滚变更
//		connection.rollback();
	}

}
