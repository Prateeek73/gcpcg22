package exp.interfacedemo;

public class CasioCalculator implements ICalculator{

@Override
public double add(double num1, double num2){
double result=num1+num2;
return result;
}

@Override
public double sub(double num1, double num2){
double result=num1-num2;
return result;
}

}



