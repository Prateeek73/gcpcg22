package jdk8newfeatures.streamapidemos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorEx {
	public static void main(String args[]) {
		List<String> list1 = new ArrayList<>();
		list1.add("hello");
		list1.add("hi");
		list1.add("good");

	    //descending
	   Stream<String>stream1 =list1.stream();
	   Set<String>set=stream1.collect(Collectors.toSet());
	   System.out.println("set="+set);
	   
	   Stream<String>stream2 =list1.stream();
	   List<String>list2=stream2.collect(Collectors.toList()); 
	   System.out.println("list2="+list2);
	   
	   
	}
}
