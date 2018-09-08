package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeMgmtService {
	public int register(EmployeeDTO dto);
	public List<EmployeeDTO> fetchAllEmps();
	public EmployeeDTO  fetchEmpByEid(int eid);
	public  List<EmployeeDTO> fetchEmpsByEmail(String email);
	public  List<EmployeeDTO> fetchEmpsByEidRange(int start,int end);
	public String  addBonusToEmp(int eid,int bonus);

}
