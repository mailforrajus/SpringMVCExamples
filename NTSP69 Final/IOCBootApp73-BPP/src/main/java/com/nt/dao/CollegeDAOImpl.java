package com.nt.dao;

import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
import com.nt.bo.StudentBO;

@Repository("clgDAO")
public class CollegeDAOImpl implements CollegeDAO {

	public CollegeDAOImpl() {
		System.out.println("CollegeDAOImpl:0-param constructor");
	}
	
	@Override
	public int insertData(StudentBO bo) {
		System.out.println("inserting Student Info");
		System.out.println("Data is "+bo.getId()+" "+bo.getName()+" "+bo.getCourse()+" "+bo.getDoj());
		return 1;
	}

	@Override
	public int insertData(EmployeeBO bo) {
		System.out.println("inserting Employee Info");
		System.out.println("Data is "+bo.getId()+" "+bo.getName()+" "+bo.getDesg()+" "+bo.getDoj());
		return 1;
	}

}
