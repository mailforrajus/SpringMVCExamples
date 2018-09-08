package com.nt.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExamResult {
	private int id;
	private int sem;
	private Date dob;
	private double percentage;
	
	
	
}
