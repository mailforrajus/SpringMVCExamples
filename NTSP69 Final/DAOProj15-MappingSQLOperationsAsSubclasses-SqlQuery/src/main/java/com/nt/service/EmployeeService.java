package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeService {
	public  List<EmployeeDTO> fetchEmpsByRange(int start,int end);
	public EmployeeDTO  fetchEmpByEno(int no);
	public String updateEmpSalaryByDesg(String desg);

}
