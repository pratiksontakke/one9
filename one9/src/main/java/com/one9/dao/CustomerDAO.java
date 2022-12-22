package com.one9.dao;


import com.one9.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    public Customer findByMobileNumber(String mobileNo);
}
