package jdk8newfeatures.streamapidemos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceOperationEx {
	public static void main(String args[]) {
		List<Integer>list1=new ArrayList<>();	
	    list1.add(2);
	    list1.add(5);
	    list1.add(1);
	
	    Stream<Integer>stream1=list1.stream();
	    BinaryOperator<Integer>binaryOp=(len1,len2)->len1+len2;
	    Optional<Integer>optional=stream1.reduce(binaryOp);
	    if(optional.isPresent()) {
	       int total=optional.get();
	       System.out.println("total length="+total);
	    }
	}
}
