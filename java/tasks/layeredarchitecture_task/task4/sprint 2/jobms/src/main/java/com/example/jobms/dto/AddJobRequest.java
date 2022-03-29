package com.example.jobms.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class AddJobRequest {
	@Length(min=20, max=100)
	private String description;
	@NotBlank()
	private String jobType;

	public AddJobRequest() {

	}

	public AddJobRequest(String description, String jobType) {
		this.description = description;
		this.jobType = jobType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
}
