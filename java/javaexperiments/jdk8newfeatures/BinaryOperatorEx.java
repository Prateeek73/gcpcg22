package jdk8newfeatures;

import java.util.function.BinaryOperator;

public class BinaryOperatorEx {
	public static void main(String args[]) {
		IAdd lambda1=(num1,num2)->num1+num2;
		BinaryOperator<Integer> lambda2=(num1, num2)->num1+num2;
	    int result1=lambda1.add(4, 5);
	    int result2=lambda2.apply(7, 8);
	    System.out.println("result1="+result1);
	    System.out.println("result2="+result2);
	}
}
