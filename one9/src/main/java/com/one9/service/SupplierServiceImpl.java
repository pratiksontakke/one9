package com.one9.service;

import com.one9.dao.SuppliersDAO;
import com.one9.exception.ProductException;
import com.one9.exception.SupplierException;
import com.one9.model.Suppliers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    SuppliersDAO sdao;
    @Override
    public Suppliers addSupplier(Suppliers supplier) throws SupplierException {
        return sdao.save(supplier);
    }

    @Override
    public Suppliers updateSupplier(Suppliers supplier) throws SupplierException {
        Optional<Suppliers> suppliers = sdao.findById(supplier.getSupplierID());
        if(suppliers.isPresent()) {
            return sdao.save(supplier);
        } else {
            throw new SupplierException("Supplier not found with id : " + supplier.getSupplierID());
        }
    }

    @Override
    public Suppliers deleteSupplier(Integer id) throws SupplierException {
        Optional<Suppliers> suppliers = sdao.findById(id);
        if(suppliers.isPresent()) {
            sdao.deleteById(id);
            return suppliers.get();
        } else {
            throw new SupplierException("Supplier not found with id : " + id);
        }
    }

    @Override
    public Suppliers getSupplier(Integer id) throws SupplierException {
        Optional<Suppliers> suppliers = sdao.findById(id);
        if(suppliers.isPresent()) {
            return suppliers.get();
        } else {
            throw new SupplierException("Supplier not found with id : " + id);
        }
    }

    @Override
    public List<Suppliers> getAllSupplier() throws SupplierException {
        List<Suppliers> suppliers = sdao.findAll();
        if(suppliers.isEmpty()) {
            throw new SupplierException("Supplier list is empty");
        } else {
            return suppliers;
        }
    }
}
