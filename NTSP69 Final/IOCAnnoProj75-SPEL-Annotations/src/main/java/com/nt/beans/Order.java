package com.nt.beans;

import java.util.List;
import java.util.Map;

public class Order {
	private int orderId;
	private String orderType;
	private List<String> orderItems;
	private Map<String,Float> itemPrices;
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public void setOrderItems(List<String> orderItems) {
		this.orderItems = orderItems;
	}
	public void setItemPrices(Map<String, Float> itemPrices) {
		this.itemPrices = itemPrices;
	}
	public int getOrderId() {
		return orderId;
	}
	public String getOrderType() {
		return orderType;
	}
	public List<String> getOrderItems() {
		return orderItems;
	}
	public Map<String, Float> getItemPrices() {
		return itemPrices;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderType=" + orderType + ", orderItems=" + orderItems + ", itemPrices="
				+ itemPrices + "]";
	}
	
	

}
