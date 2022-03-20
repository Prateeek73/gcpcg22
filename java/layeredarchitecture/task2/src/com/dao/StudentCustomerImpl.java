package com.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.Customer;
import com.exceptions.IdNotFoundException;

public class StudentCustomerImpl implements ICustomerDAO{
    
	private Map<Long, Customer> store=new HashMap<>();

	@Override
	public void addCustomer(Customer customer) {
		store.put(customer.getId(), customer);
	}

	@Override
	public Customer findById(long id) throws IdNotFoundException {
		Customer customer = store.get(id);
		if(customer == null)
			throw new IdNotFoundException("ID not found");
	    return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer q_customer = store.get(customer.getId());
		store.put(customer.getId(), customer);
		return q_customer;
	}

	@Override
	public List<Customer> findAll() {
		Collection<Customer> values=  store.values();
	    List<Customer> list=new ArrayList<>();
	    list.addAll(values);
	    return list;
	}

}
