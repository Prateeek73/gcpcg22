package com.collections.q2;

import java.util.*;

public class VehicleService {
	
	
	double averageCost(List<Vehicle> list){
		double sum = 0;
		for(Vehicle vehicle : list) {
			sum += vehicle.getPrice();
		}
		return sum / list.size();
	}
	
	List<String> fetchVehiclesNameByPriceInAscendingOrder(List<Vehicle> list){
		Collections.sort(list);
		List<String> vehicleNameList= new ArrayList<>();
		for(Vehicle vehicle : list) {
			vehicleNameList.add(vehicle.getName());
		}
		return vehicleNameList;
	}

	List<String> fetchVehiclesNameByPriceInDescendingOrder(List<Vehicle> list){
		Collections.sort(list, Collections.reverseOrder());
		List<String> vehicleNameList= new ArrayList<>();
		for(Vehicle vehicle : list) {
			vehicleNameList.add(vehicle.getName());
		}
		return vehicleNameList;
	}
	
	public String minimumPrice(List<Vehicle> list){
		double minPrice = Double.MAX_VALUE;
		String minName = "";
		for(Vehicle vehicle : list) {
			if(vehicle.getPrice() < minPrice) {
				minPrice = vehicle.getPrice();
				minName = vehicle.getName();
			}
		}
		return minName;
	}
}
