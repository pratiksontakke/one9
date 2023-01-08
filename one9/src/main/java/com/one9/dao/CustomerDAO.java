package com.one9.dao;


import com.one9.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customers, Integer> {
    public Customers findByMobileNumber(String mobileNo);
}
