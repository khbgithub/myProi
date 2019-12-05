package com.jdbc.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtilByPool {
	
	public static Connection getCon(){
				//1.创建连接池对象
				DataSource ds = new ComboPooledDataSource();
				//2.从连接池获取连接对象
				Connection conn=null;
				try {
					 conn = ds.getConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return conn;
	}
	
	
	public static void closeCon(Connection con){
		try {
			if(con!=null){
				con.close();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(getCon());
	}
}
