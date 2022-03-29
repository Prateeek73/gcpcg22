package com.example.bloggerms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.bloggerms.constants.BloggerType;

import java.util.Objects;

@Table(name="bloggers")
@Entity
public class Blogger {
	
	@GeneratedValue
	@Id
	private long id;
	private String firstName;
	private String lastName;
	private BloggerType bloggerType;
	
	public Blogger() {
		
	}
	
	public Blogger(String firstName, String lastName, BloggerType bloggerType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.setBloggerType(bloggerType);
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

	
	@Override
	public String toString() {
		return "Blogger [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blogger other = (Blogger) obj;
		return id == other.id;
	}

	public BloggerType getBloggerType() {
		return bloggerType;
	}

	public void setBloggerType(BloggerType bloggerType) {
		this.bloggerType = bloggerType;
	}

}
