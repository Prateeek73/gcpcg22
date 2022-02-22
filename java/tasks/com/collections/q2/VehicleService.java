package com.collections.q2;

import java.util.*;
import java.util.stream.Collectors;

public class VehicleService {
	
	
	double averageCost(List<Vehicle> list){
		double sum = list.stream()
                    .mapToDouble(veh -> veh.getPrice())
                    .sum();
		
		return sum / list.size();
	}
	
	List<String> fetchVehiclesNameByPriceInAscendingOrder(List<Vehicle> list){
		Comparator<Vehicle> comparator = (veh1, veh2) -> (int) (veh1.getPrice() - veh2.getPrice());

		List<String> vehicleNameList = list.stream()
								.sorted(comparator)
								.map(veh -> veh.getName())
								.collect(Collectors.toList());
								
		return vehicleNameList;
	}

	List<String> fetchVehiclesNameByPriceInDescendingOrder(List<Vehicle> list) throws VehicleNotFoundException{
		Comparator<Vehicle> comparator = (veh1, veh2) -> (int) (veh2.getPrice() - veh1.getPrice());

		List<String> vehicleNameList = list.stream()
										.sorted(comparator)
										.map(veh -> veh.name)
										.collect(Collectors.toList());
								
		return vehicleNameList;
	}
	
	public String minimumPrice(List<Vehicle> list) throws VehicleNotFoundException{
		Comparator<Vehicle> comparator = (veh1, veh2) -> (int) (veh1.getPrice() - veh2.getPrice());

		Optional<Vehicle> optional = list.stream()
										.min(comparator);
		if(optional.isPresent()){
			return optional.get().getName();
		}
		else{
			throw new VehicleNotFoundException("Vehicle Not Found");
		}
	}
}
