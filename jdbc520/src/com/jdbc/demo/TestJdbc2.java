package com.jdbc.demo;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 向数据库boys 表 插入数据
 * 
 * */
public class TestJdbc2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String userName="root";
		String password ="123456";
		String url="jdbc:mysql://localhost:3306/db_bigdata";
		String driverName="com.mysql.jdbc.Driver";
		
		Class.forName(driverName);
		
		Connection connection = DriverManager.getConnection(url, userName, password);
		
		Statement st = connection.createStatement();
		
		String sql="insert into boys values(null,'宋仲基',200)";
		
		// 执行增删改 语句   executeUpdate 
		int result = st.executeUpdate(sql);  //  返回值  表示 影响了几条记录
		
		System.out.println(result);
		
		if(result==1){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
			
		}
		
		connection.close();
		
	}
}
