package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.UserCommand;

@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		     System.out.println("LoginValidator.supports(-)");
				return clazz.isAssignableFrom(UserCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("LoginValidator.validate(-,-)");
		UserCommand cmd=null;
		//type casting
		cmd=(UserCommand)target;
		//server side form validation logic
	    if(cmd.getUsername().equals("") || cmd.getUsername().length()==0)
	    	errors.rejectValue("username","login.username");
	    if(cmd.getPassword().equals("") || cmd.getPassword().length()==0)
	    	errors.rejectValue("password","login.password");
	}//method
}//class
