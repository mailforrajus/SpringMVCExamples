package com.nt.service;

public class BillAmountCalculator {
	public int calcPrice(int price ,int qty){
		if(price==0 || qty==0){
			throw new IllegalArgumentException("Invalid inputs");
		}
		else{
			return price*qty;
		}
	}

}
