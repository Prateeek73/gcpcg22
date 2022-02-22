package jdk8newfeatures.lambdafidemos;

import java.util.Comparator;
import java.util.function.*;

public class MethodRefEx {

	public static void main(String args[]) {
		Calculator calcy = new Calculator();
		BinaryOperator<Integer> operator1 =calcy::add;
		int result1=operator1.apply(3, 5);
	    System.out.println("result1="+result1);
	    BinaryOperator<Integer>operator2=Calculator::sum;
	    int result2=operator2.apply(5, 7);
	    System.out.println("result2="+result2);
	    Consumer<String>print1=System.out::println;
	    print1.accept("hello");
	    BiFunction<Integer,Integer,Integer> bifun1=Integer::compare;
	    int compare1=bifun1.apply(3, 4);
	    System.out.println("compare1="+compare1);
        BinaryOperator<Integer>biop1=Integer::compare;
        int compare2=biop1.apply(7, 8);
	    System.out.println("compare2="+compare2);

        Comparator<Integer> comparator1=Integer::compare;
        MethodRefEx demo=new MethodRefEx();
        BinaryOperator<Integer>operator3=demo::add;
        int result5=operator3.apply(6, 7);     
	    System.out.println("result5="+result5); 
	    
	}
	
	public int add(int num1, int num2) {
		return num1+num2;
	}
	
}
