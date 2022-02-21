package jdk8newfeatures;

import java.util.function.*;

public class MethodRefEx {

	public static void main(String args[]) {
		Calculator calcy = new Calculator();
		BinaryOperator<Integer> operator1 =calcy::add;
		int result1=operator1.apply(3, 5);
	    System.out.println("result1="+result1);   
	
	}
}
