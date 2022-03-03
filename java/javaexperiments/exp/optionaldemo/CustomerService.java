package exp.optionaldemo;

import java.util.*;

public class CustomerService {

    Optional<Customer> findYoungestCustomerWay1(Collection<Customer> customers) {
        int minAge = Integer.MAX_VALUE;
        if (customers.isEmpty()) {
            Optional<Customer> optional = Optional.empty();
            return optional;
        }
        Customer found = null;
        for (Customer customer : customers) {
            if (customer.getAge() < minAge) {
                found = customer;
            }
        }
        Optional optional = Optional.of(found);
        return optional;
    }

    Optional<Customer> findYoungestCustomerWay2(Collection<Customer> customers) {
        if (customers.isEmpty()) {
            Optional<Customer> optional = Optional.empty();
            return optional;
        }
        List<Customer> list=new ArrayList<>();
        list.addAll(customers);
        Comparator<Customer>comparator=new AgeComparator();
        list.sort(comparator);
        Customer youngest= list.get(0);
        return Optional.of(youngest);
    }

}

class AgeComparator implements Comparator<Customer>{
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getAge()-o2.getAge();
    }
}


