package com.cg.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.cg.oms.dto.OrdersDto;
import com.cg.oms.entity.Orders;
import com.cg.oms.exception.CartException;
import com.cg.oms.exception.MobilesException;
import com.cg.oms.exception.OrderNotFoundException;
import com.cg.oms.exception.OrdersException;
import com.cg.oms.exception.UsersException;
import com.cg.oms.service.IOrderService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("order")
public class OrdersController {

	@Autowired
	private IOrderService iOrderService;

	@PostMapping("/place")
	@PreAuthorize("hasAuthority('User')")
	public Orders addOrder(@RequestBody OrdersDto OrdersDto) throws UsersException, MobilesException {

		return iOrderService.addOrder(OrdersDto);

	}

	@PutMapping("/update")
	@PreAuthorize("hasAuthority('User')")
	public Orders updateOrder(@RequestBody OrdersDto ordersDto)
			throws OrderNotFoundException, OrdersException, MobilesException {

		return iOrderService.updateOrder(ordersDto);
	}

	@GetMapping("/get/{orderId}")
	@PreAuthorize("hasAuthority('User')")
	public Orders getOrderById(@PathVariable("orderId") Integer orderId) throws OrdersException {

		return iOrderService.getOrderById(orderId);
	}

	@DeleteMapping("/delete/{orderId}")
	@PreAuthorize("hasAuthority('User')")
	public Orders cancelOrder(@PathVariable("orderId") Integer orderId) throws OrdersException, OrderNotFoundException {

		return this.iOrderService.cancelOrder(orderId);

	}

//	@GetMapping("/getAll/orders")
//	public List<Orders> getAllOrders() {
//
//		return iOrderService.getAllOrders();
//	}

	@PostMapping("placedOrderFromCart/{customerId}/{cartId}")
	@PreAuthorize("hasAuthority('User')")
	public Orders  placedOrderFromCart(@PathVariable("customerId") Integer customerId, @PathVariable("cartId") Integer cartId) throws UsersException, CartException{
		return iOrderService.placedOrderFromCart(customerId, cartId);
		}

//	@PostMapping("order/cart/{userid}")
//	public Orders getOrdersfromCart(@PathVariable("userid") Integer userid,) throws UsersException, CartException{
//		return iOrderService.getOrdersFromCart(payment, userid);
//	}

}
