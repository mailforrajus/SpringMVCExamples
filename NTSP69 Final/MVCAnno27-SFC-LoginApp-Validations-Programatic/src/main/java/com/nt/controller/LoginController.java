package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;
import com.nt.validator.LoginValidator;

@Controller
public class LoginController {
	@Autowired
	private LoginService service;
	@Autowired
	private LoginValidator validator;
	
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
			                                         @ModelAttribute("userCmd") UserCommand cmd,
			                                         BindingResult errors){
		 UserDTO dto=null;
		 String result=null;
		 
		 if(cmd.getVflag().equalsIgnoreCase("no")){
			 
		 //use validator
		  if(validator.supports(UserCommand.class)){
			       validator.validate(cmd, errors);
			       System.out.println("server form valiations are done");
			   if(errors.hasErrors()){
				   return "login";
			   }
		  }
		  else{
			  return "login";
		  }
		 }
		  //convert Command obj DTO obj
		 dto=new UserDTO();
		 BeanUtils.copyProperties(cmd, dto);
		 //use service
		 result=service.authenticate(dto);
		//keep result in Map obj
		 map.put("resMsg",result);
		return "login";
	}//method
}//class
