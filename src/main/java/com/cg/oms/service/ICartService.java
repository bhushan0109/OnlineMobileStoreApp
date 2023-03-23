package com.cg.oms.service;

import java.util.List;

import com.cg.oms.entity.Cart;
import com.cg.oms.entity.Mobiles;
import com.cg.oms.exception.CartException;
import com.cg.oms.exception.MobileNotFoundException;
import com.cg.oms.exception.MobilesException;
import com.cg.oms.exception.UsersException;

public interface ICartService {

	Cart updateCart(Cart cart) throws CartException;

	Cart deleteCartById(Integer Id) throws CartException;

	Cart getCartByUserId(Integer userId) throws UsersException, UsersException;

	List<Cart> getAllCarts();

	Cart removeMobilefromCartByIds(Integer mobileId, Integer cartId) throws CartException, MobilesException;

	Cart addMobileToCartBycustomerId(Integer mobileId, Integer customerId) throws  UsersException, CartException, MobilesException;


	
}
