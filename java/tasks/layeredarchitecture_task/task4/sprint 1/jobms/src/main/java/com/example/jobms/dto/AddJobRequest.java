package com.example.jobms.dto;

public class AddJobRequest {
	private String description;
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
