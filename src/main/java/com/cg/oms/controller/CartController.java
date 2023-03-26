package com.cg.oms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.cg.oms.entity.Cart;
import com.cg.oms.entity.Mobiles;
import com.cg.oms.exception.CartException;
import com.cg.oms.exception.MobilesException;
import com.cg.oms.exception.UsersException;
import com.cg.oms.service.ICartService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("cart")
public class CartController {

	@Autowired
	private ICartService cartService;

	@PostMapping("/add/{customerId}/{mobileId}")
	@PreAuthorize("hasAuthority('User')")
	public Cart addMobileToCartBycustomerId(@PathVariable("mobileId") Integer mobileId,
			@PathVariable("customerId") Integer customerId) throws CartException, UsersException, MobilesException {

		return cartService.addMobileToCartBycustomerId(mobileId, customerId);
	}

//	@DeleteMapping("/delete/{cartId}")
//	@PreAuthorize("hasAuthority('User')")
//	public Cart deleteCartById(@PathVariable("cartId") Integer cartId) throws CartException {
//
//		return cartService.deleteCartById(cartId);
//	}

	@GetMapping("/mobilesincart/{customerId}")
	@PreAuthorize("hasAuthority('User')")
	public Cart getCartByUserId(@PathVariable("customerId") Integer customerId) throws CartException, UsersException {

		return cartService.getCartByUserId(customerId);
	}
//
//	@GetMapping("/carts")
//	@PreAuthorize("hasAuthority('User')")
//	public List<Cart> getAllCarts() {
//		return cartService.getAllCarts();
//	}

//	@DeleteMapping("/mobile/{mobileId}/{cartId}")
//	@PreAuthorize("hasAuthority('User')")
//	public Cart removeMobilefromCartByIds(@PathVariable("mobileId") Integer mobileId,
//			@PathVariable("cartId") Integer cartId) throws CartException, MobilesException {
//
//		return cartService.removeMobilefromCartByIds(mobileId, cartId);
//	}

	@PutMapping("/update")
	@PreAuthorize("hasAuthority('User')")
	public Cart CartServiceUpdate(@Valid @RequestBody Cart cart) throws CartException {

		return cartService.updateCart(cart);
	}
}
