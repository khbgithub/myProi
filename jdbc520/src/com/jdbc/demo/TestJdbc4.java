package com.jdbc.demo;

import java.sql.Connection;

import org.junit.Test;

import com.jdbc.dao.UserDao;
import com.jdbc.dao.impl.UserDaoImpl;
import com.jdbc.pojo.User;
import com.jdbc.util.DbUtil;

/**
 * 工具类的封装 
 * 
 * 为什么不适用Statement ，而要使用PrepareStatement
 *    :Statement不安全  会出现sql 注入问题
 * 
 * 场景： 登录 的场景     用户输入用户名 和  密码 ，传到java 程序，封装到 对象中，然后 找dao ，让dao 帮咱们操作数据库
 * 
 * */
public class TestJdbc4 {
	public static void main(String[] args) {
		User user = new User();
		
		//user.setUserName("john' #");
		user.setUserName("john' or '1'='1");
		user.setPassword("eqwq");
		
		DbUtil dbUtil = new DbUtil();
		Connection con = dbUtil.getCon();
		
		UserDao ud = new UserDaoImpl();
		
		User currentUser = ud.login(con,user);
		
		if(currentUser!=null){
			System.out.println("登陆成功");
		}else{
			System.out.println("用户名或密码错误");
		}
		
		dbUtil.close(con);
	}
	@Test
	public void testLogin(){
		User user = new User();
		
		//user.setUserName("john' #");
		user.setUserName("john' or '1'='1");
		//user.setUserName("john");
		user.setPassword("ewqeqwqw");
		
		DbUtil dbUtil = new DbUtil();
		Connection con = dbUtil.getCon();
		
		UserDao ud = new UserDaoImpl();
		
		User currentUser = ud.login2(con,user);
		
		if(currentUser!=null){
			System.out.println("登陆成功");
		}else{
			System.out.println("用户名或密码错误");
		}
		
		dbUtil.close(con);
	}
	
	
	
	
}
