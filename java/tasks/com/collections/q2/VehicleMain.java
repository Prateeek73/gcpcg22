package com.collections.q2;

import java.util.*;

public class VehicleMain {
	public static void main(String args[]) throws Exception{
		List<Vehicle> vehicles=new ArrayList<>();
		//add vehicles in list here
		vehicles.add(new Vehicle("Supra", 43190.00));
		vehicles.add(new Vehicle("Bentley", 430554.73 ));
		vehicles.add(new Vehicle("GTR3", 83190.60));
		vehicles.add(new Vehicle("Lambs", 93744.00));
		VehicleService service=new VehicleService();
		double avgCost=service.averageCost(vehicles);
		System.out.println(avgCost);
		List<String> ascendingNames = service.fetchVehiclesNameByPriceInAscendingOrder(vehicles);
		System.out.println(ascendingNames);
		List<String> descendingNames = service.fetchVehiclesNameByPriceInDescendingOrder(vehicles);
		System.out.println(descendingNames);
		String vehicleName = service.minimumPrice(vehicles);
		System.out.println(vehicleName);
	}
}
