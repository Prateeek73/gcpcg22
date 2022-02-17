package exp.exceptiondemos;

public class Calculator{


  int divide(int num1, int num2){
  try{
  int result=num1/num2;
  System.out.println("result calculated in divide()");
  return result;
  }
  
  
  catch(ArithmeticException ex){
  String exMsg=ex.getMessage();
  System.out.println("handling arithmetic exception "+exMsg);
  ex.printStackTrace(); 
   return -1;
  }
  
   catch(Exception ex){
  String exMsg=ex.getMessage();
  System.out.println("something went wrong "+exMsg);
  ex.printStackTrace(); 
   return -1;
  }
  
 
  }
  
}
