package com.moboleStore.app.service;

import java.util.List;

import com.moboleStore.app.dto.OrdersDto;
import com.moboleStore.app.entity.Orders;
import com.moboleStore.app.exception.MobilesException;
import com.moboleStore.app.exception.OrderNotFoundException;
import com.moboleStore.app.exception.UsersException;

public interface IOrderService {

	public Orders addOrder(OrdersDto ordersDto) throws UsersException, MobilesException;

	public Orders updateOrder(OrdersDto ordersDto) throws OrderNotFoundException;

	public Orders cancelOrder(int orderId) throws OrderNotFoundException;

	public List<Orders> showAllMobiles(int id);

	public Orders getOrderById(Integer orderId);

	public List<Orders> getAllOrders();

}
