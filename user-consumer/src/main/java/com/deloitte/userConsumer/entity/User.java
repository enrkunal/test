package com.deloitte.userConsumer.entity;

public class User {

	public User() {
	}
	
	public User(String userId, String firstName, String lastName, String location) {
		this.userId=userId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.location=location;
	}

	private String userId;
	private String firstName;
	private String lastName;
	private String location;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
