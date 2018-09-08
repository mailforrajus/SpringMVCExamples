package com.nt.service;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.UserBO;
import com.nt.dao.LoginDAO;
import com.nt.dto.UserDTO;

@Named("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource
	private LoginDAO dao; 

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true,transactionManager="transactionManager")
	public String autheticate(UserDTO dto) {
		int count=0;
		UserBO bo=null;
		//convert DTO to BO
		bo=new UserBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.validate(bo);
		if(count==0)
			return "Authentication is Failed";
		else
			return "Authentication is succeded";
	}

}
