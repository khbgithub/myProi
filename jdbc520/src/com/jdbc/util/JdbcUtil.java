package com.jdbc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 此工具类  封装了执行sql 语句的方法
 * 
 * */
public class JdbcUtil {
	private static Connection  conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	public static Connection getCon(){
		//1.创建连接池对象
		DataSource ds = new ComboPooledDataSource();
		//2.从连接池获取连接对象
		conn=null;
		try {
			 conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
}
	
	
	
	public static void closeCon(){
		try {
			if(conn!=null){
				conn.close();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 封装查询操作
	 * @param sql: select * from user where userName = ? and password =?;
	 * @param params  可变参数     往sql中注入的参数
	 * */

	public static ResultSet executeQuery(String sql,Object ...params){
		getCon();
		try {
			 pstmt = conn.prepareStatement(sql);
			if(params!=null&&params.length>0){
				for(int i=0;i<params.length;i++){
					 pstmt.setObject(i+1, params[i]);
				}
			}
			
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeCon();
		}
		
		
		
		return rs;
	}
	
	/**
	 * 封装 增删改 操作
	 * @param sql
	 * @param 可变参数
	 * @return 影响的记录数
	 * 
	 * */
	public static int executeUpdate(String sql,Object ...params){
		
		getCon();
		int count=0;
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			if(params!=null&&params.length>0){
				for(int i=0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
			}
			
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeCon();
		}
	
		return count;
		
	}
	
	
	

}
