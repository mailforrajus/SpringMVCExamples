package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.dto.EmployeeDTO;
import com.nt.service.ListEmployeeService;

@Controller
public class ListEmployeesController  {
	@Autowired
	private  ListEmployeeService  service;
	

@RequestMapping("/list_emps.htm")
	public String handle(Map<String,Object> map) {
		
		List<EmployeeDTO> listDTO=null;
		ModelAndView mav=null;
		//use SErvice
		listDTO=service.getAllEmployees();
		//create and return MAV object
		map.put("listEmps",listDTO);
		return "emps_report";
	}

}
