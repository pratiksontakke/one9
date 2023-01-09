package com.one9.service;


import com.one9.dao.CustomerDAO;
import com.one9.dao.SessionDAO;
import com.one9.exception.CustomerException;
import com.one9.model.CurrentUserSession;
import com.one9.model.Customers;
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
    public Customers createCustomer(Customers customer) throws CustomerException {
        Customers existingCustomer = cDao.findByMobileNumber(customer.getMobileNumber());
        if (existingCustomer != null)
            throw new CustomerException("Customer Already Registered with Mobile number");
        return cDao.save(customer);
    }

    @Override
    public Customers updateCustomer(Customers customer, String key) throws CustomerException {
        CurrentUserSession loggedInUser = sDao.findByUuid(key);
        if (loggedInUser == null) {
            throw new CustomerException("Please provide a valid key to update a customer");
        } else {
            Customers customer1 = cDao.findByMobileNumber(loggedInUser.getUserId());
            if (Objects.equals(customer1.getCustomerID(), customer.getCustomerID())) {
                customer1.setFirstName(customer.getFirstName());
                customer1.setLastName(customer.getLastName());
                customer1.setBirthDate(customer.getBirthDate());
                customer1.setAddress(customer.getAddress());
                customer1.setCity(customer.getCity());
                customer1.setPostalCode(customer.getPostalCode());
                customer1.setCountry(customer.getCountry());
                customer1.setMobileNumber(customer.getMobileNumber());
                customer1.setPassword(customer.getPassword());
                customer1.setEmail(customer.getEmail());

                loggedInUser.setUserId(customer.getMobileNumber());
                return cDao.save(customer1);
            } else {
                throw new CustomerException("Invalid Customer Details, please login first");
            }
        }
    }
}


