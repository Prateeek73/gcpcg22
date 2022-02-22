package jdk8newfeatures.lambdafidemos;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BiPredicateEx {
	public static void main(String args[]) {
		ISumEven lambda1=(num1,num2)->(num1+num2)%2==0;
		BiPredicate<Integer,Integer>lambda2=(num1,num2)->(num1+num2)%2==0;
		boolean result1=lambda1.isEven(8,9);
		boolean result2=lambda2.test(10,2);
		System.out.println("result1="+result1);
		System.out.println("result2="+result2);
		}
}
