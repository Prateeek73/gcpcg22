package com.example.jobms.dao;

import com.example.jobms.entity.Job;
import com.example.jobms.exceptions.IdNotFoundException;

public interface IJobDao {

	void addJob(Job job);

	Job findById(long id) throws IdNotFoundException;

	Job update(Job job) throws IdNotFoundException;
}
