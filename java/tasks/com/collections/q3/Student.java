package com.collections.q3;

public class Student {
	public String name;
	public String department;
	public float award;
	public float score;

	public Student(String name, String department, float award, float score) {
		this.name = name;
		this.department = department;
		this.award = award;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAward() {
		return (int) award;
	}

	public void setAward(float award) {
		this.award = award;
	}

	public int getScore() {
		return (int) score;
	}

	public void setScore(float score) {
		this.score = score;
	}

}
