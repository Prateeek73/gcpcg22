package com.frontend;

import java.util.List;

import com.entity.Customer;
import com.exceptions.IdNotFoundException;
import com.exceptions.InvalidBalanceException;
import com.exceptions.InvalidNameException;
import com.service.CustomerServiceImp;
import com.service.ICustomerService;

public class FrontEnd {
	private ICustomerService service = new CustomerServiceImp();
	public void runUI() {
		try {
				// adding customers
			 	System.out.println("***Adding customers***");
		        service.addCustomer("Toby", "Maggie", 34000);
		        service.addCustomer("Bandrew", "Garfield", 27000);
		        service.addCustomer("Bomb", "Holland", 10000);
		        
		        // finding customers
		        System.out.println("***Displaying customers***");
		        Customer customer = service.findById(2);
		        System.out.println(customer.toString());
		        
		        // finding customers by first name
		        System.out.println("***Displaying customers by first name***");
		        List<Customer> list = service.findCustomersByFirstName("Toby");
		        for(Customer c : list)
		        	System.out.println(c.toString());
		        
		        // debit from balance for customers 
		        System.out.println("***Debit method***");
//		        System.out.println("Before : " + customer.toString());
		        customer = service.debit(3, 20);
		        System.out.println("After : " + customer.toString());
		        
		} catch(IdNotFoundException ex) {
			System.err.print(ex.getMessage());
		} catch(InvalidNameException ex) {
			System.err.print(ex.getMessage());
		} catch(InvalidBalanceException ex) {
			System.err.print(ex.getMessage());
		} catch(Exception ex) {
			System.err.print(ex.getMessage());
		} 
	}
}
