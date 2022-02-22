package jdk8newfeatures.lambdafidemos;

import java.util.function.Predicate;

public class PredicateEx {
	public static void main(String args[]) {
	IEven lambda1=(num)->num%2==0;
	Predicate<Integer>lambda2=(num)->num%2==0;
	boolean result1=lambda1.isEven(8);
	boolean result2=lambda2.test(10);
	System.out.println("result1="+result1);
	System.out.println("result2="+result2);
	}
}
