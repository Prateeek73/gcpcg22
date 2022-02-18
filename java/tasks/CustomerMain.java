class CustomerMain{
    public static void main(String[] args){
        Customer[] store = new Customer[3];
        Customer customer1 = new Customer(1, "Jessie Pinkman", 200000);
        Customer customer2 = new Customer(2, "Walter White", 200000);
        Customer customer3 = new Customer(3, "Hank Schrader", 5000);

        store[0] = customer1;
        store[1] = customer2;
        store[2] = customer3;

        customer1.addToBalance(10000);
        customer2.addToBalance(10000);
        customer3.addToBalance(500);

        for(int i=0; i<store.length; i++){
            Customer customer = store[i];
            if(customer.isCustomerImportant()){
                System.out.println(customer.id);
                System.out.println(customer.name);
                System.out.println(customer.balance);
            }

        }
    }
}