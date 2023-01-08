package com.one9.service;

import com.one9.exception.ProductException;
import com.one9.model.Products;

import java.util.List;

public interface ProductService {
    public Products addProduct(Products product) throws ProductException;

    public Products updateProducts(Products product) throws ProductException;

    public Products deleteProducts(Products product) throws ProductException;

    public Products getProduct(Integer id) throws ProductException;

    public List<Products> getAllProducts() throws ProductException;

}
