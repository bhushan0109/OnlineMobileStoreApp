package com.moboleStore.app.repositiory;

import java.util.List;

import com.moboleStore.app.entity.Cart;
import com.moboleStore.app.entity.Mobiles;
import com.moboleStore.app.exception.MobileNotFoundException;



public interface ICartRepository {

	public Mobiles addMobileItems(List<Mobiles> mobiles);
	public Mobiles deleteMobileItems(int mobileId) throws MobileNotFoundException;
	public Mobiles updateMobileItemquantity(int mobileId);
	public List<Mobiles> showAllMobileItems(int cartId);
	public int placeOrder(Cart cart);
	
}
