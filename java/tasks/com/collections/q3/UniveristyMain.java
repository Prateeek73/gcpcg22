package com.collections.q3;

public class UniveristyMain {

	public static void main(String args[]) {

		University university = new University();
		// add students in university here
		
		university.addStudent(new Student("Prarit Kumar", "IT-B", 0.0f, 72f));
		university.addStudent(new Student("Prerna Tyagi", "IT-B", 0.0f, 94f));
		university.addStudent(new Student("Smoooth Criminal", "IT-A", 0.0f, 75f));
		university.addStudent(new Student("Jackie Chainsmoker", "CSE", 0.0f, 99f));

		university.giveAward();
		double distuributed = university.totalMoneyDistributed();
		System.out.println(distuributed);
		String department = university.findDeparmentWithHighestTotalAward();
		System.out.println(department);

	}

}