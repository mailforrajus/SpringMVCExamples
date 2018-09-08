package com.nt.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO implements Serializable {
	private int sno;
	private int empNo;
	private String ename;
	private String desg;
	private int salary;
	private int deptNo;
	
		

}
