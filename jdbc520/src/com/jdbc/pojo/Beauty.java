package com.jdbc.pojo;

import java.util.Date;

public class Beauty {
	private int id;
	private String name;
	private String sex;
	private Date borndate;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBorndate() {
		return borndate;
	}
	public void setBorndate(Date borndate) {
		this.borndate = borndate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Beauty [id=" + id + ", name=" + name + ", sex=" + sex + ", borndate=" + borndate + ", phone=" + phone
				+ "]";
	}
	
	
	
	
	
}
