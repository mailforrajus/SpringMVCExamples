package com.nt.test;

import com.nt.dto.StudentCounsellingInfoDTO;
import com.nt.service.OnlineCounsellingService;

public class StudentThread implements Runnable {
	private OnlineCounsellingService service;
	private StudentCounsellingInfoDTO dto;
	public StudentThread(OnlineCounsellingService service,StudentCounsellingInfoDTO dto) {
		this.service=service;
		this.dto=dto;
	}

	@Override
	public void run() {
		System.out.println("Thread name:::"+Thread.currentThread().getName());
		try{
		if(Thread.currentThread().getName().equalsIgnoreCase("Thread-1")){
			System.out.println("Thread-1 is in sleep mode...");
		}
		
		//invoke b.method
		System.out.println(service.register(dto));
		}
		catch(Exception e){
			 e.printStackTrace();
		}
	}//run
}//class
