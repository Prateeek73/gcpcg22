package com.example.bloggerms.service;

import javax.naming.InvalidNameException;

import com.example.bloggerms.entity.Blogger;
import com.example.bloggerms.exceptions.IdNotFoundException;
import com.example.bloggerms.exceptions.InvalidIdException;

public interface IBloggerService {
	void register(String firstName, String lastName) throws InvalidNameException;

	Blogger findById(long id) throws IdNotFoundException, InvalidIdException;

	void changeBloggerName(long id, String newFirstName, String newLastName) throws IdNotFoundException, InvalidNameException, InvalidIdException ;
}
