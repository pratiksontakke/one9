package com.one9.service;

import com.one9.dao.EmployeesDAO;
import com.one9.dao.ProductsDAO;
import com.one9.dao.SessionDAO;
import com.one9.exception.LoginException;
import com.one9.exception.ProductException;
import com.one9.model.CurrentUserSession;
import com.one9.model.Employees;
import com.one9.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductsDAO pdao;

    @Autowired
    EmployeesDAO edao;

    @Autowired
    SessionDAO sdao;

    @Autowired
    LoginService lSer;

    @Override
    public Products addProduct(Products product, String key) throws ProductException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            CurrentUserSession currentUserSession = sdao.findByUuid(key);
            Employees employee = edao.findByMobileNumber(currentUserSession.getUserId());
            employee.getProducts().add(product);
            edao.save(employee);
            return product;
        } else {
            throw new LoginException("Employee not login");
        }
    }

    @Override
    public Products updateProducts(Products product, String key) throws ProductException, LoginException {
        Optional<Products> products = pdao.findById(product.getProductID());
        /*if(products.isPresent()) {
            return pdao.save(product);
        } else {
            throw new ProductException("Product not found with id : " + product.getProductID());
        }*/

        if(lSer.isLoginEmployee(key)) {
            CurrentUserSession currentUserSession = sdao.findByUuid(key);
            Employees employee = edao.findByMobileNumber(currentUserSession.getUserId());
            boolean flag = false;
            for(Products p : employee.getProducts()) {
                if(Objects.equals(p.getProductID(), product.getProductID())) {
                    p.setProductName(product.getProductName());
                    p.setUnit(product.getUnit());
                    p.setPrice(product.getPrice());
                    p.setCategoryID(product.getCategoryID());
                    p.setSupplierID(product.getSupplierID());
                    flag = true;
                }
            }
            if(flag) {
                edao.save(employee);
                return product;
            } else {
                throw new ProductException("Product not found with id : " + product.getProductID());
            }
        } else {
            throw new LoginException("Employee not login");
        }
    }

    @Override
    public Products deleteProducts(Integer id, String key) throws ProductException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            CurrentUserSession currentUserSession = sdao.findByUuid(key);
            Employees employee = edao.findByMobileNumber(currentUserSession.getUserId());
            boolean flag = false;

            for (Products p : employee.getProducts()) {
                if (Objects.equals(p.getProductID(), id)) {
                    pdao.deleteById(id);
                    flag = true;
                }
            }
            if (flag) {
                edao.save(employee);
                return pdao.findById(id).get();
            } else {
                throw new ProductException("You can't touch this product with product id : " + id);
            }
        } else {
            throw new LoginException("Employee not login");
        }


    }

    @Override
    public Products getProduct(Integer id, String key) throws ProductException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            Optional<Products> products = pdao.findById(id);
            if (products.isPresent()) {
                return products.get();
            } else {
                throw new ProductException("Product not found with id : " + id);
            }
        } else {
            throw new LoginException("Employee not login");
        }
    }

    @Override
    public List<Products> getAllProducts(String key) throws ProductException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            List<Products> products = pdao.findAll();
            if (products.isEmpty()) {
                throw new ProductException("Product list is empty");
            } else {
                return products;
            }
        } else {
            throw new LoginException("Employee not login");
        }
    }
}
