package exp;

public class Calculator {

    private Adder adder;

    public Adder getAdder(){
        return adder;
    }

    public void setAdder(Adder adder){
        this.adder=adder;
    }

    public int add(int num1, int num2){
        System.out.println("inside add of Calculator");
        int result=adder.sum(num1,num2);
        return result;
    }

    public int addBy10(int num){
        System.out.println("inside addby10");
        int result=add(num,10);
        return result;
    }

    public boolean isEven(int num){
        return num%2==0;
    }

}
