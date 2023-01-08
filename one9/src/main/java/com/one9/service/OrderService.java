package com.one9.service;

import com.one9.model.Orders;
import io.swagger.models.auth.In;

public interface OrderService {
    public Orders addOrder(Orders order);
    public Orders deleteOrder(Orders order);
    public Orders getOrder(Integer id);
    public Orders getAllOrder();
}
