package com.collections.q2;

import java.util.*;
import java.util.stream.Collectors;

public class VehicleService {
	double averageCost(List<Vehicle> list){
		BinaryOperator<Double> operation = (a,b) -> a+b;
		Optional<Double> value = list.stream()
                    .map(veh -> veh.getPrice())
                    .reduce(operation);
		if(value.isPresent()){
			return value.get() / list.size();
		}
		return 0;
	}
	List<String> fetchVehiclesNameByPriceInAscendingOrder(List<Vehicle> list){
		List<String> vehicleNameList = list.stream()
			.sorted(getAscendingComparator())
			.map(veh -> veh.getName())
			.collect(Collectors.toList());					
		return vehicleNameList;
	}
	List<String> fetchVehiclesNameByPriceInDescendingOrder(List<Vehicle> list) throws VehicleNotFoundException{
		List<String> vehicleNameList = list.stream()
			.sorted(getDescendingComparator())
			.map(veh -> veh.name)
			.collect(Collectors.toList());					
		return vehicleNameList;
	}
	public Comparator<Vehicle> getAscendingComparator(){
		Comparator<Vehicle> comparator = (veh1, veh2) -> Double.valueOf(veh1.getPrice()).compareTo(veh2.getPrice());
		return comparator;
	}
	public Comparator<Vehicle> getDescendingComparator(){
		Comparator<Vehicle> comparator = (veh1, veh2) -> (int) (veh2.getPrice() - veh1.getPrice());
		return comparator;
	}
	public String minimumPrice(List<Vehicle> list) throws VehicleNotFoundException{
		Optional<Vehicle> optional = list.stream()
			.min(getAscendingComparator())
		if(optional.isPresent()){
			return optional.get().getName();
		}
		throw new VehicleNotFoundException("Vehicle Not Found");
	}
}
