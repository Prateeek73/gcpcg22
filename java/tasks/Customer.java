class Customer{
    long id;
    String name;
    double balance;

    Customer(){
        this.id = 0;
        this.name = "";
        this.balance = 0.0;
    }

    Customer(long id, String name, double balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    boolean isCustomerImportant(){
        return this.balance>10000;
    }
    public void addToBalance(double value){
        this.balance +=value;
    }
}