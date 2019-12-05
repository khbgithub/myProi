package com.jdbc.dao.impl;

import com.jdbc.dao.BoyDao;
import com.jdbc.pojo.Boy;
import com.jdbc.util.JdbcUtil;

public class BoyDaoImpl implements BoyDao {

	@Override
	public int insertBoy(Boy boy) {
	String sql="insert into boys values(null,?,?)"; 
	int result = JdbcUtil.executeUpdate(sql, boy.getBoyName(),boy.getUserCp());
	
		return result;
	}

}
