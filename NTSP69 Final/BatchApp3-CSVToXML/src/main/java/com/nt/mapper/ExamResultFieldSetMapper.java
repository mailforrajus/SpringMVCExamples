package com.nt.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;
import com.nt.model.ExamResult;


public class ExamResultFieldSetMapper implements FieldSetMapper<ExamResult>{

	public ExamResult mapFieldSet(FieldSet fieldSet) throws BindException {
		ExamResult result =null;
         result=new ExamResult();
         
		result.setId(fieldSet.readInt(0));
		result.setDob(new java.sql.Date(fieldSet.readDate(1).getTime()));
		result.setPercentage(fieldSet.readDouble(2));
				result.setSem(fieldSet.readInt(3));
		return result;
		
	}

}
