package com.nt.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
	public  int  fetchEmpsCount();
	public  Map<String,Object> fetchEmpById(int empNo);
	public List<Map<String,Object>> fetchEmpByDesgs(String desg1,String desg2,String desg3);
    public String fetchEnameByNo(int empNo);
    public String registerEmp(int no,String name,String desg,int salary);
    public  String hikeSalary(int no,float hikePercentage);
    public int fetchSalary(int empNo);
    public String fireEmp(int empNo);
}
