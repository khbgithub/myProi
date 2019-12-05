package com.jdbc.dao;

import java.sql.Connection;
import java.util.List;

import com.jdbc.pojo.Beauty;
import com.jdbc.pojo.User;

public interface UserDao {
	@Deprecated
	User login(Connection con, User user);

	User login2(Connection con, User user);

	int addUser(Connection con, User user);

	int updateUser(Connection con, User user);

	List<User> findUser(Connection con, User user);


	List<Beauty> findBeauty(Connection con, Beauty girl);

	int deleteUserById(Connection con, int id);

	User findUserById(int id);

}
