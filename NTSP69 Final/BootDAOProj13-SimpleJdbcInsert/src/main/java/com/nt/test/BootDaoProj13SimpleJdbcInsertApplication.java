package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataAccessException;

import com.nt.config.AppConfig;
import com.nt.dto.StudentCounsellingInfoDTO;
import com.nt.service.OnlineCounsellingService;

@SpringBootApplication
@Import(value=AppConfig.class)
public class BootDaoProj13SimpleJdbcInsertApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		OnlineCounsellingService service=null;
		StudentCounsellingInfoDTO dto=null;
		ctx=SpringApplication.run(BootDaoProj13SimpleJdbcInsertApplication.class, args);
		//get Bean
		service=ctx.getBean("counsellingService",OnlineCounsellingService.class);
		//invoke method
		//prepare DTO
		dto=new StudentCounsellingInfoDTO();
		dto.setHno(44401); dto.setStudName("rajesh");
		dto.setAddress("hyd"); dto.setBranch("ECE");
		dto.setRank(345); dto.setCollege("CBIET");
		try{
		  System.out.println("result==>"+service.register(dto));	
		}
		catch(DataAccessException dae){
			dae.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//close contianer
		((ConfigurableApplicationContext) ctx).close();
	}
}
