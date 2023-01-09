package com.one9.service;

import com.one9.exception.LoginException;
import com.one9.exception.ProductException;
import com.one9.model.Products;

import java.util.List;

public interface ProductService {
    public Products addProduct(Products product, String key) throws ProductException, LoginException;

    public Products updateProducts(Products product, String key) throws ProductException, LoginException;

    public Products deleteProducts(Integer id, String key) throws ProductException, LoginException;

    public Products getProduct(Integer id, String key) throws ProductException, LoginException;

    public List<Products> getAllProducts(String key) throws ProductException, LoginException;

}
