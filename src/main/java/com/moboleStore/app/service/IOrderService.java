package com.moboleStore.app.service;

import java.util.List;

import javax.persistence.criteria.Order;

import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.exception.OrderNotFoundException;

public interface IOrderService {

	public Order addOrder(Order order);

	public Order updateOrder(Order order) throws OrderNotFoundException;

	public Order cancelOrder(int id) throws OrderNotFoundException;

	public List<Order> showAllMobiles(int id);

	public double calculateTotalCost(List<Mobiles> list);
}
