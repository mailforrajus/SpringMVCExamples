package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;

public class NamedParmaeterJdbcTemplateTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeService service=null;
		List<EmployeeDTO> listDTO=null;
		EmployeeDTO dto1=null;
		//crete IOC Container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("empService",EmployeeService.class);
		//invoke methods
		try{
			System.out.println("Emps Count int the range 7000 to 7900:::"+service.fetchEmpsCountByEnoRange(7000, 7900));
	      System.out.println("--------------------------------------");
	      System.out.println("CLERK,MANAGER,SALESMAN Desg Emp Details::");
			listDTO=service.fetchEmpsByDesgs("CLERK","MANAGER","SALESMAN");
			listDTO.forEach(dto->{
				System.out.println(dto.getEno()+" "+dto.getEname()+"   "+dto.getDesg()+" "+dto.getSalary());
			});
			System.out.println("-------------------------------------");
			//create DTO obj
			dto1=new EmployeeDTO();
			dto1.setEno(9091); dto1.setEname("jani");
			dto1.setDesg("CLERK"); dto1.setSalary(8000);
			System.out.println(service.register(dto1));
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class