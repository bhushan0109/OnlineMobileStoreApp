package com.cg.oms.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;

	private Float totalCost;
	private int quantity;

	@ManyToMany
	private Set<Mobiles> mobilesInCart;

	// private Set<Mobiles> mobiles = new HashSet<Mobiles>();

	public Cart() {
		super();
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Set<Mobiles> getMobilesInCart() {
		return mobilesInCart;
	}

	public void setMobilesInCart(Set<Mobiles> mobilesInCart) {
		this.mobilesInCart = mobilesInCart;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalCost=" + totalCost + ", quantity=" + quantity + ", mobilesInCart="
				+ mobilesInCart + "]";
	}

	public Cart(int cartId, Float totalCost, int quantity, Set<Mobiles> mobilesInCart) {
		super();
		this.cartId = cartId;
		this.totalCost = totalCost;
		this.quantity = quantity;
		this.mobilesInCart = mobilesInCart;
	}

}