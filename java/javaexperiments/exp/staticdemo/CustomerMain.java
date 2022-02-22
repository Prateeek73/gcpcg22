package exp.staticdemo;

public class CustomerMain{

public static void main(String args[]){

CustomerMain demo=new CustomerMain();
demo.start();

}
 void start(){
Customer customer1=new Customer(1, "aman");
Customer customer2=new Customer(2, "amit");
int count=Customer.getCount();
System.out.println("count="+count);

}



}
