package com.nt.beans;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("wish")
//@Lazy(true)
@DependsOn("cal")
public class WishMessageGenerator {
	@Autowired
  private Calendar calendar;	
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator:0-param constructor");
	}
	
	public  String generateWishMessage(String uname){
		int hour=0;
		//get current hour of  the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//generate Wish message
		if(hour<=12)
			 return "Good morning:"+uname;
		else if(hour<=16)
			return "Good AfterNoon:"+uname;
		else if(hour<=20)
			return "Good Evening:"+uname;
		else 
			return "Good night :"+uname;
	}//method
}//class
