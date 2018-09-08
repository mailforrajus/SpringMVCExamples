package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;

public class MappSQLOperationsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeService service=null;
		List<EmployeeDTO> listDTO=null;
		EmployeeDTO dto1=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("empService",EmployeeService.class);
		//invoke method
		try{
		/*	listDTO=service.fetchEmpsByRange(7300,7500);
			listDTO.forEach(dto->{
				System.out.println(dto.getEno()+" "+dto.getEname()+" "+dto.getJob()+" "+dto.getSalary());
			});
			System.out.println(".....................................");
			dto1=service.fetchEmpByEno(7499);
			System.out.println(dto1.getEno()+"  "+dto1.getEname()+" "+dto1.getJob()+" "+dto1.getSalary());*/
			System.out.println("................................................");
			
			System.out.println(service.updateEmpSalaryByDesg("CLERK"));
			
		}//try
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
