package com.moboleStore.app.service;
//package com.thebookStore.app.service;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.thebookStore.app.entity.Cart;
//import com.thebookStore.app.entity.Orders;
//import com.thebookStore.app.entity.Payment;
//import com.thebookStore.app.entity.Users;
//import com.thebookStore.app.exception.CartException;
//import com.thebookStore.app.exception.OrdersException;
//import com.thebookStore.app.exception.UsersException;
//import com.thebookStore.app.repositiory.CartRepository;
//import com.thebookStore.app.repositiory.OrdersRepository;
//import com.thebookStore.app.repositiory.UsersRepository;
//
//
///***********************************************************************************
//
// * @author Obulreddy Pravalika
// * Description  It is a service class that provides the services for adding a new order, 
// * to category, updating the Orders, viewing the Orders, getting all the Orders
// * and deleting a Orders.
// * Version 1.0
// * Created Date 09-FEB-2023
//
// ************************************************************************************/
//@Service
//public class OrdersServiceImpl implements OrdersService {
//	
//	@Autowired
//	private OrdersRepository orderRepository;
//	
//	@Autowired
//	private UsersRepository userRepository;
//	
//	@Autowired
//	private CartRepository cartRepository;
//
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private CartService cartService;
//
//	
//	
//	@Override
//	public Orders addOrder(Orders newOrder) {
//		newOrder.setOrderDate(LocalDate.now());
//		return orderRepository.save(newOrder);
//	
//	}
//
//	
//	/************************************************************************************
//
//	 * Method:-updateOrders
//
//	 * Description: -To update a orders in database
//
//	 * @param OrderId -Id of the orders to be updated
//
//	 * @returns Orders-Orders is returned after updating to database
//
//	 * @throws OrderssException -raised if the orderId does not exist in database
//
//	 * Created By -Obulreddy Pravalika
//
//	 * Created Date -10-FEB-2023 
//
//	 
//
//	 ************************************************************************************/
//	@Override
//	public Orders updateOrder(Orders updateOrder) {
//		 
//		return this.orderRepository.save(updateOrder);
//	}
//	
//		
//
//	/************************************************************************************
//
//	 * Method:-deleteOrdersById
//
//	 * Description: -To remove a Orders from database
//
//	 * @param OrderId -Id of the Orders to be removed
//
//	 * @returns Orders -orders is returned after adding to database
//
//	 * @throws OrdersException -raised if the orderId does not exist in database
//
//	 * Created By -Obulreddy Pravalika
//
//	 * Created Date -10-FEB-2023 
//
//	 
//
//	 ************************************************************************************/	
//	@Override
//	public Orders deleteOrderById(Integer orderId) throws OrdersException {
//		
//		Optional<Orders> optOrder = this.orderRepository.findById(orderId);
//		if (optOrder.isEmpty())
//			throw new OrdersException("Order id does not exists to delete !");
//		Orders order = optOrder.get();
//        this.orderRepository.delete(order);
//        return order;
//	}	
//
//	
//	/************************************************************************************
//
//	 * Method:-getOrderById
//
//	 * Description: -To get order from database
//
//	 * @param OrderId -Id of the order to be returned
//
//	 * @returns Books -Book is returned 
//
//	 * @throws OrdersException -raised if the orderId does not exist in database
//
//	 * Created By -Obulreddy Pravalika
//
//	 * Created Date -10-FEB-2023 
//
//	 
//
//	 ************************************************************************************/
//
//	@Override
//	public Orders getOrderById(Integer orderId) throws OrdersException {
//		Optional<Orders> optOrder = orderRepository.findById(orderId);
//		if (optOrder.isEmpty())
//			throw new OrdersException("Order id not found :" +orderId);
//		
//		return optOrder.get();
//	}
//	
//	
//	/************************************************************************************
//
//	 * Method:-getAllOrders
//
//	 * Description: -To get all the orders in database
//
//	 * @returns List<Orders> -List of all the orders present in the database is returned
//
//	 * Created By -Obulreddy Pravalika
//
//	 * Created Date -10-FEB-2023 
//
//	 
//
//	 ************************************************************************************/
//    @Override
//	public List<Orders> getAllOrders() {
//    	
//    	return orderRepository.findAll();
//	}
//
//
//	@Override
//	public Orders addOrderToUser(Orders order, Integer userId) throws UsersException {
//		Optional<Users> user = userRepository.findById(userId);
//		if(user.isEmpty()) {
//			throw new UsersException("User not found");
//		}
//		
//		Users foundUser = user.get();
//		Orders newOrder = addOrder(order);
//		foundUser.getUserOrders().add(newOrder);
//		orderRepository.save(newOrder);
//		userRepository.save(foundUser);
//		return null;
//	}
//
//
//	@Override
//	public Orders getOrdersFromCart(Payment payment, Integer userId) throws UsersException, CartException{
//		Users user = userService.getUserByUserId(userId);
//		Cart cart = cartService.getCartById(userId);
//		Orders order = new Orders();
//		order.setTotalCost(cart.getTotalCost());
//		order.getBooks().addAll(cart.getBooksInCart());
//		order.setOrderDate(LocalDate.now());
//		order.setQuantity(cart.getQuantity());
//		orderRepository.save(order);
//		List<Orders> orderList = new ArrayList<>();
//		orderList.add(order);
//		user.setUserOrders(orderList);
//		cart.getBooksInCart().removeAll(cart.getBooksInCart());
//		this.cartRepository.save(cart);
//		return orderRepository.save(order);
//		
//		
//		
//	}
//
//
//}
