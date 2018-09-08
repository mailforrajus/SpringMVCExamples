package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO dao;

	public EmployeeServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<EmployeeDTO> fetchEmpsByRange(int start, int end) {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		//use DAO
		listBO=dao.getEmpsByEnoRange(start, end);
		//convert listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		});
		return listDTO;
	}//method
	
	@Override
	public EmployeeDTO fetchEmpByEno(int no) {
		EmployeeBO bo=null;
		EmployeeDTO dto=null;
		//use DAO
		bo=dao.getEmpByEno(no);
		//convert BO to DTO
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}
	
	@Override
	public String updateEmpSalaryByDesg(String desg) {
		int count=0;
		//use DAO
		count=dao.updateSalaryByDesg(desg);
		if(count==0)
		  return "Updation failed";
		else
			return "Updation succeded";
	}

}
