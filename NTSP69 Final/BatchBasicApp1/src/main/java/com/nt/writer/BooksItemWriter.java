package com.nt.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class BooksItemWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println("BooksItemWriter:write(-)");
	    System.out.println(items);
	}

}
