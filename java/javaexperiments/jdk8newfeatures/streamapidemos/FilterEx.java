package jdk8newfeatures.streamapidemos;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * 
 * find count of all even strings
 * 
 */
public class FilterEx {
	public static void main(String args[]) {
		List<String> list = new ArrayList<>();
		list.add("hello");
		list.add("hi");
		list.add("good");
		Stream<String> stream1 = list.stream();
		Predicate<String> predicate = str -> {
			System.out.println("inside predicate");
			return str.length() % 2 == 0;
		};
		Stream<String> stream2 = stream1.filter(predicate);
		long elementsCount1 = stream2.count();
		System.out.println("element remaining=" + elementsCount1);

		// one statement
		long elementsCount2 = list.stream().filter(predicate).count();
		System.out.println("element remaining=" + elementsCount2);

	}
}
