package jdk8newfeatures.streamapidemos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MiscellaneousEx1 {
	public static void main(String args[]) {
		List<String>list1=new ArrayList<>();	
	    list1.add("hello");
	    list1.add("hi");
	    list1.add("good");
	    list1.add("bad");
	    System.out.println("**limit operation below");
	    //limit number of elements
	   Stream<String>stream2 =list1.stream()
	    .limit(2);
	     stream2.forEach(System.out::println); 
	    System.out.println("***skip operation below");
	     //skip elements
	     Stream<String>stream3 =list1.stream()
	    		    .skip(2);
	    		     stream3.forEach(System.out::println); 
	    		     
	   		     
	    		
	}
}
