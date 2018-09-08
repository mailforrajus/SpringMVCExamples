package com.nt.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GetBalanceController  {

	@RequestMapping("/getBal.htm")
	public String handle(Map<String,Object> map) {
			map.put("bal",new Random().nextInt(1000000));
		return "show_balance";
	}

}
