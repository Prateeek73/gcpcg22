package exp.genericdemo;

public class StoreMain{

public static void main(String args[]){
Store<String> store=new Store<>();
store.add("hi");
String found=store.getElement();
System.out.println("found="+found);
}

}
