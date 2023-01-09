package com.one9.service;

import com.one9.dao.EmployeesDAO;
import com.one9.dao.ProductsDAO;
import com.one9.dao.SessionDAO;
import com.one9.dao.SuppliersDAO;
import com.one9.exception.LoginException;
import com.one9.exception.ProductException;
import com.one9.exception.SupplierException;
import com.one9.model.CurrentUserSession;
import com.one9.model.Customers;
import com.one9.model.Employees;
import com.one9.model.Suppliers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    SuppliersDAO supdao;

    @Autowired
    EmployeesDAO edao;

    @Autowired
    SessionDAO sdao;

    @Autowired
    LoginService lSer;

    @Override
    public Suppliers addSupplier(Suppliers supplier, String key) throws SupplierException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            CurrentUserSession currentUserSession = sdao.findByUuid(key);
            Employees employee = edao.findByMobileNumber(currentUserSession.getUserId());
            employee.getSuppliers().add(supplier);
            edao.save(employee);
            return supplier;
        } else {
            throw new LoginException("Employee not login.");
        }
    }

    @Override
    public Suppliers updateSupplier(Suppliers supplier, String key) throws SupplierException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            CurrentUserSession currentUserSession = sdao.findByUuid(key);
            Employees employee = edao.findByMobileNumber(currentUserSession.getUserId());
            for(Suppliers s : employee.getSuppliers()) {
                if(Objects.equals(s.getSupplierID(), supplier.getSupplierID())) {
                    s.setSupplierName(supplier.getSupplierName());
                    s.setCity(supplier.getCity());
                    s.setPhone(supplier.getPhone());
                    s.setAddress(supplier.getAddress());
                    s.setCountry(supplier.getCountry());
                    s.setCity(supplier.getCity());
                    s.setPostalCode(supplier.getPostalCode());

                    edao.save(employee);
                    return supplier;
                }
            }
            throw new SupplierException("Supplier not found with id : " + supplier.getSupplierID() + " in your list");
        } else {
            throw new LoginException("Employee not login.");
        }

    }

    @Override
    public Suppliers deleteSupplier(Integer id, String key) throws SupplierException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            CurrentUserSession currentUserSession = sdao.findByUuid(key);
            Employees employee = edao.findByMobileNumber(currentUserSession.getUserId());
            for(Suppliers s : employee.getSuppliers()) {
                if(Objects.equals(s.getSupplierID(), id)) {
                    employee.getSuppliers().remove(s);
                    edao.save(employee);
                    return s;
                }
            }
            throw new SupplierException("Supplier not found with id : " + id);
        } else {
            throw new LoginException("Employee not login.");
        }
    }

    @Override
    public Suppliers getSupplier(Integer id, String key) throws SupplierException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            Optional<Suppliers> suppliers = supdao.findById(id);
            if(suppliers.isPresent()) {
                return suppliers.get();
            } else {
                throw new SupplierException("Supplier not found with id : " + id);
            }
        } else {
            throw new LoginException("Employee not login.");
        }
    }

    @Override
    public List<Suppliers> getAllSupplier(String key) throws SupplierException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            List<Suppliers> suppliers = supdao.findAll();
            if(suppliers.isEmpty()) {
                throw new SupplierException("Supplier list is empty");
            } else {
                return suppliers;
            }
        } else {
            throw new LoginException("Employee not login.");
        }
    }

}
