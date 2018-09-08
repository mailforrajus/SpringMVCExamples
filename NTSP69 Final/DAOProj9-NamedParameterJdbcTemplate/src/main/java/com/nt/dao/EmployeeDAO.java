package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface EmployeeDAO {
	public int getEmpsCountByEnoRange(int start,int end);
	public List<EmployeeBO>  getEmpsByDesgs(String desg1,String desg2,String desg3);
    public int insert(EmployeeBO bo);
}
