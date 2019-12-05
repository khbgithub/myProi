package com.jdbc.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo1 {
	public static void main(String[] args) throws SQLException {
		//1.创建连接池对象
		DataSource ds = new ComboPooledDataSource();
		//2.从连接池获取连接对象
		Connection conn = ds.getConnection();
		
		System.out.println(conn);
	}
}
