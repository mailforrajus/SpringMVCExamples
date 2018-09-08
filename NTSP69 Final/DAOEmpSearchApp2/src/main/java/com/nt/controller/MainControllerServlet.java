package com.nt.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.EmployeeService;

public class MainControllerServlet extends HttpServlet {
	ApplicationContext ctx;
	EmployeeService service;
	
	@Override
	public void init() throws ServletException {
	  //create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		service=ctx.getBean("empService",EmployeeService.class);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String desgs[]=null;
		List<Map<String,Object>> list=null;
		RequestDispatcher rd=null;
		//read form data
		desgs=req.getParameterValues("desgs");
		try{
		//use service
		list=service.fetchEmpDetialsByDesgs(desgs);
		}//try
		catch(Exception e){
			rd=req.getRequestDispatcher("/error.jsp");
			rd.forward(req,res);
			return;
		}
		//keep result in request scope
		req.setAttribute("empList",list);
		//forward the request result.jsp
		rd=req.getRequestDispatcher("/result.jsp");
		rd.forward(req, res);
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}
}//class
