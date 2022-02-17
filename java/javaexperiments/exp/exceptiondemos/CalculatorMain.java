package exp.exceptiondemos;

public class CalculatorMain{

public static void main(String args[]){
Calculator calcy=new Calculator();
System.out.println("before divide method was called");
double result1=calcy.divide(20,0);
System.out.println("result1="+result1);
System.out.println("bye");
}

}
