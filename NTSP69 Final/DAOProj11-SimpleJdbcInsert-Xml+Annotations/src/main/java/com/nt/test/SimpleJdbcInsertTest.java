package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.StudentCounsellingInfoDTO;
import com.nt.service.OnlineCounsellingService;

public class SimpleJdbcInsertTest {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		OnlineCounsellingService  service=null;
		StudentCounsellingInfoDTO dto=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("counsellingService",OnlineCounsellingService.class);
		//prepare DTO class obj
		dto=new StudentCounsellingInfoDTO();
		dto.setHno(1001);
		dto.setStudName("raja");
		dto.setAddress("hyd");
		dto.setBranch("CS");
		dto.setCollege("nit");
		dto.setRank(200);
		//use service
		try{
			System.out.println(service.register(dto));
		}
		catch(DataAccessException dae){
			dae.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}
	
	

}
