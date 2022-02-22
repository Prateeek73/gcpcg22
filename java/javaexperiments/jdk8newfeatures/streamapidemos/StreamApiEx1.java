package jdk8newfeatures.streamapidemos;

import java.util.*;

/**
 * find sum of total length of all even strings
 * 
 * @author vineet
 *
 */
public class StreamApiEx1 {

	public static void main(String args[]) {
		List<String> list = new ArrayList<>();
		list.add("hello");
		list.add("hi");
		list.add("good");
		StreamApiEx1 demo = new StreamApiEx1();
		int result1 = demo.imperativeWay(list);
		int result2 = demo.declarativeWay(list);
		System.out.println("result1=" + result1);
		System.out.println("result2=" + result2);
		System.out.println("list=" + list);
	}

	public int imperativeWay(List<String> list) {
		int total = 0;
		for (String str : list) {
			int len = str.length();
			if (len % 2 == 0) {
				total = total + len;
			}
		}
		return total;
	}

	public int declarativeWay(List<String> list) {
		Optional<Integer> optional = list.stream().filter(str -> str.length() % 2 == 0).map(str -> str.length())
				.reduce((len1, len2) -> len1 + len2);
		if (optional.isPresent()) {
			int value = optional.get();
			return value;
		}
		return -1;
	}

}
