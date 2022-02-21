package com.collections.q2;

import java.util.*;

public class VehicleMain {
	
	public static void main(String args[]){
		List<Vehicle>list=new ArrayList<>();
		//add vehicles in list here
		list.add(new Vehicle("Supra", 43190.00));
		list.add(new Vehicle("Bentley", 430554.73 ));
		list.add(new Vehicle("GTR3", 83190.60));
		list.add(new Vehicle("Lambo", 93744.00));

		VehicleService service=new VehicleService();

		double avgCost=service.averageCost(list);
		System.out.println(avgCost);

		List<String> ascendingNames = service.fetchVehiclesNameByPriceInAscendingOrder(list);
		System.out.println(ascendingNames);

		List<String> descendingNames = service.fetchVehiclesNameByPriceInDescendingOrder(list);
		System.out.println(descendingNames);

		String vehicleName=service.minimumPrice(list);
		System.out.println(vehicleName);
	}

}
