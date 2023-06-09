package com.cg.oms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oms.dto.OrdersDto;
import com.cg.oms.entity.Cart;
import com.cg.oms.entity.Customer;
import com.cg.oms.entity.Mobiles;
import com.cg.oms.entity.Orders;
import com.cg.oms.exception.CartException;
import com.cg.oms.exception.MobilesException;
import com.cg.oms.exception.OrderNotFoundException;
import com.cg.oms.exception.OrdersException;
import com.cg.oms.exception.UsersException;
import com.cg.oms.repositiory.ICartRepository;
import com.cg.oms.repositiory.ICustomerRepository;
import com.cg.oms.repositiory.IMobileRepository;
import com.cg.oms.repositiory.IOrderRepository;

@Service
public class OrdersServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository iorderRepository;

	@Autowired
	private IMobileRepository iMobileRepository;

	@Autowired
	private ICartRepository icartRepository;
	@Autowired
	ICustomerRepository iCustomerRepository;

	@Override
	public Orders addOrder(OrdersDto ordersDto) throws UsersException, MobilesException {

		Orders newOrder = new Orders();
		newOrder.setOrderDate(LocalDate.now());
		newOrder.setDispachDate(LocalDate.now());

		Optional<Customer> optCustomer = iCustomerRepository.findById(ordersDto.getCustomerId());
		if (!optCustomer.isPresent()) {
			throw new UsersException("CustomerId not found:" + ordersDto.getCustomerId());
		}

		newOrder.setCustomer(optCustomer.get());
		Set<Integer> mobilesIds = ordersDto.getMobilesId();
		Set<Mobiles> mobilelist = new HashSet<Mobiles>();
		float totalCost = 0.0f;
		int qty = 0;
		for (Integer mobileId : mobilesIds) {

			Optional<Mobiles> optMobiles = this.iMobileRepository.findById(mobileId);
			if (!optMobiles.isPresent()) {
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
		return iorderRepository.save(newOrder);
	}

	@Override
	public Orders updateOrder(OrdersDto ordersDto) throws OrderNotFoundException, OrdersException, MobilesException {

		Optional<Orders> optOrders = this.iorderRepository.findById(ordersDto.getOrderId());
		if (!optOrders.isPresent()) {
			throw new OrdersException("Orders id " + ordersDto.getOrderId() + " does not exists !");
		}

		Orders orders = optOrders.get();

		Set<Integer> mobilesIds = ordersDto.getMobilesId();
		Set<Mobiles> mobilelist = new HashSet<Mobiles>();
		float totalCost = 0.0f;
		int qty = 0;
		for (Integer mobileId : mobilesIds) {

			Optional<Mobiles> optMobiles = this.iMobileRepository.findById(mobileId);
			if (!optMobiles.isPresent()) {
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
		return iorderRepository.save(orders);
	}

	@Override
	@Transactional
	public Orders cancelOrder(int orderId) throws OrderNotFoundException, OrdersException {
		Optional<Orders> optOrder = iorderRepository.findById(orderId);
		if (!optOrder.isPresent())
			throw new OrdersException("Order id does not exists to delete !");
		
		int save = iorderRepository.updateOrder(orderId, "ORDER CANCELED");
		Optional<Orders> optOrder1 = iorderRepository.findById(orderId);
		if (!optOrder.isPresent())
			throw new OrdersException("Order id does not exists to delete !");
		Orders order1 = optOrder1.get();
		return order1;
	}

	@Override
	public Orders getOrderById(int orderId) throws OrdersException {
		Optional<Orders> optOrders = this.iorderRepository.findById(orderId);
		if (!optOrders.isPresent()) {
			throw new OrdersException("Orders id " + orderId + " does not exists !");
		}

		Orders orders = optOrders.get();
		return orders;
	}

	@Override
	public List<Orders> getAllOrders() {
		return iorderRepository.findAll();
	}

	@Override
	public Orders placedOrderFromCart(int customerId, int cartId) throws UsersException, CartException {

		Orders newOrder = new Orders();
		newOrder.setOrderDate(LocalDate.now());
		newOrder.setDispachDate(LocalDate.now());

		Optional<Cart> optCart = this.icartRepository.findById(cartId);
		if (!optCart.isPresent())
			throw new CartException("cart id does not exists to delete ");

		Optional<Customer> optCustomer = iCustomerRepository.findById(customerId);
		if (!optCustomer.isPresent()) {
			throw new UsersException("CustomerId not found:" + customerId);
		}

		Cart foundCart = optCart.get();

		Set<Mobiles> mobilesInCart = foundCart.getMobilesInCart();
		Set<Mobiles> mobilelist = new HashSet<Mobiles>();

		if (mobilesInCart.isEmpty()) {
			throw new CartException("mobilesInCart not found: " + mobilesInCart.size());
		}

		newOrder.setCustomer(optCustomer.get());
		float totalCost = 0.0f;
		int qty = 0;
		for (Mobiles mobile : mobilesInCart) {
			mobilelist.add(mobile);
			totalCost = totalCost + mobile.getMobileCost();
			qty = qty + 1;
		}
		newOrder.setMobiles(mobilelist);
		newOrder.setCost(totalCost);
		newOrder.setTotalCost(totalCost);
		newOrder.setQuantity(qty);
		newOrder.setOrderStatus("ORDER PLACED");
		Orders saveorder = iorderRepository.save(newOrder);

		// cart removed step after order placed

		mobilesInCart.removeAll(mobilesInCart);
		foundCart.setQuantity(0);
		foundCart.setTotalCost(0.0f);
		Cart cartsave = icartRepository.save(foundCart);

		return saveorder;

	}

	@Override
	public List<Orders> getOrderByCustomerId(Integer customerId) throws UsersException {
		Optional<Customer> optCustomer = iCustomerRepository.findById(customerId);
		if (!optCustomer.isPresent()) {
			throw new UsersException("CustomerId not found:" + customerId);
		}
		
		List<Orders> userOrders  = iorderRepository.findOrderByCostomerId(customerId);
		//List<Orders> userOrders = optCustomer.get().getUserOrders();
		return userOrders;
	}

}
