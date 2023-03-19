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

//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private CartService cartService;

	@Override
	public Orders addOrder(OrdersDto ordersDto) throws UsersException, MobilesException {

		Orders newOrder = new Orders();
		newOrder.setOrderDate(LocalDate.now());
		newOrder.setDispachDate(LocalDate.now());
		newOrder.setCost(ordersDto.getCost());

		Optional<Customer> optCustomer = iCustomerRepository.findById(ordersDto.getCustomerId());
		if (optCustomer.isEmpty()) {
			throw new UsersException("CustomerId not found:" + ordersDto.getCustomerId());
		}

		newOrder.setCustomer(optCustomer.get());
		List<Integer> mobilesIds = ordersDto.getMobilesId();
		List<Mobiles> mobilelist = new ArrayList<>();

		for (Integer mobileId : mobilesIds) {

			Optional<Mobiles> optMobiles = this.iMobileRepository.findById(mobileId);
			if (optMobiles.isEmpty()) {
				throw new MobilesException("Mobile id " + mobileId + " does not exists !");
			}
			Mobiles mobile = optMobiles.get();
			mobilelist.add(mobile);
		}
		newOrder.setMobiles(mobilelist);
		newOrder.setTotalCost(ordersDto.getTotalCost());
		newOrder.setQuantity(ordersDto.getQuantity());

		return orderRepository.save(newOrder);
	}

	@Override
	public Orders updateOrder(OrdersDto ordersDto) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders cancelOrder(int orderId) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> showAllMobiles(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders getOrderById(Integer orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Orders updateOrder(Orders updateOrder) {
//
//		return this.orderRepository.save(updateOrder);
//	}
//
//	@Override
//	public Orders deleteOrderById(Integer orderId) throws OrdersException {
//
//		Optional<Orders> optOrder = this.orderRepository.findById(orderId);
//		if (optOrder.isEmpty())
//			throw new OrdersException("Order id does not exists to delete !");
//		Orders order = optOrder.get();
//		this.orderRepository.delete(order);
//		return order;
//	}
//
//	@Override
//	public Orders getOrderById(Integer orderId) throws OrdersException {
//		Optional<Orders> optOrder = orderRepository.findById(orderId);
//		if (optOrder.isEmpty())
//			throw new OrdersException("Order id not found :" + orderId);
//
//		return optOrder.get();
//	}
//
//	@Override
//	public List<Orders> getAllOrders() {
//
//		return orderRepository.findAll();
//	}
//
////	@Override
////	public Orders addOrderToUser(Orders order, Integer userId) throws UsersException {
////		Optional<Users> user = userRepository.findById(userId);
////		if (user.isEmpty()) {
////			throw new UsersException("User not found");
////		}
////
////		Users foundUser = user.get();
////		Orders newOrder = addOrder(order);
////		foundUser.getUserOrders().add(newOrder);
////		orderRepository.save(newOrder);
////		userRepository.save(foundUser);
////		return null;
////	}
//
////	@Override
////	public Orders getOrdersFromCart(Payment payment, Integer userId) throws UsersException, CartException {
////		Users user = userService.getUserByUserId(userId);
////		Cart cart = cartService.getCartById(userId);
////		Orders order = new Orders();
////		order.setTotalCost(cart.getTotalCost());
////		order.getBooks().addAll(cart.getBooksInCart());
////		order.setOrderDate(LocalDate.now());
////		order.setQuantity(cart.getQuantity());
////		orderRepository.save(order);
////		List<Orders> orderList = new ArrayList<>();
////		orderList.add(order);
////		user.setUserOrders(orderList);
////		cart.getBooksInCart().removeAll(cart.getBooksInCart());
////		this.cartRepository.save(cart);
////		return orderRepository.save(order);
////
////	}
//
//	@Override
//	public Order cancelOrder(int id) throws OrderNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Order> showAllMobiles(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public double calculateTotalCost(List<Mobiles> list) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public Orders updateOrder(OrdersDto ordersDto) throws OrderNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Orders cancelOrder(int orderId) throws OrderNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
