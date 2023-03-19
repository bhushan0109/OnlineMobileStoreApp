package com.moboleStore.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.moboleStore.app.dto.OrdersDto;
import com.moboleStore.app.entity.Orders;
import com.moboleStore.app.exception.CartException;
import com.moboleStore.app.exception.MobilesException;
import com.moboleStore.app.exception.OrderNotFoundException;
import com.moboleStore.app.exception.OrdersException;
import com.moboleStore.app.exception.UsersException;
import com.moboleStore.app.service.IOrderService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("order")
public class OrdersController {

	@Autowired
	private IOrderService iOrderService;

	@PostMapping("/place")
	public Orders addOrder(@RequestBody OrdersDto OrdersDto) throws UsersException, MobilesException {

		return iOrderService.addOrder(OrdersDto);

	}

	@PutMapping("/update")
	public Orders updateOrder(@RequestBody OrdersDto ordersDto)
			throws OrderNotFoundException, OrdersException, MobilesException {

		return iOrderService.updateOrder(ordersDto);
	}

	@GetMapping("/get/{orderId}")
	public Orders getOrderById(@PathVariable("orderId") Integer orderId) throws OrdersException {

		return iOrderService.getOrderById(orderId);
	}

	@DeleteMapping("/delete/{orderId}")
	public Orders cancelOrder(@PathVariable("orderId") Integer orderId) throws OrdersException, OrderNotFoundException {

		return this.iOrderService.cancelOrder(orderId);

	}

	@GetMapping("/getAll/orders")
	public List<Orders> getAllOrders() {

		return iOrderService.getAllOrders();
	}

	@PostMapping("placedOrderFromCart/{customerId}/{cartId}")
	public Orders  placedOrderFromCart(@PathVariable("customerId") Integer customerId, @PathVariable("cartId") Integer cartId) throws UsersException, CartException{
		return iOrderService.placedOrderFromCart(customerId, cartId);
		}

//	@PostMapping("order/cart/{userid}")
//	public Orders getOrdersfromCart(@PathVariable("userid") Integer userid,) throws UsersException, CartException{
//		return iOrderService.getOrdersFromCart(payment, userid);
//	}

}
