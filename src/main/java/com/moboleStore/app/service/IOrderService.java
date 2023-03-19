package com.moboleStore.app.service;

import java.util.List;

import com.moboleStore.app.dto.OrdersDto;
import com.moboleStore.app.entity.Orders;
import com.moboleStore.app.exception.MobilesException;
import com.moboleStore.app.exception.OrderNotFoundException;
import com.moboleStore.app.exception.OrdersException;
import com.moboleStore.app.exception.UsersException;

public interface IOrderService {

	public Orders addOrder(OrdersDto ordersDto) throws UsersException, MobilesException;

	public Orders updateOrder(OrdersDto ordersDto) throws OrderNotFoundException, OrdersException, MobilesException;

	public Orders cancelOrder(int orderId) throws OrderNotFoundException, OrdersException;

	public Orders getOrderById(Integer orderId) throws OrdersException;

	public List<Orders> getAllOrders();

}
