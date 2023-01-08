package com.one9.service;

import com.one9.exception.ProductException;
import com.one9.model.Products;
import com.one9.model.Shippers;

import java.util.List;

public interface ShipperService {
    public Shippers addShipper(Shippers shipper) throws ProductException;

    public Shippers updateShipper(Shippers shipper) throws ProductException;

    public Shippers deleteShipper(Shippers shipper) throws ProductException;

    public Shippers getShipper(Integer id) throws ProductException;

    public List<Shippers> getAllShipper() throws ProductException;
}
