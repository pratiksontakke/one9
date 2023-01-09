package com.one9.service;

import com.one9.dao.ShippersDAO;
import com.one9.exception.ShipperException;
import com.one9.model.Shippers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipperServiceImpl implements ShipperService{

    @Autowired
    private ShippersDAO sdao;
    @Override
    public Shippers addShipper(Shippers shipper) throws ShipperException {
        return sdao.save(shipper);
    }

    @Override
    public Shippers updateShipper(Shippers shipper) throws ShipperException {
        Optional<Shippers> shippers = sdao.findById(shipper.getShipperID());
        if(shippers.isPresent()) {
            return sdao.save(shipper);
        } else {
            throw new ShipperException("Shipper not found with id : " + shipper.getShipperID());
        }
    }

    @Override
    public Shippers deleteShipper(Integer id) throws ShipperException {
        Optional<Shippers> shippers = sdao.findById(id);
        if(shippers.isPresent()) {
            sdao.deleteById(id);
            return shippers.get();
        } else {
            throw new ShipperException("Shipper not found with id : " + id);
        }
    }

    @Override
    public Shippers getShipper(Integer id) throws ShipperException {
        Optional<Shippers> shippers = sdao.findById(id);
        if(shippers.isPresent()) {
            return shippers.get();
        } else {
            throw new ShipperException("Shipper not found with id : " + id);
        }
    }

    @Override
    public List<Shippers> getAllShipper() throws ShipperException {
        List<Shippers> shippers = sdao.findAll();
        if(shippers.isEmpty()) {
            throw new ShipperException("Shipper list is empty");
        } else {
            return shippers;
        }
    }
}
