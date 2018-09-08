package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;
@Service("empService")
//@Named("empService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	//@Resource
	private EmployeeDAO dao;

	

	@Override
	public EmployeeDTO fetchEmployeeByNo(int empNo) {
		EmployeeBO bo=null;
		EmployeeDTO dto=null;
		//use DAO
		bo=dao.getEmployeeDetailsByNo(empNo);
		//convert BO to DTO
		dto=new  EmployeeDTO();
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}
	
	@Override
	public List<EmployeeDTO> fetchEmployeeByDesg(String desg) {
		List<EmployeeDTO> listDTO=new ArrayList();
		List<EmployeeBO> listBO=null;
		//use DAO
		listBO=dao.getEmployeeDetailsByDesg(desg);
		//Convert listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}//method
}//class
