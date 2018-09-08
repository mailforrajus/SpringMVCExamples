package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeService {
	public  EmployeeDTO  fetchEmployeeByNo(int empNo);
	public  List<EmployeeDTO> fetchEmployeeByDesg(String desg);

}
