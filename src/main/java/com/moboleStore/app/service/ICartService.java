package com.moboleStore.app.service;

import java.util.List;

import com.moboleStore.app.entity.Cart;
import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.exception.CartException;
import com.moboleStore.app.exception.MobileNotFoundException;
import com.moboleStore.app.exception.MobilesException;
import com.moboleStore.app.exception.UsersException;

public interface ICartService {

	Cart updateCart(Cart cart) throws CartException;

	Cart deleteCartById(Integer Id) throws CartException;

	Cart getCartByUserId(Integer userId) throws UsersException, UsersException;

	List<Cart> getAllCarts();

	Cart removeMobilefromCartByIds(Integer mobileId, Integer cartId) throws CartException, MobilesException;

	Cart addMobileToCartByUserId(Integer bookId, Integer userId) throws  UsersException, CartException, MobilesException;

	
}
