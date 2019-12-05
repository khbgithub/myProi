package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.UserDao;
import com.jdbc.pojo.Beauty;
import com.jdbc.pojo.User;
import com.jdbc.util.DateUtil;
import com.jdbc.util.JdbcUtil;
import com.jdbc.util.StringUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public User login(Connection con, User user) {
		
		String sql ="select * from admin where username='"+user.getUserName()+"' and password = '"+user.getPassword()+"'" ;
		System.out.println(sql);
		
		User u = null;
		try {
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				u = new User();
				u.setUid(rs.getInt("id"));
				u.setUserName(rs.getString("USERNAME"));
				u.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public User login2(Connection con, User user) {
		String sql = "select * from admin where username = ? and password = ?";
		User u = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2,user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				u = new User();
				u.setUid(rs.getInt("id"));
				u.setUserName(rs.getString("USERNAME"));
				u.setPassword(rs.getString("password"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int addUser(Connection con, User user) {
		//String sql="insert into admin values(null,?,?,now())";
		String sql="insert into admin values(null,?,?,?)";
		int result=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			//pstmt.setDate(3, new Date(user.getRegisterDate().getTime()));
			pstmt.setString(3,DateUtil.dateToStr(user.getRegisterDate()) );
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateUser(Connection con, User user) {
		String sql ="update admin set password = ? where id = ? ";
		int result=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getPassword());
			pstmt.setInt(2, user.getUid());
			
			 result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return result;
	}

	@Override
	public List<User> findUser(Connection con, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Beauty> findBeauty(Connection con, Beauty girl) {
		StringBuilder sb = new StringBuilder("select * from beauty ");
		
		if(StringUtils.isNotEmpty(girl.getName())){
			sb.append(" and name like '%"+girl.getName()+"%'");
		}
		if(StringUtils.isNotEmpty(girl.getPhone())){
			sb.append(" and phone like '%"+girl.getPhone()+"%'");
		}
		
		
		String sql = sb.toString().replaceFirst("and", "where");
		
		System.out.println(sql);
		List<Beauty> list = new ArrayList<>();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			Beauty beauty = null;
			while(rs.next()){
				beauty = new Beauty();
				beauty.setId(rs.getInt("id"));
				beauty.setName(rs.getString("name"));
				//.....
				
				list.add(beauty);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int deleteUserById(Connection con, int id) {
		String sql ="delete from admin where id = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			 result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public User findUserById(int id) {
		String sql = "select * from admin where id = ?";
		ResultSet rs = JdbcUtil.executeQuery(sql, id);
		User user = null;
		try {
			while(rs.next()){
				user = new User();
				user.setUid(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

}
