package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

@SpringBootApplication
@Import(value=AppConfig.class)
public class SpringDataBootApp1Application {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		EmployeeDTO dto=null;
		ctx=SpringApplication.run(SpringDataBootApp1Application.class, args);
		//Service calss obj
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		//create DTO class obj
		dto=new EmployeeDTO();
		dto.setEname("raja"); dto.setEmail("raja@rani.com"); dto.setSalary(9000);
		//invoke method
		/*try {
			System.out.println("Employee registred with::"+service.register(dto));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		System.out.println("..................");
		try {
			System.out.println("All employees::"+service.fetchAllEmps());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("......................");
		
		try {
			System.out.println("1 Emp Details::"+service.fetchEmpByEid(1));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("..........................");
		
		try {
			System.out.println("All employees by email::"+service.fetchEmpsByEmail("raja@rani.com"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
System.out.println("..........................");
		
		try {
			System.out.println("All employees by EID range::"+service.fetchEmpsByEidRange(1,6000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
System.out.println("..........................");
		
		try {
			System.out.println(service.addBonusToEmp(1,2000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		
		
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main
}//class
