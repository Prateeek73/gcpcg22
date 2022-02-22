package jdk8newfeatures.lambdafidemos;

import java.util.function.Function;

public class FunctionEx1 {

	public static void main(String args[]) {
		IStringLength lambda1=(msg)->msg.length();
		Function<String, Integer>lambda2=(msg)->msg.length();
		int len1=lambda1.length("hello");
		int len2=lambda2.apply("welcome");
	    System.out.println("len1="+len1);
	    System.out.println("len2="+len2);
	}
}
