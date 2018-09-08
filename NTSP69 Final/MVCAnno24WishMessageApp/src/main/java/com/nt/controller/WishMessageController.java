package com.nt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.WishMessageService;

@Controller
public class WishMessageController {
	@Autowired
	private  WishMessageService service;
	
/*	@RequestMapping("/wish.htm")
	public ModelAndView process(){
		String resultMsg=null;
		ModelAndView  mav=null;
		//use service
		resultMsg=service.generateWishMessage();
		//keep in MAV
		mav=new ModelAndView();
		mav.addObject("wMsg",resultMsg);
		mav.setViewName("result");
		return mav;
		
	}
*/
	
/*	@RequestMapping("/wish.htm")
	public String process(ModelMap map){
		String resultMsg=null;
		//use service
		resultMsg=service.generateWishMessage();
		//keep in MAV
		map.put("wMsg",resultMsg);
		return "result";
		
	}
	*/
	/*@RequestMapping("/wish.htm")
	public String process(Model model){
		String resultMsg=null;
		//use service
		resultMsg=service.generateWishMessage();
		//keep in MAV
		model.addAttribute("wMsg",resultMsg);
		return "result";
	}
	*/
	
/*	@RequestMapping("/wish.htm")
	public String process(Map<String,String> map){
		String resultMsg=null;
		//use service
		resultMsg=service.generateWishMessage();
		//keep in MAV
		map.put("wMsg",resultMsg);
		return "result";
	}
*/	
	
	/*@RequestMapping("/wish.htm")  //It internally uses DefaultRequestToViewNameTransalator
	public void process(Map<String,String> map){
		String resultMsg=null;
		//use service
		resultMsg=service.generateWishMessage();
		//keep in MAV
		map.put("wMsg",resultMsg);
	
	}*/
	
	/*@RequestMapping("/wish.htm")  //It internally uses DefaultRequestToViewNameTransalator
	public Model process(){
		String resultMsg=null;
		Model model=null;
		//use service
		resultMsg=service.generateWishMessage();
		//create Model Object
		model=new ExtendedModelMap();
		model.addAttribute("wMsg",resultMsg);
		return model;
	}*/
	
	/*@RequestMapping("/wish.htm")  //It internally uses DefaultRequestToViewNameTransalator
	public ModelMap process(){
		String resultMsg=null;
		ModelMap model=null;
		//use service
		resultMsg=service.generateWishMessage();
		//create Model Object
		model=new ExtendedModelMap();
		model.addAttribute("wMsg",resultMsg);
		return model;
	}*/
	
	@RequestMapping("/wish.htm")  //It internally uses DefaultRequestToViewNameTransalator
	public Map<String,String> process(){
		String resultMsg=null;
		Map<String,String> map=null;
		//use service
		resultMsg=service.generateWishMessage();
		//create Model Object
		map=new HashMap();
		map.put("wMsg",resultMsg);
		return map;
	}
	
}
