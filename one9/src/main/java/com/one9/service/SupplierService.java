package com.one9.service;

import com.one9.model.Shippers;
import com.one9.model.Suppliers;

import java.util.List;

public interface SupplierService {
    public Suppliers addSupplier(Suppliers supplier);

    public Suppliers updateShipper(Suppliers supplier);

    public Suppliers deleteShipper(Suppliers supplier);

    public Suppliers getShipper(Integer cid);

    public List<Suppliers> getAllShipper();
}
