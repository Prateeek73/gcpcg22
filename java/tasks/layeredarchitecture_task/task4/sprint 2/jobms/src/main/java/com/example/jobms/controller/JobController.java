package com.example.jobms.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobms.dto.AddJobRequest;
import com.example.jobms.dto.ChangeJobTypeRequest;
import com.example.jobms.dto.JobDetails;
import com.example.jobms.exceptions.DescriptionOutOfBoundsException;
import com.example.jobms.exceptions.IdNotFoundException;
import com.example.jobms.exceptions.InvalidJobTypeException;
import com.example.jobms.service.IJobService;

@Validated
@RequestMapping("/jobs")
@RestController
public class JobController {
	@Autowired
	private IJobService service;

	/*
	 * Effective url : /jobs/add
	 */
	@PostMapping(value = "/add")
	public JobDetails addJob(@RequestBody @Valid AddJobRequest addJobRequest) throws DescriptionOutOfBoundsException {
		return service.addJob(addJobRequest);
	}

	/*
	 * Effective url : /jobs/find/byid/{id}
	 */
	@GetMapping("/find/byid/{id}")
	public JobDetails findById(@PathVariable @Min(1) int id) throws IdNotFoundException {
		return service.findJobDetailsById(id);
	}

	/*
	 * Effective url : /update/jobType
	 */
	@PutMapping("/update/jobType")
	public void updateJobType(@RequestBody @Valid ChangeJobTypeRequest changeJobTypeRequest)
			throws InvalidJobTypeException, IdNotFoundException {
		service.changeJobType(changeJobTypeRequest);

	}

}
