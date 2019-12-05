package com.jdbc.demo;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.jdbc.dao.BoyDao;
import com.jdbc.dao.UserDao;
import com.jdbc.dao.impl.BoyDaoImpl;
import com.jdbc.dao.impl.UserDaoImpl;
import com.jdbc.pojo.Beauty;
import com.jdbc.pojo.Boy;
import com.jdbc.pojo.User;
import com.jdbc.util.DbUtil;
import com.jdbc.util.DbUtilByPool;

/**
 * 
 * 练习 使用PrepareStatement
 * 
 * */
public class TestJdbc5 {
	
	Scanner sc = new Scanner(System.in);
	
	@Test
	public void test1(){
		//查询      模拟登录
		System.out.println("请输入用户名");
		String name = sc.next();
		System.out.println("请输入密码");
		String password = sc.next();
	
		User user = new User();
		user.setUserName(name);
		user.setPassword(password);
		DbUtil dbUtil = new DbUtil();
		Connection con = dbUtil.getCon();
		UserDao ud = new UserDaoImpl();
		User currentUser = ud.login2(con, user);
		if(currentUser!=null){
			System.out.println("登陆成功");
		}else{
			System.out.println("登陆失败");
			
		}
		
		
	
	}
	
	@Test
	public void test2(){
		//添加      向admin 表添加一条记录     insert into admin values(null,?,?,?)
		System.out.println("请输入用户名");
		String name = sc.next();
		System.out.println("请输入密码");
		String password = sc.next();
		
		User user = new User();
		user.setUserName(name);
		user.setPassword(password);
		user.setRegisterDate(new Date());
		
		DbUtil dbUtil = new DbUtil();
		Connection con = dbUtil.getCon();
		UserDao ud = new UserDaoImpl();
		
		int result = ud.addUser(con,user);
		if(result==1){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
			
		}
	}
	
	@Test
	public void test3(){
		//修改     修改 admin 表的 id 为 3 的   用户的密码 为 1234 
		User user = new User();
		user.setUid(3);
		user.setPassword("1234");
		DbUtil dbUtil = new DbUtil();
		Connection con = dbUtil.getCon();
		UserDao ud = new UserDaoImpl();
		int result = ud.updateUser(con,user);
		
		if(result==1){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
			
		}
		
		
		
	}
	@Test
	public void test4(){
		//删除   删除    id 为 3 的   用户 
		
		UserDao ud = new UserDaoImpl();
		
		int id =2;
		Connection con = DbUtilByPool.getCon();
		
		
		int result = ud.deleteUserById(con,id);
		if(result==1){
			System.out.println("删除成功");
		}
		
		
	}
	@Test
	public void test5(){
		//根据  id  查询用户  
		
		UserDao ud = new UserDaoImpl();
		int id = 3;
		User u = ud.findUserById(id);
		System.out.println(u);
	}
	@Test
	public void test6(){
		// 查询 所有用户   返回 List 
		
	}
	
	
	@Test
	public void test7(){
		// 查询       姓周的     美女         beauty   表 
		
		Beauty girl = new Beauty();
		
		girl.setName("周");
		
		girl.setPhone("098");
		
		
		UserDao ud = new UserDaoImpl();
		DbUtil dbUtil = new DbUtil();
		
		Connection con = dbUtil.getCon();
		
		List<Beauty> list = ud.findBeauty(con,girl);
		
		for(Beauty b:list){
			System.out.println(b);
		}
		
	}
	
	
	@Test
	public void test8(){
		// 向boys 表 插入数据
		
		BoyDao bd = new BoyDaoImpl();
		Boy boy = new Boy();
		boy.setBoyName("诸葛亮");
		boy.setUserCp(100);
		int result = bd.insertBoy(boy);
		
		if(result==1){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
