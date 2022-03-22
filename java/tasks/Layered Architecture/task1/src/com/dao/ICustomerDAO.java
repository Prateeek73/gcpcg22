package com.dao;

import com.entity.Customer;
import com.exceptions.IdNotFoundException;

import java.util.List;

public interface ICustomerDAO {
	
	void addCustomer(Customer customer);
	
	Customer findById(long id) throws IdNotFoundException;
	
	Customer updateCustomer(Customer customer) throws IdNotFoundException;
    
	List<Customer> findAll();
  
}