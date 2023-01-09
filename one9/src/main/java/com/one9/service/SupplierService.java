package com.one9.service;

import com.one9.exception.LoginException;
import com.one9.exception.SupplierException;
import com.one9.model.Shippers;
import com.one9.model.Suppliers;

import java.util.List;

public interface SupplierService {
    public Suppliers addSupplier(Suppliers supplier, String key) throws SupplierException, LoginException;

    public Suppliers updateSupplier(Suppliers supplier, String key) throws SupplierException, LoginException;

    public Suppliers deleteSupplier(Integer id, String key) throws SupplierException, LoginException;

    public Suppliers getSupplier(Integer id, String key) throws SupplierException, LoginException;

    public List<Suppliers> getAllSupplier(String key) throws SupplierException, LoginException;
}
