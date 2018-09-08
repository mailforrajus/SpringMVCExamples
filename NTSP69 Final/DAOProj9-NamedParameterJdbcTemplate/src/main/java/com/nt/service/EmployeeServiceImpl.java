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
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    private  EmployeeDAO dao;
	
	@Override
	public int fetchEmpsCountByEnoRange(int start, int end) {
		int count;
		//use dao
		count=dao.getEmpsCountByEnoRange(start, end);
		return count;
	}
	
	@Override
	public List<EmployeeDTO> fetchEmpsByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		//use DAO
		listBO=dao.getEmpsByDesgs(desg1, desg2, desg3);
		//convert listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		});
		return listDTO;
	}
	
	@Override
	public String register(EmployeeDTO dto) {
		EmployeeBO bo=null;
		int count=0;
		//Convert  DTO to BO
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.insert(bo);
		if(count==0)
			return "Registration Failed";
		else
			return "Registration succeded";
	}//method
}//class
