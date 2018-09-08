package com.nt.service;

import org.springframework.aop.IntroductionAdvisor;

public class AirthmeticOperationsService implements IAirthmeticService {
	
	public  int  sum(int x,int y){
		return x+y;
	}
	public int sub(int x,int y){
		return x-y;
	}
	public int mul(int x,int y){
		return x*y;
	}
	public float div(int x,int y){
		return (float)x/y;
	}

}
