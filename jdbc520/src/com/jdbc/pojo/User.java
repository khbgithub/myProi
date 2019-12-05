package com.jdbc.pojo;

import java.util.Date;

public class User {
	private int uid;
	private String userName;
	private String password;
	private int age;
	private String address;
	
	
	

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	private Date registerDate;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", password=" + password + ", registerDate="
				+ registerDate + "]";
	}
	
	
	
}
