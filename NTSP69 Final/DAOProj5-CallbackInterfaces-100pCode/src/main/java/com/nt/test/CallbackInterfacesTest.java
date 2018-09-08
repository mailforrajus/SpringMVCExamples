package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.config.AppConfig;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;

public class CallbackInterfacesTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeService service=null;
		EmployeeDTO dto=null;
		List<EmployeeDTO> listDTO=null;
		//create IOc container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Bean
		service=ctx.getBean("empService",EmployeeService.class);
		//invoke method
		try{
			dto=service.fetchEmployeeByNo(7499);
			System.out.println(dto.getEid()+" "+dto.getEname()+" "+dto.getDesg()+" "+dto.getSalary()+" "+dto.getDeptNo());
			System.out.println("------------------------------------------------------");
			listDTO=service.fetchEmployeeByDesg("CLERK");
			listDTO.forEach(dto1->{
				System.out.println(dto1.getEid()+" "+dto1.getEname()+" "+dto1.getDesg()+" "+dto1.getSalary()+" "+dto1.getDeptNo());
			});
		}//try
		catch(DataAccessException dae){
			dae.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
