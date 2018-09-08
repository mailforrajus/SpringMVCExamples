package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.StudentCounsellingInfoBO;
import com.nt.dao.OnlineCounsellingDAO;
import com.nt.dto.StudentCounsellingInfoDTO;

@Service("counsellingService")
public class OnlineCounsellingServiceImpl implements OnlineCounsellingService {
   @Autowired
	private  OnlineCounsellingDAO dao;
	
   
    
	@Override
	public String register(StudentCounsellingInfoDTO dto) {
		StudentCounsellingInfoBO bo=null;
		int count=0;
		//Convert DTO to BO
		bo=new StudentCounsellingInfoBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.insert(bo);
		if(count==0)
			return "Registration failed";
		else
			return "Registraion successful";
	}//method
}//class
