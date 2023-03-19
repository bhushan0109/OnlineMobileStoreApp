package com.moboleStore.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moboleStore.app.dto.OrdersDto;
import com.moboleStore.app.entity.Customer;
import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.entity.Orders;
import com.moboleStore.app.entity.Users;
import com.moboleStore.app.exception.MobilesException;
import com.moboleStore.app.exception.OrderNotFoundException;
import com.moboleStore.app.exception.OrdersException;
import com.moboleStore.app.exception.UsersException;
import com.moboleStore.app.repositiory.ICartRepository;
import com.moboleStore.app.repositiory.ICustomerRepository;
import com.moboleStore.app.repositiory.IMobileRepository;
import com.moboleStore.app.repositiory.IOrderRepository;
import com.moboleStore.app.repositiory.IUserRepository;

@Service
public class OrdersServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IMobileRepository iMobileRepository;

	@Autowired
	private ICartRepository cartRepository;
	@Autowired
	ICustomerRepository iCustomerRepository;

	@Override
	public Orders addOrder(OrdersDto ordersDto) throws UsersException, MobilesException {

		Orders newOrder = new Orders();
		newOrder.setOrderDate(LocalDate.now());
		newOrder.setDispachDate(LocalDate.now());

		Optional<Customer> optCustomer = iCustomerRepository.findById(ordersDto.getCustomerId());
		if (optCustomer.isEmpty()) {
			throw new UsersException("CustomerId not found:" + ordersDto.getCustomerId());
		}

		newOrder.setCustomer(optCustomer.get());
		List<Integer> mobilesIds = ordersDto.getMobilesId();
		List<Mobiles> mobilelist = new ArrayList<>();
		float totalCost = 0.0f;
		int qty = 0;
		for (Integer mobileId : mobilesIds) {

			Optional<Mobiles> optMobiles = this.iMobileRepository.findById(mobileId);
			if (optMobiles.isEmpty()) {
				throw new MobilesException("Mobile id " + mobileId + " does not exists !");
			}
			Mobiles mobile = optMobiles.get();
			totalCost = totalCost + mobile.getMobileCost();
			qty = qty + 1;
			mobilelist.add(mobile);
		}
		newOrder.setMobiles(mobilelist);
		newOrder.setCost(totalCost);
		newOrder.setTotalCost(totalCost);
		newOrder.setQuantity(qty);
		newOrder.setOrderStatus("ORDER PLACED");
		return orderRepository.save(newOrder);
	}

	@Override
	public Orders updateOrder(OrdersDto ordersDto) throws OrderNotFoundException, OrdersException, MobilesException {

		Optional<Orders> optOrders = this.orderRepository.findById(ordersDto.getOrderId());
		if (optOrders.isEmpty()) {
			throw new OrdersException("Orders id " + ordersDto.getOrderId() + " does not exists !");
		}

		Orders orders = optOrders.get();

		List<Integer> mobilesIds = ordersDto.getMobilesId();
		List<Mobiles> mobilelist = new ArrayList<>();
		float totalCost = 0.0f;
		int qty = 0;
		for (Integer mobileId : mobilesIds) {

			Optional<Mobiles> optMobiles = this.iMobileRepository.findById(mobileId);
			if (optMobiles.isEmpty()) {
				throw new MobilesException("Mobile id " + mobileId + " does not exists !");
			}
			Mobiles mobile = optMobiles.get();
			totalCost = totalCost + mobile.getMobileCost();
			qty = qty + 1;
			mobilelist.add(mobile);
		}
		orders.setMobiles(mobilelist);
		orders.setCost(totalCost);
		orders.setTotalCost(totalCost);
		orders.setQuantity(qty);
		return orderRepository.save(orders);
	}

	@Override
	public Orders cancelOrder(int orderId) throws OrderNotFoundException, OrdersException {
		Optional<Orders> optOrder = this.orderRepository.findById(orderId);
		if (optOrder.isEmpty())
			throw new OrdersException("Order id does not exists to delete !");
		Orders order = optOrder.get();
		order.setOrderStatus("ORDER CANCELED");
		this.orderRepository.save(order);
		return order;
	}

	@Override
	public Orders getOrderById(Integer orderId) throws OrdersException {
		Optional<Orders> optOrders = this.orderRepository.findById(orderId);
		if (optOrders.isEmpty()) {
			throw new OrdersException("Orders id " + orderId + " does not exists !");
		}

		Orders orders = optOrders.get();
		return orders;
	}

	@Override
	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}

}
