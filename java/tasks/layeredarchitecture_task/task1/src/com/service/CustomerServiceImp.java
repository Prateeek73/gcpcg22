package com.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.dao.ICustomerDAO;
import com.dao.CustomerDAOImpl;
import com.entity.Customer;
import com.exceptions.IdNotFoundException;
import com.exceptions.InvalidBalanceException;
import com.exceptions.InvalidNameException;

public class CustomerServiceImp implements ICustomerService {
	
	private ICustomerDAO dao = new CustomerDAOImpl();
	private static long generateId = 0;
	
	long generateId(){
		return ++generateId;
	}
	
	@Override
	public void addCustomer(String firstName, String lastName, double balance) throws InvalidNameException, InvalidBalanceException{
		Validation.validateName(firstName);
		Validation.validateName(lastName);
		Validation.validateBalance(balance);
		Customer customer = new Customer(generateId(), firstName, lastName, balance);
		dao.addCustomer(customer);
	}

	@Override
	public Customer findById(long id) throws IdNotFoundException {
		return dao.findById(id);
	}

	@Override
	public List<Customer> findCustomersByFirstName(String firstname) {
		List<Customer> fetched_customers = new ArrayList<>();
		for(Customer customer : dao.findAll()) 
			if(customer.getFirstName().equals(firstname))
				fetched_customers.add(customer);
		return fetched_customers;
	}

	@Override
	public Customer debit(long customerId, double value) throws IdNotFoundException {
		Customer customer = dao.findById(customerId);
		customer.setBalance(customer.getBalance() - value);
		return customer;
	}
	
//	public Customer updateCustomer(Customer customer) {
//		Collection<Customer> store = dao.store;
//		Customer q_customer = store.get(customer.getId());
//		store.put(customer.getId(), customer);
//		return q_customer;
//	}

}
