package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.model.IExamResult;
import com.nt.model.OExamResult;

@Component("itemProcessor")
public class ExamResultItemProcessor implements ItemProcessor<IExamResult, OExamResult> {

	@Override
	public OExamResult process(IExamResult item) throws Exception {
		OExamResult oResult=null;
		if(item.getPercentage()>=94) {
		     oResult=new OExamResult();
		     oResult.setId(item.getId());
		     oResult.setDob(java.sql.Date.valueOf(item.getDob()));
		     oResult.setSem(item.getSem());
		     return oResult;
		}
		else
			return null;
	}

}
