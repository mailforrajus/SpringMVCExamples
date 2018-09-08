package com.nt.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OExamResult {
	private int id;
	private int sem;
	private Date  dob;
	private double percentage;
	
	
	
}
