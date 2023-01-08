package com.one9.service;

import com.one9.model.Products;

import java.util.List;

public interface ProductService {
    public Products addProduct(Products product);

    public Products updateProducts(Products product);

    public Products deleteProducts(Products product);

    public Products getProducts(Integer cid);

    public List<Products> getAllProducts();

}
