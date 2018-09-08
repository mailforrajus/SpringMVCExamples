package com.nt.bo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("stBO")
@Scope("prototype")
public class StudentBO extends BaseBO {
	private String course;

	public StudentBO() {
		System.out.println("StudentBO:0-param constructor");
	}
	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
