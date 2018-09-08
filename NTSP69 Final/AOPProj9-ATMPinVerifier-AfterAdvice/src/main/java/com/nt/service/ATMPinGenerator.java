package com.nt.service;

import java.util.Random;

public class ATMPinGenerator {
	
	public int[] generatePin(){
		Random rad=null;
		int pin[]=new int[1];
		rad=new Random();
		pin[0]=rad.nextInt(9999);
		System.out.println(pin[0]);
		return pin;
		
	}
	
	

}
