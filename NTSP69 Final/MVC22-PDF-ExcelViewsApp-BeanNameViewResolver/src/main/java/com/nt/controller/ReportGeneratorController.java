package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.StudentDTO;

public class ReportGeneratorController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
	   List<StudentDTO> listDTO=null;
	   StudentDTO dto1=null,dto2=null,dto3=null;
	   //prepare List of Students
	   dto1=new StudentDTO();
	   dto1.setSno(101); dto1.setSname("raja"); dto1.setSadd("hyd"); dto1.setAvg(90.4f);
	   dto2=new StudentDTO();
	   dto2.setSno(102); dto2.setSname("rani"); dto2.setSadd("hyd"); dto2.setAvg(91.4f);
	   dto3=new StudentDTO();
	   dto3.setSno(103); dto3.setSname("ramesh"); dto3.setSadd("vizag"); dto3.setAvg(94.4f);
	   //add List Collection
	   listDTO=new ArrayList();
	   listDTO.add(dto1); listDTO.add(dto2);listDTO.add(dto3);
	   if(req.getParameter("type").equalsIgnoreCase("pdf")){
		   return new ModelAndView("studPdfReport","listStuds",listDTO);
	   }
	   else{
		   return new ModelAndView("studExcelReport","listStuds",listDTO);
	   }
	}//method
}//class
