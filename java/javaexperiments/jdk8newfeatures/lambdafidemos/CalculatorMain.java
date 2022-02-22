package jdk8newfeatures.lambdafidemos;

public class CalculatorMain {

	public static void main(String args[]) {
		ICalculator calcy1=new ICalculator() {
			@Override
			public double sub(double num1, double num2) {
			  return num1-num2;
			}			
		};
		
		
		
	}
}
