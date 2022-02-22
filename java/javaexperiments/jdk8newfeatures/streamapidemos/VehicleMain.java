package jdk8newfeatures.streamapidemos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VehicleMain {

	public static void main(String args[]) throws Exception{
		List<Vehicle>vehicles=new ArrayList<>();
		Vehicle cycle=new Vehicle("cycle",1000);
		Vehicle bike=new Vehicle("bike",50000);
		Vehicle car=new Vehicle("car",500000);
		Vehicle scooty=new Vehicle("scooty",40000);
		vehicles.add(cycle);
		vehicles.add(bike);
		vehicles.add(car);
		vehicles.add(scooty);
		VehicleService service=new VehicleService();
		String minPriceVehicle=service.minimumPrice(vehicles);
		System.out.println("min price vehicle="+minPriceVehicle);
		List<String>names=service.fetchVehiclesNameByPriceInAscendingOrder(vehicles);
		System.out.println("vehicle="+names);
	}
}

class Vehicle {
	String name;
	double price;

	public Vehicle(String name, double price) {
		this.name = name;
		this.price = price;
	}
}

class VehicleService {

	// find vehicle name with minimum price
	public String minimumPrice(List<Vehicle> list) throws VehicleNotFoundException {
		Comparator<Vehicle> comparator = (veh1, veh2) -> {
			if (veh1.price > veh2.price) {
				return 1;
			}
			if (veh1.price == veh2.price) {
				return 0;
			}
			return -1;
		};
		Optional<Vehicle> optional = list.stream().min(comparator);
		if (optional.isPresent()) {
			Vehicle vehicle = optional.get();
			return vehicle.name;
		}
		throw new VehicleNotFoundException("vehicle not found");
	}

	// find list of name of vehicle in ascecending order of price
	public List<String> fetchVehiclesNameByPriceInAscendingOrder(List<Vehicle> list) {
		Comparator<Vehicle> comparator = (veh1, veh2) -> {
			if (veh1.price > veh2.price) {
				return 1;
			}
			if (veh1.price == veh2.price) {
				return 0;
			}
			return -1;
		};
		List<String> names = list.stream()
				.sorted(comparator)
				.map(veh -> veh.name)
				.collect(Collectors.toList());
		return names;
	}

}

class VehicleNotFoundException extends Exception {
	public VehicleNotFoundException(String msg) {
		super(msg);
	}
}
