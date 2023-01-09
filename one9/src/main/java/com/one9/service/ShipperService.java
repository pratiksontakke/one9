package com.one9.service;

import com.one9.exception.LoginException;
import com.one9.exception.ShipperException;
import com.one9.model.Shippers;

import java.util.List;

public interface ShipperService {
    public Shippers addShipper(Shippers shipper, String key) throws ShipperException, LoginException;

    public Shippers updateShipper(Shippers shipper, String key) throws ShipperException, LoginException;

    public Shippers deleteShipper(Integer id, String key) throws ShipperException, LoginException;

    public Shippers getShipper(Integer id, String key) throws ShipperException, LoginException;

    public List<Shippers> getAllShipper(String key) throws ShipperException, LoginException;
}
