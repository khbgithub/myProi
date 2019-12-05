package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.pojo.Emp;
/**
 * JDBC 的入门案例   
 * 	   感受  入门代码    ，理解  几个接口的作用和 用法 
 * 
 * 
 * */
public class TestJdbc1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//  连接数据库的准备工作       数据库在哪？     找到数据库之后  需要用户名 密码    还需要连接数据库的驱动   
		/*
		 * 准备工作
		 * 1.数据库在哪？
		 * 2.用户名
		 * 3.密码
		 * 4.数据库厂商提供的 JDBC 的 实现 ，即  数据库驱动
		 * 
		 * */
		
		String userName="root";
		String password ="123456";
		String url="jdbc:mysql://localhost:3306/db_bigdata";
		String driverName="com.mysql.jdbc.Driver";
		
		
		//1. 加载驱动
		Class.forName(driverName);
		// 2.获取连接  获取java程序和数据库之间的连接
		Connection connection = DriverManager.getConnection(url, userName, password);
		
		//3. 获取发送数据的对象
		String sql="select * from employees";
		Statement statement = connection.createStatement();
		
		//4.向数据库 发送sql 并得到sql 的执行结果
		
		ResultSet rs = statement.executeQuery(sql);
		
		/*System.out.println(rs.next());
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));*/
		Emp emp = null;
		List<Emp> list = new ArrayList<>(); 
		while(rs.next()){
			emp = new Emp();
			int employee_id  = rs.getInt(1);
			//emp.setEmployee_id(employee_id);
			//emp.setFirst_name(rs.getString(2));     //  获取 第 index  列 的 指定类型的数据
			//emp.setLast_name(rs.getString(3));
			//emp.setEmail((String) rs.getObject("email"));  // 根据列名获取数据
			//emp.setPhone_number((String) rs.getObject(5));
			//emp.setHiredate(rs.getDate("hiredate"));
			
			emp.setEmployee_id(employee_id);
			emp.setFirst_name(rs.getString("first_name"));
			emp.setLast_name(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhone_number(rs.getString("phone_number"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommission_pct(rs.getDouble("commission_pct"));
			emp.setManager_id(rs.getInt("manager_id"));
			emp.setHiredate(rs.getDate("hiredate"));
			
			
			
			list.add(emp);
		}
		
		for(Emp e:list){
			System.out.println(e);
		}
		
		
		
		//5.关闭资源
		connection.close();
		
	}
}
