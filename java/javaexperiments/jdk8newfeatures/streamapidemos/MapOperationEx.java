package jdk8newfeatures.streamapidemos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * find all length of string and print them
 * 
 */
public class MapOperationEx {
	public static void main(String args[]) {
		List<String>list=new ArrayList<>();	
	    list.add("hello");
	    list.add("hi");
	    list.add("good");
	   Stream<String>stream1 =list.stream();
	   Function<String,Integer>operation=str->str.length();
	   Stream<Integer>stream2 =stream1.map(operation);
	   Consumer<Integer>consumer=length->System.out.println("length="+length);
	   stream2.forEach(consumer);  
	   
	   //one statement
	   list.stream()
	   .map(operation)
	   .forEach(System.out::println);
	}
}
