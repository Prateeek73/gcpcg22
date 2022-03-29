package com.example.jobms.util;

import org.springframework.stereotype.Component;

import com.example.jobms.constants.JobType;
import com.example.jobms.dto.JobDetails;
import com.example.jobms.entity.Job;
import com.example.jobms.exceptions.InvalidJobTypeException;

@Component
public class JobUtil {

	public JobDetails toJobDetails(Job job) {
		JobDetails desired = new JobDetails(job.getId(), job.getDescription(), job.getJobType().toString());
		return desired;
	}

	public JobType toEnum(String jobTypeText) {
		for (JobType iterated : JobType.values())
			if (iterated.toString().equalsIgnoreCase(jobTypeText))
				return iterated;
		throw new InvalidJobTypeException("Invalid course name : " + jobTypeText);
	}

}
