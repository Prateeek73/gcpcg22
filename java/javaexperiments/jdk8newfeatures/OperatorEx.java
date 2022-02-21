package jdk8newfeatures;

import java.util.function.UnaryOperator;

public class OperatorEx {
	public static void main(String args[]) {
	ISquare lambda1=(num)->num*num;
	UnaryOperator<Integer>lambda2=(num)->num*num;
	int result1=lambda1.square(5);
	int result2=lambda2.apply(5);
	System.out.println("result1="+result1);
	System.out.println("resut2="+result2);
	
	}
}
