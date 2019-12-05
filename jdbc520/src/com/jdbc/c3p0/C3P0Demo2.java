package com.jdbc.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo2 {
	public static void main(String[] args) throws SQLException {
		//1.创建连接池对象
		DataSource ds = new ComboPooledDataSource();
		
		for(int i=1;i<=11;i++){
			Connection conn = ds.getConnection();
			System.out.println(i+":"+conn);
			
			if(i==5){
				conn.close();  // 把连接归还给连接池
			}
			
		}
		
	
	}
}
