package com.example.bloggerms.dto;

public class BloggerDetails {
	private long id;
	private String firstName;

	public BloggerDetails() {
	}

	public BloggerDetails(long id, String firstName, String lastName, String bloggerType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bloggerType = bloggerType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getBloggerType() {
		return bloggerType;
	}

	public void setBloggerType(String bloggerType) {
		this.bloggerType = bloggerType;
	}

	private String lastName;
	private String bloggerType;
}
