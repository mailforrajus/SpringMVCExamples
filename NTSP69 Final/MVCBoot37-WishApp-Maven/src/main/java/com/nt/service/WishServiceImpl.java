package com.nt.service;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishServiceImpl implements WishService {

	@Override
	public String generateWishMessage() {
		return "Good Morning ::";
	}

}
