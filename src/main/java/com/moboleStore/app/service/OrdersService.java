package com.moboleStore.app.service;

import java.util.List;

import com.moboleStore.app.entity.Orders;
import com.moboleStore.app.exception.CartException;
import com.moboleStore.app.exception.OrdersException;
import com.moboleStore.app.exception.UsersException;

public interface OrdersService {
	public Orders addOrder(Orders newOrder);

	public Orders updateOrder(Orders updateOrder);

	public Orders deleteOrderById(Integer orderId) throws OrdersException;

	public Orders getOrderById(Integer orderId) throws OrdersException;

	public List<Orders> getAllOrders();
	
	public Orders addOrderToUser(Orders order, Integer userId) throws UsersException;


}
