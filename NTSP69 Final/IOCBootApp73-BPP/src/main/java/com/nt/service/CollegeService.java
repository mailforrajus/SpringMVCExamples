package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.bo.StudentBO;
import com.nt.dao.CollegeDAO;

@Service("clgService")
public abstract class CollegeService {
	@Autowired
	private CollegeDAO dao;

	public CollegeService() {
		System.out.println("CollegeService:0-param constructor");
	}
	
	public CollegeService(CollegeDAO dao) {
		this.dao = dao;
	}
	
	@Lookup
	public abstract StudentBO getStudentBO();
	@Lookup
	public abstract EmployeeBO getEmployeeBO();
	
	public  String registerStudent(int sno,String sname,String course){
		
		StudentBO stBO=null;
		int count=0;
		//get StudentBO obj
		stBO=getStudentBO();
		stBO.setId(sno); stBO.setName(sname); stBO.setCourse(course);
		//use dAO
		count=dao.insertData(stBO);
		if(count==1)
			  return "Student Registration successful";
		else
			  return "Student Registration failed";
	}
	 
	public  String registerEmployee(int eno,String ename,String desg){
		EmployeeBO empBO=null;
		int count=0;
		//get StudentBO obj
		empBO=getEmployeeBO();
		empBO.setId(eno); empBO.setName(ename); empBO.setDesg(desg);
		//use dAO
		count=dao.insertData(empBO);
		if(count==1)
			  return "Emp Registration successful";
		else
			  return "Emp Registration failed";
	}
	
	
	
	

}
