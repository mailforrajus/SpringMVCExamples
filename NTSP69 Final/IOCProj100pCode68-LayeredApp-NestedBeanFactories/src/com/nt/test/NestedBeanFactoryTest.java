package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.BusinessConfig;
import com.nt.config.PresentationConfig;
import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class NestedBeanFactoryTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext parentCtx=null,childCtx=null;
		MainController controller=null;
		List<EmployeeVO> listVO=null;
		//create IOC Container(parent )
		parentCtx=new AnnotationConfigApplicationContext(BusinessConfig.class);
		//create IOC Container(child )
		childCtx=new AnnotationConfigApplicationContext(PresentationConfig.class);
        childCtx.setParent(parentCtx);
		//get controller bean object
		controller=childCtx.getBean("controller",MainController.class);
		try{
		//invoke b.methods..
		listVO=controller.getEmpsByDesgs(new String[]{"CLERK","MANAGER","SALESMAN"});
		//display listVO
		for(EmployeeVO vo:listVO){
			System.out.println(vo.getSno()+" "+vo.getEno()+" "+vo.getEname()+" "+vo.getDesg()+" "+vo.getSalary());
		}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Intenal Problem---->"+e.getMessage());
		}

	}//main
}//class
