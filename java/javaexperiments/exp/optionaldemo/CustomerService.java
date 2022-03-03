package exp.optionaldemo;

import java.util.Collection;
import java.util.Optional;

public class CustomerService {

    Optional<Customer> findYoungestCustomer(Collection<Customer> customers) {
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


}
