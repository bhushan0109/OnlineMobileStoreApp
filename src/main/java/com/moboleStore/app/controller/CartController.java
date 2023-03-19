package com.moboleStore.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.moboleStore.app.entity.Cart;
import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.exception.CartException;
import com.moboleStore.app.exception.MobilesException;
import com.moboleStore.app.exception.UsersException;
import com.moboleStore.app.service.ICartService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("cart")
public class CartController {

	@Autowired
	private ICartService cartService;

	@PostMapping("/add/{customerId}/{mobileId}")
	public Cart addMobileToCartBycustomerId(@PathVariable("mobileId") Integer mobileId,
			@PathVariable("customerId") Integer customerId) throws CartException, UsersException, MobilesException {

		return cartService.addMobileToCartBycustomerId(mobileId, customerId);
	}

	@DeleteMapping("/delete/{cartId}")
	public Cart deleteCartById(@PathVariable("cartId") Integer cartId) throws CartException {

		return cartService.deleteCartById(cartId);
	}

	@GetMapping("/mobilesincart/{customerId}")
	public Cart getCartByUserId(@PathVariable("customerId") Integer customerId) throws CartException, UsersException {

		return cartService.getCartByUserId(customerId);
	}

	@GetMapping("/carts")
	public List<Cart> getAllCarts() {
		return cartService.getAllCarts();
	}

	@DeleteMapping("/mobile/{mobileId}/{cartId}")
	public Cart removeMobilefromCartByIds(@PathVariable("mobileId") Integer mobileId,
			@PathVariable("cartId") Integer cartId) throws CartException, MobilesException {

		return cartService.removeMobilefromCartByIds(mobileId, cartId);
	}

	// @PutMapping("/update")
	public Cart CartServiceUpdate(@Valid @RequestBody Cart cart) throws CartException {

		return cartService.updateCart(cart);
	}
}
