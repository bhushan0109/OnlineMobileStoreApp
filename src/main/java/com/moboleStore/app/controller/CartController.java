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

	@PostMapping("/add/{userid}/{mobieId}")
	public Cart addMobileToCartByUserId(@PathVariable("mobieId") Integer mobieId,@PathVariable("userid") Integer userId)
			throws CartException, UsersException, MobilesException {

		return cartService.addMobileToCartByUserId(mobieId, userId);
	}

	@PutMapping("/update")
	public Cart CartServiceUpdate(@Valid @RequestBody Cart cart) throws CartException {

		return cartService.updateCart(cart);
	}

	@DeleteMapping("/delete/{cartId}")
	public Cart deleteCartById(@PathVariable("cartId") Integer cartId) throws CartException {

		return cartService.deleteCartById(cartId);
	}

	@GetMapping("/mobilesincart/{userId}")
	public Cart getCartByUserId(@PathVariable("userId") Integer userId) throws CartException, UsersException {

		return cartService.getCartById(userId);
	}

	@GetMapping("/carts")
	public List<Cart> getAllCarts() {
		return cartService.getAllCarts();
	}

	@DeleteMapping("/mobile/{mobileId}/{cartId}")
	public Mobiles removeMobilefromCartByIds(@PathVariable("mobileId") Integer mobileId,@PathVariable("cartId") Integer cartId) throws CartException, MobilesException {

		return cartService.removeMobilefromCartByIds(mobileId, cartId);
	}
}
