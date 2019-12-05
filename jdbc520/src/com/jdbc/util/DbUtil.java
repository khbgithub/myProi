package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 一个 简陋的工具类  只是用来获取 连接
 * 
 * 
 * */

public class DbUtil {
	private static final String dbUrl="jdbc:mysql://localhost:3306/db_bigdata";
	private static final String driverName="com.mysql.jdbc.Driver";
	private static final String userName="root";
	private static final String password="123456";
	
	public Connection getCon(){
		Connection conn =null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbUrl, userName, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void close(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		System.out.println(dbUtil.getCon());
	}
}
