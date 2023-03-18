package com.moboleStore.app.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	private Integer orderId;

	@FutureOrPresent
	private LocalDate orderDate;

	@FutureOrPresent
	private LocalDate dispachDate;
	private Integer quantity;

	@Min(value = 0, message = "Cost should not be negative")
	private Float cost;

	@Min(value = 0, message = "totalCost should not be negative")
	private Float totalCost;
	private String orderStatus;

	@OneToMany
	private List<Mobiles> mobiles = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Orders() {
		super();
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDispachDate() {
		return dispachDate;
	}

	public void setDispachDate(LocalDate dispachDate) {
		this.dispachDate = dispachDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<Mobiles> getMobiles() {
		return mobiles;
	}

	public void setMobiles(List<Mobiles> mobiles) {
		this.mobiles = mobiles;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", dispachDate=" + dispachDate
				+ ", quantity=" + quantity + ", cost=" + cost + ", totalCost=" + totalCost + ", orderStatus="
				+ orderStatus + ", mobiles=" + mobiles + ", customer=" + customer + "]";
	}

	public Orders(Integer orderId, @FutureOrPresent LocalDate orderDate, @FutureOrPresent LocalDate dispachDate,
			Integer quantity, @Min(value = 0, message = "Cost should not be negative") Float cost,
			@Min(value = 0, message = "totalCost should not be negative") Float totalCost, String orderStatus,
			List<Mobiles> mobiles, Customer customer) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.dispachDate = dispachDate;
		this.quantity = quantity;
		this.cost = cost;
		this.totalCost = totalCost;
		this.orderStatus = orderStatus;
		this.mobiles = mobiles;
		this.customer = customer;
	}

}
