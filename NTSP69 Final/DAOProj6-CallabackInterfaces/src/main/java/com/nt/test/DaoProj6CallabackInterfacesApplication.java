package com.nt.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataAccessException;

import com.nt.config.PersistenceConfig;
import com.nt.config.ServiceConfig;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,JdbcTemplateAutoConfiguration.class})
@Import(value={ServiceConfig.class,PersistenceConfig.class})
@SpringBootApplication
public class DaoProj6CallabackInterfacesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeService service=null;
		EmployeeDTO dto=null;
		List<EmployeeDTO> listDTO=null;
		//get IOC contianer
		ctx=SpringApplication.run(DaoProj6CallabackInterfacesApplication.class, args);
		//get Bean
		service=ctx.getBean("empService",EmployeeService.class);
		try{
			dto=service.fetchEmployeeByNo(7499);
			System.out.println(dto.getDeptNo()+" "+dto.getEid()+" "+dto.getEname()+" "+dto.getDesg()+" "+dto.getSalary());
			System.out.println("----------------------------");
			listDTO=service.fetchEmployeeByDesg("CLERK");
			listDTO.forEach(dto1->{
				System.out.println(dto1.getDeptNo()+" "+dto1.getEid()+" "+dto1.getEname()+" "+dto1.getDesg()+" "+dto1.getSalary());
			});
		}//try
		catch(DataAccessException dae){
			dae.printStackTrace();
		}
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main
}//class
