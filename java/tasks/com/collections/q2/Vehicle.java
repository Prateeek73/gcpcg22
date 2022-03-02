package com.collections.q2;

public class Vehicle implements Comparable<Vehicle>{
	public String name;
	public double price;
	public Vehicle(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int compareTo(Vehicle o) {
		// TODO Auto-generated method stub
		return Double.valueOf(this.price.compareTo(o.price));
	}
}
