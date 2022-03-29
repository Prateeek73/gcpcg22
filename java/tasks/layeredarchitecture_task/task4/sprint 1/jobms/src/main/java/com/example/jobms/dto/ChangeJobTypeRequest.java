package com.example.jobms.dto;

public class ChangeJobTypeRequest {
	private long id;
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
