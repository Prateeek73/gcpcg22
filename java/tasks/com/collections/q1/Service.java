package com.collections.q1;

import java.util.*;

public class Service {

	List<Integer> list;

	public Service() {
		this.list = new ArrayList<>();
	}

	public ArrayList<Integer> makeArrayListInt(int n) {
		for (int i = 0; i < n; i++)
			this.list.add(0);
		return (ArrayList<Integer>) this.list;
	}

	public ArrayList<Integer> reverseList(ArrayList<Integer> list) {
		Collections.reverse(this.list);
		return (ArrayList<Integer>) this.list;
	}

	public ArrayList<Integer> changeList(ArrayList<Integer> list, int m, int n) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == m) {
				list.set(i, n);
			}
		}
		return (ArrayList<Integer>) this.list;
	}
}
