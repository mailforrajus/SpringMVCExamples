package com.nt.service;

public class ShoppingStore {
	
	public  int  generateBillAmount(String [] items){
		int billAmt=0;
		billAmt=items.length*1000;
		return billAmt;
		
	}

}
