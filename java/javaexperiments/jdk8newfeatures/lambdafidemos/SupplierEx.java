package jdk8newfeatures.lambdafidemos;

import java.util.function.Supplier;

public class SupplierEx {

	public static void main(String args[]) {
		IGreet anonymousInstance=new IGreet() {

			@Override
			public String greet() {
				System.out.println("inside greet anoymous");
				return "Welcome anonymous";
			}
			
		};
		
		
		IGreet lambdaExp=()->"Welcome lambda expression";
		IGreet lambdaBlock=()->{
	     System.out.println("inside lambda block"); 		
	     return "Welcome";		
		};
		
		String msg1=anonymousInstance.greet();
		String msg2=lambdaExp.greet();
		String msg3=lambdaBlock.greet();
		System.out.println("msg1="+msg1);
		System.out.println("msg2="+msg2);
		System.out.println("msg3="+msg3);
		
		Supplier<String> lambdaExp2=()->"Welcome2";
		String msg4=lambdaExp2.get();
		System.out.println("msg4="+msg4);
		
	}
}
