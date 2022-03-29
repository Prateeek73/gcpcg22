package com.example.bloggerms.dao;

import java.util.List;

import com.example.bloggerms.entity.Blogger;
import com.example.bloggerms.exceptions.IdNotFoundException;

public interface IBloggerDAO {
	void addBlogger(Blogger blogger);

	Blogger findById(long id) throws IdNotFoundException;

	Blogger updateCustomer(Blogger blogger) throws IdNotFoundException;

	List<Blogger> findAll();
}
