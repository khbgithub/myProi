package com.jdbc.pojo;

public class Boy {
	private int id;
	private String boyName;
	private int userCp;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBoyName() {
		return boyName;
	}
	public void setBoyName(String boyName) {
		this.boyName = boyName;
	}
	public int getUserCp() {
		return userCp;
	}
	public void setUserCp(int userCp) {
		this.userCp = userCp;
	}
	@Override
	public String toString() {
		return "Boy [id=" + id + ", boyName=" + boyName + ", userCp=" + userCp + "]";
	}
	
	
}
