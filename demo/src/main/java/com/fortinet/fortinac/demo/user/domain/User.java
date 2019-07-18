package com.fortinet.fortinac.demo.user.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
	long id;
	String name;
    private Date birthday;
    private Date createdTime;
	String email;
	int age;
	List<String> aliases = new ArrayList<String>();
	UserAddress address = new UserAddress();
	
	List<UserAddress> addressHistory = new ArrayList<UserAddress>();

	public User(long id, String name, Date birthday, String email) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getAliases() {
		return aliases;
	}

	public void setAliases(List<String> aliases) {
		this.aliases = aliases;
	}

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public List<UserAddress> getAddressHistory() {
		return addressHistory;
	}

	public void setAddressHistory(List<UserAddress> addressHistory) {
		this.addressHistory = addressHistory;
	}
}
