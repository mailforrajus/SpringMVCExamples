package com.nt.beans;

public class UberEats {
	private Order order;
	private String orderType;
	private String firstOrderedItem;
	private String lastlyOrderedItem;
	private int orderItemCount;
	private float billAmt;
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
