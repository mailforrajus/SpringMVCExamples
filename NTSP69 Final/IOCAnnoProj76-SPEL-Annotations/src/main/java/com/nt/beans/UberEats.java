package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("uberEats")
public class UberEats {
	@Value("#{ord}")
	private Order order;
	@Value("#{ord.orderType}")
	private String orderType;
	@Value("#{ord.orderItems[0]}")
	private String firstOrderedItem;
	@Value("#{ord.orderItems[ord.orderItems.size()-1]}")
	private String lastlyOrderedItem;
	@Value("#{ord.orderItems.size()}")
	private int orderItemCount;
	@Value("#{ord.itemPrices['Biryani']+ord.itemPrices['Pizza']+ord.itemPrices['Burger']}")
	private float billAmt;
	@Value("#{systemProperties['java.vm.specification.vendor']}")
	private String  javaVendor;
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	public void setFirstOrderedItem(String firstOrderedItem) {
		this.firstOrderedItem = firstOrderedItem;
	}
	
	public void setLastlyOrderedItem(String lastlyOrderedItem) {
		this.lastlyOrderedItem = lastlyOrderedItem;
	}
	
	public void setOrderItemCount(int orderItemCount) {
		this.orderItemCount = orderItemCount;
	}
	
	public void setBillAmt(float billAmt) {
		this.billAmt = billAmt;
	}
	
	public void setJavaVendor(String javaVendor) {
		this.javaVendor = javaVendor;
	}

	@Override
	public String toString() {
		return "UberEats [order=" + order + ", orderType=" + orderType + ", firstOrderedItem=" + firstOrderedItem
				+ ", lastlyOrderedItem=" + lastlyOrderedItem + ", orderItemCount=" + orderItemCount + ", billAmt="
				+ billAmt + ", javaVendor=" + javaVendor + "]";
	}
	
	
}
