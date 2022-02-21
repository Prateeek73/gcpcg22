package jdk8newfeatures;

import java.util.function.BiConsumer;

public class BiConsumerEx {

	public static void main(String[] args) {
		IPrintAdd lambda1=(msg, times)->{
	     String result="";
			for(int i=0;i<times;i++) {
	         result=result+msg;  	 
	     }
			System.out.println("result1="+result);
		};
		
        BiConsumer<String, Integer>lambda2= (msg, times)->{
   	     String result="";
   			for(int i=0;i<times;i++) {
   	         result=result+msg;  	 
   	     }
			System.out.println("result2="+result);

   		};

   		lambda1.add("hello", 3);
   		lambda2.accept("hi",4);
	}

}