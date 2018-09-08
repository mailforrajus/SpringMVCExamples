package com.nt.test1;


import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.controller.EmployeeController;
import com.nt.vo.EmployeeVO;

@SpringBootApplication
@Import(value=AppConfig.class)
public class IocBootApp72LayeredAppApplication {

	public static void main(String[] args) {
		
		Scanner sc=null;
		String eno=null,ename=null,addrs=null,company=null,basicSalary=null;
		EmployeeVO vo=null;
		ApplicationContext ctx=null;
		String result=null;
		EmployeeController controller=null;
		
		//read inputs
		sc=new Scanner(System.in);
		System.out.println("Enter EmployeeID::");
		eno=sc.next();
		System.out.println("enter Employee name::");
		ename=sc.next();
		System.out.println("enter Employee Addrs::");
		addrs=sc.next();
		System.out.println("enter Employee Company::");
		company=sc.next();
		System.out.println("enter Employee BasicSalary::");
		basicSalary=sc.next();
		//store Inputs into EmpoyeeVO class object
		vo=new EmployeeVO();
		vo.setEno(eno); vo.setEname(ename); vo.setAddress(addrs);
		vo.setCompany(company); vo.setBasicSalary(basicSalary);
		//create IOC container
		ctx=SpringApplication.run(IocBootApp72LayeredAppApplication.class, args);
		//get Controller class obj
		controller=ctx.getBean("empController",EmployeeController.class);
		try{
		//invoke method
			result=controller.processEmployee(vo);
			System.out.println("Client::"+result);
		}
		catch(Exception e){
			System.out.println("Internal Problem..Try Again ???-->"+e.getMessage());
		}
		//close contianer
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
