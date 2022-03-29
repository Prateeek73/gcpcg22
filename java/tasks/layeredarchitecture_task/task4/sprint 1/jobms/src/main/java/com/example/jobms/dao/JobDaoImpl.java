package com.example.jobms.dao;

import com.example.jobms.entity.Job;
import com.example.jobms.exceptions.IdNotFoundException;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JobDaoImpl implements IJobDao {

	@PersistenceContext
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void addJob(Job job) {
		entityManager.merge(job);
	}

	@Override
	public Job findById(long id) throws IdNotFoundException{
		Optional<Job> optional = Optional.of(entityManager.find(Job.class, id));
		if(optional.isEmpty())
			throw new IdNotFoundException("Id not found for : " + id);
		return optional.get();
	}

	@Override
	public Job update(Job job) throws IdNotFoundException {
		Optional<Job> optional = Optional.of(entityManager.merge(job));
		if(optional.isEmpty())
			throw new IdNotFoundException("Id not found for : " + job.getId());
		return optional.get();
		
	}

}
