package com.example.jobms.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ChangeJobTypeRequest {
	@Min(1)
	private long id;
	@NotBlank()
	private String jobType;

	public ChangeJobTypeRequest(long id, String jobType) {
		this.id = id;
		this.jobType = jobType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public ChangeJobTypeRequest() {
	}
}
