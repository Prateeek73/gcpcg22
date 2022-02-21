package jdk8newfeatures;

@FunctionalInterface
public interface ICalculator {

	default double add(double num1, double num2) {
		return num1+num2;
	}
	
	 double sub(double num1, double num2) ;
}
