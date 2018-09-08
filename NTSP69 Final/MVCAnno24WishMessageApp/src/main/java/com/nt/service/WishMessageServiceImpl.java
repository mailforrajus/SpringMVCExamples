package com.nt.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageServiceImpl implements WishMessageService {

	@Override
	public String generateWishMessage() {
		Calendar cal=null;
		int hour=0;
		//get System Date
		cal=Calendar.getInstance();
		//get current hour of day
		hour=cal.get(Calendar.HOUR_OF_DAY);
		//generate wish message
		if(hour<12)
			return "Good Morning";
		else if(hour<16)
			return "Good AfterNoon";
		else if(hour<20)
			return "Good Evening";
		else
			return "Good night";
	}

}
