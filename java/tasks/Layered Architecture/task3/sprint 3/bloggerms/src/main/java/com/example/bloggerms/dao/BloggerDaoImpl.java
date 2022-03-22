package com.example.bloggerms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bloggerms.entity.Blogger;
import com.example.bloggerms.exceptions.IdNotFoundException;

@Repository
public class BloggerDaoImpl implements IBloggerDAO {

	@PersistenceContext
//    @Autowired
    private EntityManager entityManager;

	@Override
	public void addBlogger(Blogger blogger) {
		entityManager.merge(blogger);
	}

	@Override
	public Blogger findById(long id) throws IdNotFoundException {
		Blogger blogger = entityManager.find(Blogger.class, id);
		if (blogger == null)
			throw new IdNotFoundException("ID not found");
		return blogger;
	}

	@Override
	public Blogger updateCustomer(Blogger blogger) throws IdNotFoundException {
		Blogger q_blogger = entityManager.merge(blogger);
		if (q_blogger == null)
			throw new IdNotFoundException("Id not found");
		return q_blogger;
	}

	@Override
	public List<Blogger> findAll() {
		String query_text = "select * from bloggers";
		TypedQuery<Blogger> query = entityManager.createQuery(query_text, Blogger.class);
		List<Blogger> values = query.getResultList();
		return values;
	}
}
