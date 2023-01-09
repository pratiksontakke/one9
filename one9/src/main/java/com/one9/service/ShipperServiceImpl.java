package com.one9.service;

import com.one9.dao.EmployeesDAO;
import com.one9.dao.SessionDAO;
import com.one9.dao.ShippersDAO;
import com.one9.exception.LoginException;
import com.one9.exception.ShipperException;
import com.one9.model.CurrentUserSession;
import com.one9.model.Employees;
import com.one9.model.Shippers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ShipperServiceImpl implements ShipperService{

    @Autowired
    private ShippersDAO shipdao;

    @Autowired
    EmployeesDAO edao;

    @Autowired
    SessionDAO sdao;

    @Autowired
    LoginService lSer;
    @Override
    public Shippers addShipper(Shippers shipper, String key) throws ShipperException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            CurrentUserSession currentUserSession = sdao.findByUuid(key);
            Employees employee = edao.findByMobileNumber(currentUserSession.getUserId());
            employee.getShippers().add(shipper);
            edao.save(employee);
            return shipper;
        } else {
            throw new LoginException("Employee not login.");
        }

    }

    @Override
    public Shippers updateShipper(Shippers shipper, String key) throws ShipperException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            CurrentUserSession currentUserSession = sdao.findByUuid(key);
            Employees employee = edao.findByMobileNumber(currentUserSession.getUserId());
            for(Shippers s : employee.getShippers()) {
                if(Objects.equals(s.getShipperID(), shipper.getShipperID())) {
                    s.setShipperName(shipper.getShipperName());
                    s.setPhone(shipper.getPhone());
                    edao.save(employee);
                    return shipper;
                }
            }
            throw new ShipperException("Shipper not found with id : " + shipper.getShipperID() + " in your list");
        } else {
            throw new LoginException("Employee not login.");
        }

    }

    @Override
    public Shippers deleteShipper(Integer id, String key) throws ShipperException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            CurrentUserSession currentUserSession = sdao.findByUuid(key);
            Employees employee = edao.findByMobileNumber(currentUserSession.getUserId());
            for(Shippers s : employee.getShippers()) {
                if(Objects.equals(s.getShipperID(), id)) {
                    employee.getShippers().remove(s);
                    edao.save(employee);
                    return s;
                }
            }
            throw new ShipperException("Shipper not found with id : " + id);
        } else {
            throw new LoginException("Employee not login.");
        }

    }

    @Override
    public Shippers getShipper(Integer id, String key) throws ShipperException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            Optional<Shippers> shippers = shipdao.findById(id);
            if(shippers.isPresent()) {
                return shippers.get();
            } else {
                throw new ShipperException("Shipper not found with id : " + id);
            }
        } else {
            throw new LoginException("Employee not login.");
        }

    }

    @Override
    public List<Shippers> getAllShipper(String key) throws ShipperException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            List<Shippers> shippers = shipdao.findAll();
            if(shippers.isEmpty()) {
                throw new ShipperException("Shipper list is empty");
            } else {
                return shippers;
            }
        } else {
            throw new LoginException("Employee not login.");
        }

    }
}
