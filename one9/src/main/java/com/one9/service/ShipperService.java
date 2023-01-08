package com.one9.service;

import com.one9.model.Products;
import com.one9.model.Shippers;

import java.util.List;

public interface ShipperService {
    public Shippers addShipper(Shippers shipper);

    public Shippers updateShipper(Shippers shipper);

    public Shippers deleteShipper(Shippers shipper);

    public Shippers getShipper(Integer cid);

    public List<Shippers> getAllShipper();
}
