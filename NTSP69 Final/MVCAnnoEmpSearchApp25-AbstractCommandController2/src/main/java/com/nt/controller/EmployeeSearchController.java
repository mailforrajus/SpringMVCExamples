package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.command.EmployeeSearchCommand;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.EmployeeResultDTO;
import com.nt.service.EmployeeSearchService;

@Controller
public class EmployeeSearchController {
	@Autowired
	private  EmployeeSearchService  service;

	

	@RequestMapping("/search.htm")
	public String handle(Map<String,Object> map,
			                              @ModelAttribute EmployeeSearchCommand cmd){
		 EmployeeDTO dto=null;
		 List<EmployeeResultDTO>  listRDTO=null;
		// Convert Command obj to DTO
		 dto=new EmployeeDTO();
		 BeanUtils.copyProperties(cmd,dto);
		 //use Service
		 listRDTO=service.findEmployees(dto);
		 System.out.println(listRDTO);
		 //put  result listRDTO in Model attribute
		 map.put("listEmps",listRDTO);
		 //create and return MAV
		 return "list_emps";
	}//method
}//class
