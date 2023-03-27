package com.cg.oms.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oms.entity.Cart;
import com.cg.oms.entity.Customer;
import com.cg.oms.entity.Mobiles;
import com.cg.oms.exception.CartException;
import com.cg.oms.exception.MobilesException;
import com.cg.oms.exception.UsersException;
import com.cg.oms.repositiory.ICartRepository;
import com.cg.oms.repositiory.ICustomerRepository;
import com.cg.oms.repositiory.IMobileRepository;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private ICartRepository cartRepository;

	@Autowired
	private IMobileRepository iMobileRepository;

	@Autowired
	private ICustomerRepository iCustomerRepository;

	@Override
	public Cart updateCart(Cart cart) throws CartException {
		Optional<Cart> optCarts = cartRepository.findById(cart.getCartId());
		if (!optCarts.isPresent()) {
			throw new CartException("Cart id not found:" + cart.getCartId());
		}
		return cartRepository.save(cart);
	}

	@Override
	public Cart deleteCartById(Integer cartId) throws CartException {
		Optional<Cart> optCarts = this.cartRepository.findById(cartId);
		if (!optCarts.isPresent())
			throw new CartException("card id is not exists to delete !");
		Cart cart = optCarts.get();
		Set<Mobiles> mobilesInCart = cart.getMobilesInCart();
		mobilesInCart.removeAll(mobilesInCart);
		cart.setQuantity(0);
		cart.setTotalCost(0.0f);
		Cart cartsave = cartRepository.save(cart);

		return cartsave;
	}

	@Override
	public Cart getCartByUserId(Integer customerId) throws UsersException {
		Optional<Customer> optCustomer = iCustomerRepository.findById(customerId);
		if (!optCustomer.isPresent()) {
			throw new UsersException("CustomerId not found:" + customerId);
		}
		return optCustomer.get().getCart();
	}

	@Override
	public Cart removeMobilefromCartByIds(Integer mobileId, Integer cartId) throws CartException, MobilesException {
		Optional<Cart> optCart = this.cartRepository.findById(cartId);
		if (!optCart.isPresent())
			throw new CartException("cart id does not exists to delete ");

		Cart foundCart = optCart.get();

		Optional<Mobiles> optMobiles = this.iMobileRepository.findById(mobileId);
		if (!optMobiles.isPresent()) {
			throw new MobilesException("Mobile id " + mobileId + " does not exists !");
		}
		Mobiles delmobile = optMobiles.get();

		Set<Mobiles> mobiles = foundCart.getMobilesInCart();
		mobiles.remove(delmobile);

		foundCart.setMobilesInCart(mobiles);
		Integer quantity = foundCart.getQuantity();
		quantity = quantity - 1;

		foundCart.setQuantity(quantity);
		Float cost = foundCart.getTotalCost() - delmobile.getMobileCost();
		foundCart.setTotalCost(cost);

		Cart savecart = cartRepository.save(foundCart);

		return savecart;
	}

	@Override
	public List<Cart> getAllCarts() {

		return cartRepository.findAll();
	}

	@Override
	public Cart addMobileToCartBycustomerId(Integer mobileId, Integer customerId)
			throws UsersException, CartException, MobilesException {
		Cart cart = null;
		Optional<Customer> optCustomer = iCustomerRepository.findById(customerId);
		if (!optCustomer.isPresent()) {
			throw new UsersException("CustomerId not found:" + customerId);
		}

		Optional<Mobiles> optMobiles = this.iMobileRepository.findById(mobileId);
		if (!optMobiles.isPresent()) {
			throw new MobilesException("Mobile id " + mobileId + " does not exists !");
		}
		Mobiles mobile = optMobiles.get();

		if (optCustomer.get().getCart() == null) {
			Set<Mobiles> mobilelist = new HashSet<Mobiles>();
			mobilelist.add(mobile);
			cart = new Cart();
			cart.setQuantity(mobilelist.size());
			cart.setTotalCost(mobile.getMobileCost());
			cart.setMobilesInCart(mobilelist);
		} else {

			cart = optCustomer.get().getCart();
			Set<Mobiles> mobilesInCart = cart.getMobilesInCart();
			Float totalCost = cart.getTotalCost();
			Integer quantity = cart.getQuantity();

			cart.setQuantity(quantity + 1);
			cart.setTotalCost(totalCost + mobile.getMobileCost());
			mobilesInCart.add(mobile);
			cart.setMobilesInCart(mobilesInCart);

		}
		Cart savecart = cartRepository.save(cart);
		Customer customer = optCustomer.get();
		customer.setCart(savecart);
		iCustomerRepository.save(customer); // new card added with one mobile added
		return cart;

	}

}
