package com.one9.service;

import com.one9.exception.OrderException;
import com.one9.model.Orders;
import io.swagger.models.auth.In;

public interface OrderService {
    public Orders addOrder(Orders order) throws OrderException;
    public Orders deleteOrder(Orders order) throws OrderException;
    public Orders getOrder(Integer id) throws OrderException;
    public Orders getAllOrder() throws OrderException;
}
