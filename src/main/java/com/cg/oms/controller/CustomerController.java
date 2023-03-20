package com.cg.oms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oms.dto.AddUserDto;
import com.cg.oms.entity.Cart;
import com.cg.oms.entity.Users;
import com.cg.oms.exception.CartException;
import com.cg.oms.exception.MobilesException;
import com.cg.oms.exception.UserNotFoundException;
import com.cg.oms.exception.UsersException;
import com.cg.oms.service.ICartService;
import com.cg.oms.service.IUserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private IUserService iUserService;
	@Autowired
	private ICartService cartService;

	@PutMapping("/edit/user")
	public AddUserDto UserServiceUpdate(@Valid @RequestBody AddUserDto addUserDto)
			throws UsersException, UserNotFoundException {
		return iUserService.updateUser(addUserDto);
	}

//	@DeleteMapping("/delete/{userId}")
//	public Users iUserServiceRemove(@PathVariable("userId") Integer userId)
//			throws UsersException, UserNotFoundException {
//		return iUserService.removeUser(userId);
//	}

	// @GetMapping("/allUsers")
	public List<Users> getUsers() {
		return iUserService.showAllUsers();
	}

	@GetMapping("/get/{userId}")
	public AddUserDto getUserById(@PathVariable("userId") Integer userId) throws UsersException {
		return iUserService.getUserByUserId(userId);
	}

//    @GetMapping("/allCustomer")
//    public List<AddUserDto> allCustomer() throws UsersException {
//        return iUserService.showAllCustomer();
	// }
//	@GetMapping("/mobilesincart/{customerId}")
//	@PreAuthorize("hasAuthority('User')")
//	public Cart getCartByUserId(@PathVariable("customerId") Integer customerId) throws CartException, UsersException {
//
//		return cartService.getCartByUserId(customerId);
//	}

	@GetMapping("/carts")
	@PreAuthorize("hasAuthority('User')")
	public List<Cart> getAllCarts() {
		return cartService.getAllCarts();
	}

	@DeleteMapping("/mobile/{mobileId}/{cartId}")
	@PreAuthorize("hasAuthority('User')")
	public Cart removeMobilefromCartByIds(@PathVariable("mobileId") Integer mobileId,
			@PathVariable("cartId") Integer cartId) throws CartException, MobilesException {

		return cartService.removeMobilefromCartByIds(mobileId, cartId);
	}
	
	

}
