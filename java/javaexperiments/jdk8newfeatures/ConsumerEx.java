package jdk8newfeatures;

import java.util.function.Consumer;

public class ConsumerEx {

	public static void main(String args[]) {
	IPrint print1=(msg)->System.out.println(msg);
	IPrint print2=(msg)->{
		System.out.println(msg);
	   };
	Consumer<String>print3=(msg)->System.out.println(msg); 
	print1.print("hello1");
	print2.print("hello2");
	print3.accept("hello3");
	}
}
