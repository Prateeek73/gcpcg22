package com.entity;

public class Customer extends Object{
	private long id;
	private String firstName;
	private String lastName;
	private double balance;

	public Customer(long id, String firstName, String lastName, double balance) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Customer [id="+id+", firstName="+firstName+", lastName="+lastName+", balance="+balance+"]";
	}
}
