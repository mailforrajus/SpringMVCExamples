package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService {
  private EmployeeDAO dao;
  
  public EmployeeServiceImpl(EmployeeDAO dao) {
	this.dao=dao;
}
  
	@Override
	public int fetchEmpsCount() {
		int count=0;
	 //use service
		count=dao.getEmpsRecordCount();
		return count;
	}

	@Override
	public Map<String, Object> fetchEmpById(int empNo) {
		Map<String,Object> map=null;
		map=dao.getEmpRecordById(empNo);
		return map;
	}

	@Override
	public List<Map<String, Object>> fetchEmpByDesgs(String desg1, String desg2, String desg3) {
		List<Map<String,Object>> list=null;
		list=dao.getEmpsByDesgs(desg1, desg2, desg3);
		return list;
	}
	
	@Override
		public String fetchEnameByNo(int empNo) {
		   String name=null;
		   name=dao.getEmpNameByNo(empNo);
			return name;
		}
	
	@Override
		public String registerEmp(int no, String name, String desg, int salary) {
          int count=0;
		//use DAO
           count=dao.insert(no, name, desg, salary);
			if(count==0)
				return "Emp Registration failed";
			else
				return "Emp Registration succeded";
		}
	
	@Override
		public String hikeSalary(int no, float hikePercentage) {
		  int salary=0;
		  int newSalary=0;
		  int count=0;
		    //get Existing Salary
		  salary=dao.getSalary(no);
		  newSalary=(int) (salary+(salary*hikePercentage/100.0f));
		  //use daO
		  count=dao.update(no, newSalary);
		  if(count==0)
			  return "salary not hiked";
		  else
			  return "salary hiked and new salary is::"+newSalary;
		}
	
	@Override
		public int fetchSalary(int empNo) {
			//use DAO
		 int salary=dao.getSalary(empNo);
			return salary;
		}
	
	@Override
		public String fireEmp(int empNo) {
		  int count=0;
			//use DAO
		  count=dao.delete(empNo);
		   if(count==0)
			   return "employee not found";
		   else
			   return "employee fired";
		}

}
