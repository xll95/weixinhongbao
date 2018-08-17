package com.gab.pojo;

import java.io.Serializable;
import java.util.Date;

public class UserInf implements Serializable {
	
	private int id;
	private String name;
	private int age;
	private Date birthday;
	private UserType type;
	
	
	
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public UserInf() {
	}
	public UserInf(int id, String name, int age, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}

}
