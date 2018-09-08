package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.dto.StudentDTO;

public class StudentXlsView extends AbstractXlsView {

	@Override
	public void buildExcelDocument(Map<String, Object> map, Workbook book, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<StudentDTO> listDTO=null;
		 Sheet sheet=null;
		 Row row=null;
		 int i=0;
		 int j=0;
		//get Model Attribute
		listDTO=(List<StudentDTO>) map.get("listStuds");
		//create Sheet
		sheet=book.createSheet("student Report");
		for(StudentDTO dto:listDTO){
			j=0;
			row=sheet.createRow(i);
			row.createCell(j).setCellValue(String.valueOf(dto.getSno()));
			row.createCell(j+1).setCellValue(dto.getSname());
			row.createCell(j+2).setCellValue(dto.getSadd());
			row.createCell(j+3).setCellValue(String.valueOf(dto.getAvg()));
			i++;
		}
	}//method
}//class
