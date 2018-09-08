package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.PassengerDetailsBO;
import com.nt.dao.PassengerDAO;
import com.nt.dto.PassengerDetailsDTO;

public class PassengerServiceImpl implements PassengerService {
	  private  PassengerDAO dao;

	public PassengerServiceImpl(PassengerDAO dao) {
		this.dao = dao;
	}

	@Override
	public String groupReseveration(List<PassengerDetailsDTO> listDTO) {
		List<PassengerDetailsBO> listBO=new ArrayList();
		int result[]=null;
	
		//convert ListDTO to ListBO
		listDTO.forEach(dto->{
			PassengerDetailsBO bo=new PassengerDetailsBO();
			BeanUtils.copyProperties(dto,bo);
			listBO.add(bo);
		});
		//use DAO
		result=dao.insert(listBO);
		 if(result!=null)
			  return "Group Reservation is done";
		 else
			 return "Group Reservation is not done";
	}//method

}//class
