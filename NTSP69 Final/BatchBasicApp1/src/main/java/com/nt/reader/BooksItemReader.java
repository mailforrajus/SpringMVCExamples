package com.nt.reader;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class BooksItemReader implements ItemReader<String> {
    private List<String> booksList;
    private int  count=0;
    
	public void setBooksList(List<String> booksList) {
		this.booksList = booksList;
	}

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
      System.out.println("BooksItemReader.read()");
		if(count<booksList.size()) {
            return booksList.get(count++);
		}
		else {
			return null;
		}
	}

}
