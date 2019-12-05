package com.jdbc.util;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.jdbc.pojo.Boy;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 
 * 第三方 工具类 的使用    commons-dbutils 包下 
 * 
 * */
public class DbUtilsTest {
	@Test
	public void test1(){
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
	
		String sql="select * from boys where id = 1";
		
		try {
			Boy boy = qr.query(sql, new BeanHandler<>(Boy.class));
			System.out.println(boy);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Test
	public void test2(){
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		
		String sql="select * from boys where boyName = ?";
		String name = "诸葛亮";
		try {
			 List<Boy> list = qr.query(sql, new BeanListHandler<>(Boy.class),name);
			 for(Boy b:list){
				 System.out.println(b);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
