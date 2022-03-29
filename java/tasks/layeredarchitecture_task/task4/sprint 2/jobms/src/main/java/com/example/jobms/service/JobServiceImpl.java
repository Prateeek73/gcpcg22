package com.example.jobms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobms.dao.IJobDao;
import com.example.jobms.dto.AddJobRequest;
import com.example.jobms.dto.ChangeJobTypeRequest;
import com.example.jobms.dto.JobDetails;
import com.example.jobms.entity.Job;
import com.example.jobms.exceptions.DescriptionOutOfBoundsException;
import com.example.jobms.exceptions.IdNotFoundException;
import com.example.jobms.exceptions.InvalidJobTypeException;
import com.example.jobms.util.JobUtil;

@Service
@Transactional
public class JobServiceImpl implements IJobService {

	@Autowired
	private IJobDao dao;

	@Autowired
	private JobUtil jobUtil;

	@Override
	public JobDetails addJob(AddJobRequest requestData) throws DescriptionOutOfBoundsException {
		validateDescription(requestData.getDescription());
		validateJobType(requestData.getJobType());

		Job job = new Job();
		job.setJobType(jobUtil.toEnum(requestData.getJobType()));
		job.setDescription(requestData.getDescription());
		dao.addJob(job);

		return jobUtil.toJobDetails(job);
	}

	@Override
	public Job findById(long id) throws IdNotFoundException {
		Job job = dao.findById(id);
		return job;
	}

	@Override
	public JobDetails findJobDetailsById(long id) throws IdNotFoundException {
		Job job = dao.findById(id);
		return jobUtil.toJobDetails(job);
	}

	@Override
	public void changeJobType(ChangeJobTypeRequest requestData) throws IdNotFoundException, InvalidJobTypeException {
		validateJobType(requestData.getJobType());

		Job job = dao.findById(requestData.getId());
		job.setJobType(jobUtil.toEnum(requestData.getJobType()));
		dao.update(job);
	}

	private void validateDescription(String description) throws DescriptionOutOfBoundsException {
		if (description.length() < 20 || description.length() > 100)
			throw new DescriptionOutOfBoundsException("The length of description is : " + description.length());
	}

	private void validateJobType(String jobType) {
		if (jobType.isEmpty())throw new InvalidJobTypeException("Job Type cannot be empty");

	}

}
