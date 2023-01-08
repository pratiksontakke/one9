package com.one9.service;

import com.one9.exception.OrderException;
import com.one9.model.Orders;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Orders addOrder(Orders order) throws OrderException {
        return null;
    }

    @Override
    public Orders deleteOrder(Orders order) throws OrderException {
        return null;
    }

    @Override
    public Orders getOrder(Integer id) throws OrderException {
        return null;
    }

    @Override
    public Orders getAllOrder() throws OrderException {
        return null;
    }
}
