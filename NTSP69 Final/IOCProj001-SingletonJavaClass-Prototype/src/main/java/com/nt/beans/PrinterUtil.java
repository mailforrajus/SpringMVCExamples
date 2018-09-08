package com.nt.beans;

public class PrinterUtil {
	private static PrinterUtil instance;
	
	private PrinterUtil(){
		System.out.println("PrinterUtil:0-param constructor");
	}
	
	public  static PrinterUtil getInstance(){
		if(instance==null)
			instance=new PrinterUtil();
		return instance;
			
	}

	@Override
	public String toString() {
		return "PrinterUtil [toString()";
	}
	
	
	

}
