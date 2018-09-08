package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import com.nt.dto.PassengerDetailsDTO;
import com.nt.service.PassengerService;
import com.nt.vo.PassengerDetailsVO;

public class PassengerController {
	private  PassengerService service;
	
	
	public PassengerController(PassengerService service) {
		this.service = service;
	}


	public String  processForGroupReservation(List<PassengerDetailsVO> listVO){
		List<PassengerDetailsDTO> listDTO=new ArrayList();
		String result=null;
		
		//conver ListVO to ListDTO
		listVO.forEach(vo->{
		   PassengerDetailsDTO dto=new PassengerDetailsDTO();
		   dto.setName(vo.getName());
		   dto.setSourcePlace(vo.getSourcePlace());
		   dto.setDestPlace(vo.getDestPlace());
		   dto.setFare(Float.parseFloat(vo.getFare()));
		   //add dto to ListDTO
		   listDTO.add(dto);
		});
		//use service
		result=service.groupReseveration(listDTO);
		return result;
	}//method
}//class
