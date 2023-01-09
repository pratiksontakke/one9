package com.one9.service;

import com.one9.dao.CustomerDAO;
import com.one9.dao.OrdersDAO;
import com.one9.dao.SessionDAO;
import com.one9.exception.LoginException;
import com.one9.exception.OrderException;
import com.one9.model.CurrentUserSession;
import com.one9.model.Customers;
import com.one9.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrdersDAO odao;

    @Autowired
    SessionDAO sdao;

    @Autowired
    CustomerDAO cdao;

    @Autowired
    LoginServiceImpl lSer;

    @Override
    public String addOrder(Orders order, String key) throws OrderException, LoginException {
        if(lSer.isLoginCustomer(key)) {
            CurrentUserSession currentUserSession = sdao.findByUuid(key);
            Customers customers = cdao.findByMobileNumber(currentUserSession.getUserId());
            customers.getOrder().add(order);
            cdao.save(customers);
            return "Product added successfully";
        } else {
            throw new LoginException("Customer not login");
        }
    }

    @Override
    public Orders deleteOrder(Integer id, String key) throws OrderException, LoginException {
        if(!lSer.isLoginCustomer(key)) {
            throw new LoginException("Customer not login");
        }
        Optional<Orders> orders = odao.findById(id);
        if (orders.isPresent()) {
            odao.deleteById(id);
            return orders.get();
        } else {
            throw new OrderException("Order not found with id : " + id);
        }
    }

    @Override
    public Orders getOrder(Integer id, String key) throws OrderException, LoginException {
        if(!lSer.isLoginCustomer(key) || !lSer.isLoginEmployee(key)) {
            throw new LoginException("Login first");
        }

        Optional<Orders> orders = odao.findById(id);
        if (orders.isPresent()) {
            return orders.get();
        } else {
            throw new OrderException("Order not found with id : " + id);
        }
    }

    @Override
    public List<Orders> getAllOrderCustomer(String key) throws OrderException, LoginException {
        if(lSer.isLoginCustomer(key)) {
            CurrentUserSession currentUserSession = sdao.findByUuid(key);
            Customers customers = cdao.findByMobileNumber(currentUserSession.getUserId());
            List<Orders> orders = customers.getOrder();
            if(orders.isEmpty()) {
                throw new OrderException("Order list is empty");
            }
            return orders;
        } else {
            throw new LoginException("Customer not login");
        }
    }

    @Override
    public List<Orders> getAllOrderEmployee(String key) throws OrderException, LoginException {
        if(lSer.isLoginEmployee(key)) {
            List<Orders> orders = odao.findAll();
            if(orders.isEmpty()) {
                throw new OrderException("Order list is empty");
            }
            return orders;
        } else {
            throw new LoginException("Employee not login");
        }
    }
}
