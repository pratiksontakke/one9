package com.one9.service;

import com.one9.exception.ProductException;
import com.one9.model.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Override
    public Products addProduct(Products product) throws ProductException {
        return null;
    }

    @Override
    public Products updateProducts(Products product) throws ProductException {
        return null;
    }

    @Override
    public Products deleteProducts(Products product) throws ProductException {
        return null;
    }

    @Override
    public Products getProduct(Integer id) throws ProductException {
        return null;
    }

    @Override
    public List<Products> getAllProducts() throws ProductException {
        return null;
    }
}
