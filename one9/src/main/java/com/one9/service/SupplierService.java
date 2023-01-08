package com.one9.service;

import com.one9.exception.SupplierException;
import com.one9.model.Shippers;
import com.one9.model.Suppliers;

import java.util.List;

public interface SupplierService {
    public Suppliers addSupplier(Suppliers supplier) throws SupplierException;

    public Suppliers updateSupplier(Suppliers supplier) throws SupplierException;

    public Suppliers deleteSupplier(Suppliers supplier) throws SupplierException;

    public Suppliers getSupplier(Integer id) throws SupplierException;

    public List<Suppliers> getAllSupplier() throws SupplierException;
}
