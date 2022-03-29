package com.example.bloggerms.dto;

public class RegisterBloggerRequest {
	private String firstName;
	private String lastName;
	private String bloggerType;

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

	public String getBloggerType() {
		return bloggerType;
	}

	public void setBloggerType(String bloggerType) {
		this.bloggerType = bloggerType;
	}

}
