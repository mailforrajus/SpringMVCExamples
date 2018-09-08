package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService service;
	
	/* for initial phase request */
	/*@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String  showForm(@ModelAttribute("userCmd") UserCommand cmd){
		return "login";
	}*/
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String  showForm(Map<String,Object> map){
		UserCommand cmd=null;
		//create Command class obj
		cmd=new UserCommand();
		cmd.setUsername("rajesh"); cmd.setPassword("hyd123");
		//add Command class obj Map object
		map.put("userCmd",cmd);
		
		return "login";
	}
	
	/* for post back request */
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public String  processForm(Map<String,Object> map,
			                                         @ModelAttribute("userCmd") @Valid UserCommand cmd,
			                                         BindingResult errors){
		 UserDTO dto=null;
		 String result=null;
		
		    if(errors.hasErrors())
		    	return "login";
		 
		  //convert Command obj DTO obj
		 dto=new UserDTO();
		 BeanUtils.copyProperties(cmd, dto);
		 //use service
		 result=service.authenticate(dto);
		//keep result in Map obj
		 map.put("resMsg",result);
		return "login";
	}//method
	
	
	@ModelAttribute("countriesList")
	public List<String>  addCountries(){
		List<String> countries=null;
		countries=new ArrayList();
		countries.add("india"); countries.add("pakistan");
		countries.add("USA"); countries.add("japan");
		return countries;
	}
	
	
	@ModelAttribute("hobiesList")
	public List<String>  addHobies(){
		List<String> hobies=null;
		hobies=new ArrayList();
		hobies.add("medidation"); hobies.add("sleeping");
		hobies.add("Eating"); hobies.add("airforce");
		return hobies;
	}
	
	@InitBinder
	public void   dateBinder(WebDataBinder binder){
		SimpleDateFormat sdf=null;
		sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
	}
	
	
}//class
