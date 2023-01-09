package com.one9.service;

import com.one9.exception.ProductException;
import com.one9.exception.ShipperException;
import com.one9.model.Products;
import com.one9.model.Shippers;

import java.util.List;

public interface ShipperService {
    public Shippers addShipper(Shippers shipper) throws ShipperException;

    public Shippers updateShipper(Shippers shipper) throws ShipperException;

    public Shippers deleteShipper(Integer id) throws ShipperException;

    public Shippers getShipper(Integer id) throws ShipperException;

    public List<Shippers> getAllShipper() throws ShipperException;
}
