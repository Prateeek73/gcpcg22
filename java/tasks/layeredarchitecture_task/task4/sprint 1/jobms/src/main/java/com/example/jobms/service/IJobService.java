package com.example.jobms.service;

import com.example.jobms.dto.AddJobRequest;
import com.example.jobms.dto.ChangeJobTypeRequest;
import com.example.jobms.dto.JobDetails;
import com.example.jobms.entity.Job;
import com.example.jobms.exceptions.DescriptionOutOfBoundsException;
import com.example.jobms.exceptions.IdNotFoundException;
import com.example.jobms.exceptions.InvalidJobTypeException;

public interface IJobService {
	JobDetails addJob(AddJobRequest requestData) throws DescriptionOutOfBoundsException;

	Job findById(long id) throws IdNotFoundException;

	JobDetails findJobDetailsById(long id) throws IdNotFoundException;

//	
	void changeJobType(ChangeJobTypeRequest requestdata) throws IdNotFoundException, InvalidJobTypeException;
}
