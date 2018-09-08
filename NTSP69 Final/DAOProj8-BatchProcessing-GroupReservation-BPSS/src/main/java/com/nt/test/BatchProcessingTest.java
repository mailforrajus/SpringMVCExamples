package com.nt.test;


import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.PassengerController;
import com.nt.vo.PassengerDetailsVO;

public class BatchProcessingTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		PassengerController controller=null;
		Scanner sc=null;
		PassengerDetailsVO vo=null;
		List<PassengerDetailsVO> listVO=null;
		int count=0;
		String result=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		controller=ctx.getBean("pController",PassengerController.class);
		//read values
		try{
			//read inputs
			sc=new Scanner(System.in);
			System.out.println("Enter PAssegener' count::");
			count=sc.nextInt();
			listVO=new ArrayList();
			for(int i=1;i<=count;++i){
				vo=new PassengerDetailsVO();
				System.out.println("Enter Passenger "+i+"details");
				System.out.println("Enter name:::");
				vo.setName(sc.next());
				System.out.println("Enter Source Place:::");
				vo.setSourcePlace(sc.next());
				System.out.println("Enter Dest Place:::");
				vo.setDestPlace(sc.next());
				System.out.println("Enter Fare :::");
				vo.setFare(sc.next());
				listVO.add(vo);
			}//for
			//invoke method
			result=controller.processForGroupReservation(listVO);
			System.out.println(result);
		}//try
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Internal problem");
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
