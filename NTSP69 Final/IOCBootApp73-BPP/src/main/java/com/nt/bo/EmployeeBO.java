package com.nt.bo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("empBO")
@Scope("prototype")
public class EmployeeBO extends BaseBO {
	private String desg;

	public EmployeeBO() {
		System.out.println("EmployeeBO:0-param constructor");
	}
	
	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}


}
