package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

/*
 * 1.添加数据  向 beauty 表 插入 宋慧乔  
 * 2.修改boys 表 宋仲基 的名字  为  xxx  
 * 3.删除表boys  中的  id 为 6 的 记录
 * */
public class TestJdbc3 {
	
	Connection con =null;
	@Before
	public void doBefore() throws ClassNotFoundException, SQLException{
		String userName="root";
		String password ="123456";
		String url="jdbc:mysql://localhost:3306/db_bigdata";
		String driverName="com.mysql.jdbc.Driver";
		Class.forName(driverName);
		
		 con = DriverManager.getConnection(url, userName, password);
	}
	
	@Test	
	public void demo1() throws SQLException{
		Statement st = con.createStatement();
		String sql="insert into beauty values(null,'宋慧乔','女',now(),123,null,5)";
		int result = st.executeUpdate(sql);
	
		if(result==1){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
			
		}
	}
	@Test	
	public void demo2() throws SQLException{
		Statement st = con.createStatement();
		String sql="update boys set boyName='xxx' where id =5";
		int result = st.executeUpdate(sql);
	
		if(result==1){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
			
		}
	}
	@Test	
	public void demo3() throws SQLException{
		Statement st = con.createStatement();
		String sql="delete from boys where id =6";
		int result = st.executeUpdate(sql);
	
		if(result==1){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
			
		}
	}
	
	@Test
	public void doAfter() throws SQLException{
		con.close();
	}
	
	
}
