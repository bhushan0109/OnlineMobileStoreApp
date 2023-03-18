package com.moboleStore.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moboleStore.app.entity.Cart;
import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.entity.Users;
import com.moboleStore.app.exception.CartException;
import com.moboleStore.app.exception.MobileNotFoundException;
import com.moboleStore.app.exception.MobilesException;
import com.moboleStore.app.exception.UsersException;
import com.moboleStore.app.repositiory.CartRepository;
import com.moboleStore.app.repositiory.ICustomerRepository;
import com.moboleStore.app.repositiory.IMobileRepository;
import com.moboleStore.app.repositiory.IUserRepository;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private IMobileRepository iMobileRepository;

	@Autowired
	private ICustomerRepository iCustomerRepository;

	@Autowired
	private IUserRepository iUserRepository;

//	@Autowired
//	private UserService userService;

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
			throw new CartException("Customer id is not exists to delete !");
		Cart cart = optCarts.get();
		this.cartRepository.delete(cart);

		return cart;
	}

	@Override
	public Cart getCartById(Integer userId) throws UsersException {
		Optional<Users> optUser = iUserRepository.findById(userId);
		if (optUser.isEmpty()) {
			throw new UsersException("User id not found:" + userId);
		}

		return optUser.get().getCart();
	}

	@Override
	public Mobiles removeMobilefromCartByIds(Integer mobileId, Integer cartId) throws CartException, MobilesException {
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
		cartRepository.save(foundCart);
		return delmobile;
	}

	@Override
	public List<Cart> getAllCarts() {

		return cartRepository.findAll();
	}

	@Override
	public Cart addMobileToCartByUserId(Integer mobileId, Integer userId)
			throws UsersException, CartException, MobilesException {
		Cart cart = null;
		Optional<Users> optUser = iUserRepository.findById(userId);
		if (optUser.isEmpty()) {
			throw new UsersException("User id not found:" + userId);
		}

		Optional<Mobiles> optMobiles = this.iMobileRepository.findById(mobileId);
		if (optMobiles.isEmpty()) {
			throw new MobilesException("Mobile id " + mobileId + " does not exists !");
		}
		Mobiles mobile = optMobiles.get();

		if (optUser.get().getCart() == null) {
			List<Mobiles> mobilelist = new ArrayList<>();
			mobilelist.add(mobile);
			cart = new Cart();
			cart.setQuantity(mobilelist.size());
			cart.setTotalCost(mobile.getMobileCost());
			cart.setMobilesInCart(mobilelist);
		} else {

			cart = optUser.get().getCart();
			List<Mobiles> mobilesInCart = cart.getMobilesInCart();
			Float totalCost = cart.getTotalCost();
			Integer quantity = cart.getQuantity();

			cart.setQuantity(mobilesInCart.size() + 1);
			cart.setTotalCost(mobile.getMobileCost() + mobile.getMobileCost());
			mobilesInCart.add(mobile);
			cart.setMobilesInCart(mobilesInCart);

		}
		Users users = optUser.get();
		users.setCart(cart);
		iUserRepository.save(users); // new card added with one mobile added
		return cart;

	}

}
