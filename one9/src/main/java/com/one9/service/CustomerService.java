package com.one9.service;


import com.one9.exception.CustomerException;
import com.one9.model.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer,String key) throws CustomerException;

}
