package interfacedemo;

public class CalculatorMain{

public static void main(String args[]){
ICalculator calcy=new IBMCalculator();
double result1=calcy.add(1,2);
System.out.println(result1);
}


}
