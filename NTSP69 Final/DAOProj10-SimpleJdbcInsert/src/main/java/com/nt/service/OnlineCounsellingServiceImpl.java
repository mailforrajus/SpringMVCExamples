package com.nt.service;

import org.springframework.beans.BeanUtils;

import com.nt.bo.StudentCounsellingInfoBO;
import com.nt.dao.OnlineCounsellingDAO;
import com.nt.dto.StudentCounsellingInfoDTO;

public class OnlineCounsellingServiceImpl implements OnlineCounsellingService {
   	private  OnlineCounsellingDAO dao;
	
   	public OnlineCounsellingServiceImpl(OnlineCounsellingDAO dao) {
			this.dao = dao;
		}
    
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
