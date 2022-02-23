package com.collections.q3;

import java.util.*;
import java.util.Map.Entry;

public class University {
	public List<Student> students;

	public University() {
		super();
		this.students = new ArrayList<>();
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}

	public void giveAward() {
		for (int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			if (student.getScore() >= 85) {
				student.setAward(1000);
			} else if (student.getScore() >= 75) {
				student.setAward(500);
			} else if (student.getScore() < 60) {
				student.setAward(0);
			} else {

			}
		}
	}

	public double totalMoneyDistributed() throws StudentNotFoundException{
		// double sum = 0;
		// for (Student student : students) {
		// 	sum += student.getAward();
		// }
		// return sum;

		double sum  = students.stream()
								.mapToDouble(student -> student.getAward())
								.sum();
		return sum;
	}

	public String findDeparmentWithHighestTotalAward() throws DepartmentNotFoundException{
		HashMap<String, Double> department_award = new HashMap<>();
		for (Student student : students) {
			department_award.put(student.getName(), department_award.getOrDefault(student.getName(), (double) 0) + student.getAward());
		}

		// String max_department = "";
		// double max_award = Double.MIN_VALUE;
		// for(Entry<String, Double> entry : department_award.entrySet()) {
		// 	if(entry.getValue() > max_award) {
		// 		max_award = entry.getValue();
		// 		max_department = entry.getKey();
		// 	}
		// }
		// return max_department;

		Comparator<Entry<String, Double>> comparator = (o1, o2) -> o1.getValue().compareTo(o2.getValue());


		Optional<Entry<String, Double>> entrySet = department_award.entrySet()
														.stream()
														.max(comparator);
		if(entrySet.isPresent()){
			return entrySet.get().getKey();
		}
		else{
			throw new DepartmentNotFoundException("Department not found");
		}

	}

}
