package com.service;

import com.entity.Customer;
import com.exceptions.IdNotFoundException;
import com.exceptions.InvalidBalanceException;
import com.exceptions.InvalidNameException;

import java.util.List;

public interface ICustomerService {
	
	void addCustomer(String firstName, String lastName, double balance) throws InvalidNameException, InvalidBalanceException;
	
	Customer findById(long id) throws IdNotFoundException;
	
	List<Customer> findCustomersByFirstName(String firstname);
	
	Customer debit(long customerId, double value) throws IdNotFoundException;
}
