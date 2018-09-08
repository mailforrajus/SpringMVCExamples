package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface EmployeeDAO {
	public  EmployeeBO  getEmployeeDetailsByNo(int no);
	public List<EmployeeBO> getEmployeeDetailsByDesg(String desg);
	

}
