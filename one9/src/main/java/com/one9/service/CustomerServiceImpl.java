package com.one9.service;


import com.one9.dao.CustomerDAO;
import com.one9.dao.SessionDAO;
import com.one9.exception.CustomerException;
import com.one9.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO cDao;

    @Autowired
    private SessionDAO sDao;


    @Override
    public Customer createCustomer(Customer customer) throws CustomerException {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer, String key) throws CustomerException {
        return null;
    }
}


