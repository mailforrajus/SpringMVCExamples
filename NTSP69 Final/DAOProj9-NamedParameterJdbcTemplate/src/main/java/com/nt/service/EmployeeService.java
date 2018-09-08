package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeService {
	public  int fetchEmpsCountByEnoRange(int start,int end);
	public  List<EmployeeDTO> fetchEmpsByDesgs(String desg1,String desg2,String desg3);
	public  String register(EmployeeDTO dto);

}
