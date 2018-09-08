package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesController {
	
	@RequestMapping("/home.htm")
	public  String showHomePage(){
		return "homePageDef";
	}
	
	@RequestMapping("/nit.htm")
	public  String showNitPage(){
		return "nitPageDef";
	}
	
	@RequestMapping("/java.htm")
	public  String showJavaPage(){
		return "javaPageDef";
	}
	
	@RequestMapping("/dotNet.htm")
	public  String showdotNetPage(){
		return "dotNetPageDef";
	}

}
