package com.one9.service;

import com.one9.exception.LoginException;
import com.one9.exception.OrderException;
import com.one9.model.Orders;
import io.swagger.models.auth.In;

import java.util.List;

public interface OrderService {
    public String addOrder(Orders order, String key) throws OrderException, LoginException;
    public Orders deleteOrder(Integer id, String key) throws OrderException, LoginException;
    public Orders getOrder(Integer id, String key) throws OrderException, LoginException;
    public List<Orders> getAllOrderCustomer(String key) throws OrderException, LoginException;

    public List<Orders> getAllOrderEmployee(String key) throws OrderException, LoginException;
}
