package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.StudentCounsellingInfoDTO;
import com.nt.service.OnlineCounsellingService;

public class SimpleJdbcInsertTest1 {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		OnlineCounsellingService  service=null;
		StudentCounsellingInfoDTO dto=null,dto1=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service obj
		service=ctx.getBean("counsellingService",OnlineCounsellingService.class);
		dto=new StudentCounsellingInfoDTO();
		dto.setHno(1003);
		dto.setStudName("raja");
		dto.setAddress("hyd");
		dto.setBranch("CS");
		dto.setCollege("nit");
		dto.setRank(200);
		
		dto1=new StudentCounsellingInfoDTO();
		dto1.setHno(1002);
		dto1.setStudName("rajesh");
		dto1.setAddress("delhi");
		dto1.setBranch("IT");
		dto1.setCollege("nit");
		dto1.setRank(200);
		
		StudentThread t1=new StudentThread(service,dto);
		StudentThread t2=new StudentThread(service,dto1);
		Thread th1=new Thread(t1);
		Thread th2=new Thread(t2);
		th1.setPriority(6);
		
		th1.start();
		th2.start();
		
		
		try{
		Thread.sleep(80000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}
	
	

}
