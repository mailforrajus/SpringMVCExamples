package com.nt.beans;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wish")
public class WishMessageGenerator {
	
	static{
		System.out.println(" WishMessageGenerator:static block");
	}
	
	@Autowired
	private Calendar calendar;
	
	
	public String generateWishMessage(String user){
		int  hour=0;
		//get current hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//write b.logic
		if(hour<12)
			return "Good Morning::"+user;
		else if(hour<16)
			return "Good After Noon:"+user;
		else if(hour<20)
			return "Good Evening :"+user;
		else 
			return "Good Night:"+user;
		
	}

}
