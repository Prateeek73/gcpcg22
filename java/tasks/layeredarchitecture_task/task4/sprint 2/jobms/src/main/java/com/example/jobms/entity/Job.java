package com.example.jobms.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.jobms.constants.JobType;

@Table(name = "jobms")
@Entity
public class Job {
	@GeneratedValue
	@Id
	private long id;
	@Column(name = "description")
	private String description;
	@Column(name = "jobType")
	private JobType jobType;

	public Job() {
	}

	public Job(long id, String description, JobType jobType) {
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

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", description=" + description + ", jobType=" + jobType + "]";
	}

}
