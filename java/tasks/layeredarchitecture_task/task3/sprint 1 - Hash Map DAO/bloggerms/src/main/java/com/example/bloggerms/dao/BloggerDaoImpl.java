package com.example.bloggerms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.bloggerms.entity.Blogger;
import com.example.bloggerms.exceptions.IdNotFoundException;

@Repository
public class BloggerDaoImpl implements IBloggerDAO {
	private Map<Long, Blogger> store = new HashMap<>();

	@Override
	public void addBlogger(Blogger blogger) {
		store.put(blogger.getId(), blogger);
	}

	@Override
	public Blogger findById(long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Blogger blogger = store.get(id);
		if (blogger == null) throw new IdNotFoundException("ID not found");
		return blogger;
	}

	@Override
	public Blogger updateCustomer(Blogger blogger) throws IdNotFoundException {
		Blogger q_blogger = store.get(blogger.getId());
		if (q_blogger == null) throw new IdNotFoundException("ID not found");
		store.put(blogger.getId(), blogger);
		return q_blogger;
	}

	@Override
	public List<Blogger> findAll() {
		Collection<Blogger> values = store.values();
		List<Blogger> list = new ArrayList<>();
		list.addAll(values);
		return list;
	}
}
