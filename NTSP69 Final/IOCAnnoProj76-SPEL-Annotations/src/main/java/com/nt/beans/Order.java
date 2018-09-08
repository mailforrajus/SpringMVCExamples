package com.nt.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("ord")
public class Order {
	@Value("#{ T(java.lang.Math).random()*100}")
	private int orderId;
	@Value("urgent")
	private String orderType;
	
	private List<String> orderItems;
	private Map<String,Float> itemPrices;
	
	public Order() {
		orderItems=new ArrayList();
		orderItems.add("Biryani");
		orderItems.add("Pizza");orderItems.add("Burger");
		
		itemPrices=new HashMap();
		itemPrices.put("Biryani", 270.0f);
		itemPrices.put("Pizza",70.0f);
		itemPrices.put("Burger", 15.0f);
		
		
	}
	
	
	
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
