package jdk8newfeatures.streamapidemos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class SortOperationEx {
	public static void main(String args[]) {
		List<String>list=new ArrayList<>();	
	    list.add("hello");
	    list.add("hi");
	    list.add("good");
      
	    //descending
	   Stream<String>stream1 =list.stream();
	   Comparator<String>comparator=(str1,str2)->str2.compareTo(str1);
	   Stream<String>stream2=stream1.sorted(comparator);
       Consumer<String>consumer=System.out::println;
	   stream2.forEach(consumer);   
	
	   System.out.println("**done with one statement");
	   //one statement, ascending
	   list.stream()
	   .sorted((str1,str2)->str1.compareTo(str2))
	   .forEach(System.out::println);
	   
	}
}
