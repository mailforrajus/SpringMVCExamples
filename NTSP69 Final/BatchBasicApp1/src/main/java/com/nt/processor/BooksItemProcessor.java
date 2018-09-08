package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;

public class BooksItemProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("BooksItemProcessor.process()");
		if(item.equalsIgnoreCase("CRJ"))
			return item+"...by PN & HS";
		else if(item.equalsIgnoreCase("TJ"))
			return item+"... by BE";
		else if(item.equalsIgnoreCase("EJ"))
			return item+".. by JB";
		else
			 return item+".. by Nagesh";
	}

}
