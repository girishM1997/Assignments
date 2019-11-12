package com.training.entity;

public class RegisterUser {

	private String firstName;
	private String LastName;
	private long userId;
	private String password;
	private String typeOfUser;
	public RegisterUser() {
		super();
	}
	public RegisterUser(String firstName, String lastName, long userId, String password, String typeOfUser) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.userId = userId;
		this.password = password;
		this.typeOfUser = typeOfUser;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTypeOfUser() {
		return typeOfUser;
	}
	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	@Override
	public String toString() {
		return "Users [firstName=" + firstName + ", LastName=" + LastName + ", userId=" + userId + ", password="
				+ password + ", typeOfUser=" + typeOfUser + "]";
	}
	
}
