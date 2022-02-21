package com.collections.q1;

import java.util.*;

public class ServiceMain {
	public static void main(String[] args) {
		
		Service service = new Service();
		
		ArrayList<Integer> list = service.makeArrayListInt(10);
		System.out.println(list);
		
		service.reverseList(list);
		System.out.println(list);
		
		service.changeList(list, 0, 5);
		System.out.println(list);
	}

}
