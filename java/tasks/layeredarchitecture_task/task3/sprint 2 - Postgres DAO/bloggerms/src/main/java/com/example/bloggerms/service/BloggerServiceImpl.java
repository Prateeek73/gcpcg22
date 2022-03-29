package com.example.bloggerms.service;

import javax.naming.InvalidNameException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bloggerms.dao.IBloggerDAO;
import com.example.bloggerms.entity.Blogger;
import com.example.bloggerms.exceptions.IdNotFoundException;
import com.example.bloggerms.exceptions.InvalidIdException;

@Service
@Transactional
public class BloggerServiceImpl implements IBloggerService {

	@Autowired
	private IBloggerDAO dao;

	@Override
	public void register(String firstName, String lastName) throws InvalidNameException {
		validateName(firstName);
		validateName(lastName);
		Blogger blogger = new Blogger(firstName, lastName);
		dao.addBlogger(blogger);
	}

	@Override
	public Blogger findById(long id) throws IdNotFoundException, InvalidIdException {
		validateId(id);
		return dao.findById(id);
	}

	@Override
	public void changeBloggerName(long id, String newFirstName, String newLastName) throws IdNotFoundException, InvalidIdException, InvalidNameException {
		validateId(id);
		validateName(newFirstName);
		validateName(newLastName);
		Blogger blogger = dao.findById(id);
		blogger.setFirstName(newFirstName);
		blogger.setLastName(newLastName);
	}

	void validateName(String name) throws InvalidNameException {
		if (name == null || name.isEmpty() || name.length() < 2 || name.length() > 10) {
			throw new InvalidNameException("Invalid name: " + name);
		}
	}

	void validateId(long id) throws InvalidIdException {
		if (id < 0 || id > 1000) {
			throw new InvalidIdException("Invalid id: " + id);
		}
	}
}
