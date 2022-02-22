package exp.staticdemo;

public class Customer{
static private int count;
private int id;
String name;

public Customer(int id,String name ){
this.id=id;
this.name=name;
++count;
}

public int getId(){
return id;
}

 public static int getCount(){
return count
}


}
