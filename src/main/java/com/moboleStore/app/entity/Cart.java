package com.moboleStore.app.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue
	private Integer cartId;

	private Float totalCost;
	private Integer quantity;

	@ManyToMany
	private List<Mobiles> mobilesInCart;

	public Cart() {
		super();
	}

	public Integer getCartId() {
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public List<Mobiles> getMobilesInCart() {
		return mobilesInCart;
	}

	public void setMobilesInCart(List<Mobiles> mobilesInCart) {
		this.mobilesInCart = mobilesInCart;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalCost=" + totalCost + ", quantity=" + quantity + ", mobilesInCart="
				+ mobilesInCart + "]";
	}

	public Cart(Integer cartId, Float totalCost, Integer quantity, List<Mobiles> mobilesInCart) {
		super();
		this.cartId = cartId;
		this.totalCost = totalCost;
		this.quantity = quantity;
		this.mobilesInCart = mobilesInCart;
	}

}