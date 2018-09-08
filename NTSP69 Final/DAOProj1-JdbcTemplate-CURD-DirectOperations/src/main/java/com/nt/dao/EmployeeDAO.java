package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
	public  int  getEmpsRecordCount();
	public Map<String,Object>  getEmpRecordById(int empNo);
	public List<Map<String,Object>> getEmpsByDesgs(String desg1,String desg2,String desg3);
	public String  getEmpNameByNo(int empNo);
	public int  insert(int no,String name,String desg,int salary);
	public  int update(int empNo,int newSalary);
	public  int getSalary(int empNo);
	public int  delete(int empNo);

}
