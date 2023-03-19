package com.moboleStore.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moboleStore.app.entity.Cart;
import com.moboleStore.app.entity.Customer;
import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.exception.CartException;
import com.moboleStore.app.exception.MobilesException;
import com.moboleStore.app.exception.UsersException;
import com.moboleStore.app.repositiory.ICartRepository;
import com.moboleStore.app.repositiory.ICustomerRepository;
import com.moboleStore.app.repositiory.IMobileRepository;

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
		if (optCarts.isEmpty()) {
			throw new CartException("Cart id not found:" + cart.getCartId());
		}
		return cartRepository.save(cart);
	}

	@Override
	public Cart deleteCartById(Integer cartId) throws CartException {
		Optional<Cart> optCarts = this.cartRepository.findById(cartId);
		if (optCarts.isEmpty())
			throw new CartException("card id is not exists to delete !");
		Cart cart = optCarts.get();
		List<Mobiles> mobilesInCart = cart.getMobilesInCart();
		mobilesInCart.removeAll(mobilesInCart);
		cart.setQuantity(0);
		cart.setTotalCost(0.0f);
		Cart cartsave = cartRepository.save(cart);

		return cartsave;
	}

	@Override
	public Cart getCartByUserId(Integer customerId) throws UsersException {
		Optional<Customer> optCustomer = iCustomerRepository.findById(customerId);
		if (optCustomer.isEmpty()) {
			throw new UsersException("CustomerId not found:" + customerId);
		}
		return optCustomer.get().getCart();
	}

	@Override
	public Cart removeMobilefromCartByIds(Integer mobileId, Integer cartId) throws CartException, MobilesException {
		Optional<Cart> optCart = this.cartRepository.findById(cartId);
		if (optCart.isEmpty())
			throw new CartException("cart id does not exists to delete ");

		Cart foundCart = optCart.get();

		Optional<Mobiles> optMobiles = this.iMobileRepository.findById(mobileId);
		if (optMobiles.isEmpty()) {
			throw new MobilesException("Mobile id " + mobileId + " does not exists !");
		}
		Mobiles delmobile = optMobiles.get();

		List<Mobiles> mobiles = foundCart.getMobilesInCart();
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
		if (optCustomer.isEmpty()) {
			throw new UsersException("CustomerId not found:" + customerId);
		}

		Optional<Mobiles> optMobiles = this.iMobileRepository.findById(mobileId);
		if (optMobiles.isEmpty()) {
			throw new MobilesException("Mobile id " + mobileId + " does not exists !");
		}
		Mobiles mobile = optMobiles.get();

		if (optCustomer.get().getCart() == null) {
			List<Mobiles> mobilelist = new ArrayList<>();
			mobilelist.add(mobile);
			cart = new Cart();
			cart.setQuantity(mobilelist.size());
			cart.setTotalCost(mobile.getMobileCost());
			cart.setMobilesInCart(mobilelist);
		} else {

			cart = optCustomer.get().getCart();
			List<Mobiles> mobilesInCart = cart.getMobilesInCart();
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
