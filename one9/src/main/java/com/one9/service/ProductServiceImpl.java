package com.one9.service;

import com.one9.dao.ProductsDAO;
import com.one9.exception.ProductException;
import com.one9.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductsDAO pdao;
    @Override
    public Products addProduct(Products product) throws ProductException {
        return pdao.save(product);
    }

    @Override
    public Products updateProducts(Products product) throws ProductException {
        Optional<Products> products = pdao.findById(product.getProductID());
        if(products.isPresent()) {
            return pdao.save(product);
        } else {
            throw new ProductException("Product not found with id : " + product.getProductID());
        }
    }

    @Override
    public Products deleteProducts(Integer id) throws ProductException {
        Optional<Products> products = pdao.findById(id);
        if(products.isPresent()) {
            pdao.deleteById(id);
            return products.get();
        } else {
            throw new ProductException("Product not found with id : " + id);
        }
    }

    @Override
    public Products getProduct(Integer id) throws ProductException {
        Optional<Products> products = pdao.findById(id);
        if(products.isPresent()) {
            return products.get();
        } else {
            throw new ProductException("Product not found with id : " + id);
        }
    }

    @Override
    public List<Products> getAllProducts() throws ProductException {
        List<Products> products = pdao.findAll();
        if(products.isEmpty()) {
            throw new ProductException("Product list is empty");
        } else {
            return products;
        }
    }
}
