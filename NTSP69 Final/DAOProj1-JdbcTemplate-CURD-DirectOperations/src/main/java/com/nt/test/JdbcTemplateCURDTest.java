package com.nt.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.EmployeeService;

public class JdbcTemplateCURDTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeService service=null;
		List<Map<String,Object>> list=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("empService",EmployeeService.class);
		//invoke method
		try{
		System.out.println("Emps Count::"+service.fetchEmpsCount());
		System.out.println("----------------------");
		System.out.println("7499 Emp Details:::"+service.fetchEmpById(7499));
		System.out.println("------------------------");
		System.out.println("Emp Details whose desgs are CLERK,MANAGER,SALESMAN");
		list=service.fetchEmpByDesgs("CLERK","MANAGER", "SALESMAN");
		System.out.println("--------------------------------");
		list.forEach(map->{
			System.out.println(map);
		});
		System.out.println("-----------------------------");
		System.out.println("7499 Emp name ::"+service.fetchEnameByNo(7499));
	    System.out.println("-----------------------------");	
	 //   System.out.println("Emp Registered?"+service.registerEmp(2301, "raja","MANAGER",9000));
	    System.out.println("7499 Salary: "+service.fetchSalary(7499));
	    System.out.println("Salary hiked::?"+service.hikeSalary(7499,12.5f));
	    System.out.println("7499 salary:"+service.fetchSalary(7499) );
	    System.out.println(service.fireEmp(2301));
		}
		catch(DataAccessException dae){
			System.out.println("Internal problem -->"+dae.getMessage());
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
