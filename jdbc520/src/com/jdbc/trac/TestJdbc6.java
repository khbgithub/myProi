package com.jdbc.trac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.util.DbUtilByPool;
/*
 * 案例 ： 转账    演示 事务
 * 
 * */
public class TestJdbc6 {
	public static void main(String[] args) {
		// 获取连接
		Connection con = DbUtilByPool.getCon(); 
		//关闭自动提交
		try {
			con.setAutoCommit(false);
			// 王健林 - 250
			String sql1 = "update account set balance = balance - ? where id = ? ";
			//王思聪 +250
			String sql2 = "update account set balance = balance + ? where id = ? ";
			
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
		
			// 注入参数
			pstmt1.setDouble(1, 250);
			pstmt1.setInt(2, 1);
			
			pstmt2.setDouble(1,250 );
			pstmt2.setDouble(2,2 );
			
			//执行sql
			
			pstmt1.executeUpdate();
			
			//  发生异常
			int i = 3/0;
			
			pstmt2.executeUpdate();
			
			
			con.commit();
			
		} catch (Exception e) {

			if(con!=null){
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			e.printStackTrace();
		}finally {
			DbUtilByPool.closeCon(con);
		}
		
		
		
	}
}
