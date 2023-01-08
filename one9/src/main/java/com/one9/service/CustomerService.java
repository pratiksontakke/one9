package com.one9.service;


import com.one9.exception.CustomerException;
import com.one9.model.Customers;

public interface CustomerService {

	public Customers createCustomer(Customers customer) throws CustomerException;
	
	public Customers updateCustomer(Customers customer, String key) throws CustomerException;

}
