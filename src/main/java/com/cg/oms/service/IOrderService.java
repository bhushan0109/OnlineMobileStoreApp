package com.cg.oms.service;

import java.util.List;

import com.cg.oms.dto.OrdersDto;
import com.cg.oms.entity.Orders;
import com.cg.oms.exception.CartException;
import com.cg.oms.exception.MobilesException;
import com.cg.oms.exception.OrderNotFoundException;
import com.cg.oms.exception.OrdersException;
import com.cg.oms.exception.UsersException;

public interface IOrderService {

	public Orders addOrder(OrdersDto ordersDto) throws UsersException, MobilesException;

	public Orders updateOrder(OrdersDto ordersDto) throws OrderNotFoundException, OrdersException, MobilesException;

	public Orders cancelOrder(int orderId) throws OrderNotFoundException, OrdersException;

	public Orders getOrderById(int orderId) throws OrdersException;

	public List<Orders> getAllOrders();

	public Orders placedOrderFromCart(int customerId, int cartId) throws UsersException, CartException;

	public List<Orders> getOrderByCustomerId(Integer customerId) throws UsersException;

}
