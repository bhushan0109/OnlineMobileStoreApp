package com.moboleStore.app.dto;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OrdersDto {

	private Integer orderId;

	private Integer quantity;

	@Min(value = 0, message = "Cost should not be negative")
	private Float cost;

	@Min(value = 0, message = "totalCost should not be negative")
	private Float totalCost;
	@JsonIgnore
	private String orderStatus;

	private Set<Integer> mobilesId;

	private int customerId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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

	public Set<Integer> getMobilesId() {
		return mobilesId;
	}

	public void setMobilesId(Set<Integer> mobilesId) {
		this.mobilesId = mobilesId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "OrdersDto [orderId=" + orderId + ", quantity=" + quantity + ", cost=" + cost + ", totalCost="
				+ totalCost + ", orderStatus=" + orderStatus + ", mobilesId=" + mobilesId + ", customerId=" + customerId
				+ "]";
	}

}
