package jdk8newfeatures;

import java.util.function.BiFunction;

public class BiFunctionEx {
	public static void main(String args[]) {
		IStringRepeat lambda1= (msg,times)->{
			 String result="";
				for(int i=0;i<times;i++) {
		         result=result+msg;  	 
		     }
		     return result;    
		};
		
		BiFunction<String,Integer,String> lambda2= (msg,times)->{
			 String result="";
				for(int i=0;i<times;i++) {
		         result=result+msg;  	 
		     }
		     return result;    
		};
		
		String msg1=lambda1.add("h1", 2);
		String msg2=lambda2.apply("hello", 2);
	    System.out.println("msg1="+msg1);
	    System.out.println("msg1="+msg2);
	    
	}
}
