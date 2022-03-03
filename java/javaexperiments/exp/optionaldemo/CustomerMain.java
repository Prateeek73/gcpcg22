package exp.optionaldemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerMain {

    public static void main(String args[]) {
        Customer customer1 = new Customer(1, "amit", 21);
        Customer customer2 = new Customer(2, "akshay", 20);
        List<Customer> list = new ArrayList<Customer>();
        list.add(customer1);
        list.add(customer2);
        CustomerService service = new CustomerService();
        Optional<Customer> optional = service.findYoungestCustomer(list);
        if (optional.isPresent()) {
            Customer customer = optional.get();
            System.out.println(customer.getId() + " " + customer.getName() + " " + customer.getAge());
        } else {
            System.out.println("youngest customer not found");
        }
    }
}
