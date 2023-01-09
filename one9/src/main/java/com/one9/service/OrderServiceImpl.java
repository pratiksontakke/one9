package com.one9.service;

import com.one9.dao.OrdersDAO;
import com.one9.exception.OrderException;
import com.one9.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrdersDAO odao;

    @Override
    public Orders addOrder(Orders order) throws OrderException {
        return odao.save(order);
    }

    @Override
    public Orders deleteOrder(Integer id) throws OrderException {
        Optional<Orders> orders = odao.findById(id);
        if (orders.isPresent()) {
            odao.deleteById(id);
            return orders.get();
        } else {
            throw new OrderException("Order not found with id : " + id);
        }
    }

    @Override
    public Orders getOrder(Integer id) throws OrderException {
        Optional<Orders> orders = odao.findById(id);
        if (orders.isPresent()) {
            return orders.get();
        } else {
            throw new OrderException("Order not found with id : " + id);
        }
    }

    @Override
    public List<Orders> getAllOrder() throws OrderException {
        List<Orders> orders = odao.findAll();
        if(orders.isEmpty()) {
            throw new OrderException("Order list is empty");
        } else {
            return orders;
        }
    }
}
