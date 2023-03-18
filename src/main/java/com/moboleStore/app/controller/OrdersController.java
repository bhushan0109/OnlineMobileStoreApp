package com.moboleStore.app.controller;
//package com.thebookStore.app.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.thebookStore.app.entity.Orders;
//import com.thebookStore.app.entity.Payment;
//import com.thebookStore.app.exception.CartException;
//import com.thebookStore.app.exception.OrdersException;
//import com.thebookStore.app.exception.UsersException;
//import com.thebookStore.app.service.OrdersService;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//public class OrdersController {
//	
//	@Autowired
//	private OrdersService orderService;
//	
//	@PostMapping("/order")
//	public Orders registerOrder(@RequestBody Orders order) {
//		
//		return orderService.addOrder(order);
//	}
//	
//	@GetMapping("/order/{id}")
//	public Orders getOrderById(@PathVariable("id") Integer orderId) throws OrdersException {
//		
//		return orderService.getOrderById(orderId);
//	}
//	
//	@DeleteMapping("/order/{id}")
//	public Orders deleteOrderById(@PathVariable("id") Integer orderId) throws OrdersException  {
//		
//		return this.orderService.deleteOrderById(orderId);
//	
//	}
//	
//	@GetMapping("/orders")
//	public List<Orders> getAllOrders(){
//		
//		return orderService.getAllOrders();
//	}
//	
//	@PutMapping("/order")
//    public Orders updateOrder(@RequestBody Orders order) {
//		
//		return orderService.updateOrder(order);
//	}
//	
//	@PostMapping("order/{userid}")
//	public Orders  addOrderToUser(@PathVariable("userid") Integer userid, @RequestBody Orders order) throws UsersException{
//		return orderService.addOrderToUser(order, userid);
//		}
//	
//	@PostMapping("order/cart/{userid}")
//	public Orders getOrdersfromCart(@PathVariable("userid") Integer userid, Payment payment) throws UsersException, CartException{
//		return orderService.getOrdersFromCart(payment, userid);
//	}
//	
//	
//}
