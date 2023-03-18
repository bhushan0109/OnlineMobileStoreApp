package com.moboleStore.app.repositiory;


import java.util.List;

import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.entity.Orders;
import com.moboleStore.app.exception.OrderNotFoundException;




public interface IOrderRepository {

	public Orders addOrder(Orders order);
	public Orders updateOrder(Orders order) throws OrderNotFoundException;
	public Orders cancelOrder(int id) throws OrderNotFoundException;
	public List<Orders> showAllMobiles(int id);
	public double calculateTotalCost(List<Mobiles> list);
 }
