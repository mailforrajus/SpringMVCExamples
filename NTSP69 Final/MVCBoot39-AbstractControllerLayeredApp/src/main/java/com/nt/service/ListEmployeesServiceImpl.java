package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.ListEmployeesDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class ListEmployeesServiceImpl implements ListEmployeeService {
  @Autowired
	private ListEmployeesDAO dao;


	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=null;
		EmployeeDTO dto=null;
		//use DAO
		listBO=dao.retriveAllEmployees();
		//Convert listBO to listDTO
		listDTO=new ArrayList();
		for(EmployeeBO bo:listBO){
			dto=new EmployeeDTO();
			dto.setSno(listDTO.size()+1);
			dto.setEmpNo(bo.getEmpNo());
			dto.setEname(bo.getEname());
			dto.setDesg(bo.getDesg());
			dto.setSalary(bo.getSalary());
			dto.setDeptNo(bo.getDeptNo());
			listDTO.add(dto);
		}
		return listDTO;
	}//method
}//class
