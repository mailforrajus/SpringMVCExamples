package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.EmployeeBO;
import com.nt.bo.EmployeeResultBO;
import com.nt.dao.EmployeeSearchDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.EmployeeResultDTO;

@Service("empService")
public class EmployeeSearchServiceImpl implements EmployeeSearchService {
	@Autowired
	private EmployeeSearchDAO dao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<EmployeeResultDTO> findEmployees(EmployeeDTO dto) {
		 EmployeeBO bo=null;
		 List<EmployeeResultBO> listRBO=null; 
		 List<EmployeeResultDTO>listRDTO=null;
		 EmployeeResultDTO rdto=null;
		//Convert DTO to BO
		 bo=new EmployeeBO();
		 BeanUtils.copyProperties(dto,bo);
		 //use DAO
		 listRBO=dao.search(bo);
		 // Convert listRBO to listRDTO
		 listRDTO=new ArrayList();
		 for(EmployeeResultBO rbo:listRBO){
			 rdto=new EmployeeResultDTO();
			 rdto.setSno(listRDTO.size()+1);
			 BeanUtils.copyProperties(rbo,rdto);
			 listRDTO.add(rdto);
		 }
		return listRDTO;
	}//method
}//class

