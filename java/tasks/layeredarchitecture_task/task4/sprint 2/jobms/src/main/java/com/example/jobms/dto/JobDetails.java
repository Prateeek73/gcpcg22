package com.example.jobms.dto;

public class JobDetails {
	private long id;
	private String description;
	private String jobType;

	public JobDetails() {
	}

	public JobDetails(long id, String description, String jobType) {
		this.id = id;
		this.description = description;
		this.jobType = jobType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "JobDetails [id=" + id + ", description=" + description + ", jobType=" + jobType + "]";
	}

}
