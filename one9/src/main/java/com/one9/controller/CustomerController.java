package com.one9.controller;


import com.one9.exception.CustomerException;
import com.one9.model.Customers;
import com.one9.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService cService;
    @PostMapping("/customers")
    public ResponseEntity<Customers> saveCustomer(@Valid @RequestBody Customers customer) throws CustomerException {
        Customers savedCustomer= cService.createCustomer(customer);
        return new ResponseEntity<Customers>(savedCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/customers")
    public  ResponseEntity<Customers> updateCustomer(@Valid @RequestBody Customers customer, @Valid @RequestParam String key ) throws CustomerException {
        Customers updatedCustomer= cService.updateCustomer(customer, key);
        return new ResponseEntity<Customers>(updatedCustomer,HttpStatus.ACCEPTED);
    }

}

