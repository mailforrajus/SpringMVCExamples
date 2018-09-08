package com.nt.service;

import java.util.Calendar;

public class BankService {
	
	public String approveLoan(int loanId,String manager,int amount){
		Calendar cal=null;
		int month=0;
		//get System Date and time
		cal=Calendar.getInstance();
		//get current month
		month=cal.get(Calendar.MONTH);
		System.out.println(month);
		if((month>=5 && month<=9) && amount<=100000){
			return  loanId +"Loan is approved with "+amount +"by manager::"+manager;
		}
		else{
			return loanId +"Loan is not approved with "+amount +"by manager::"+manager;
		}
	}//approveLoan
}//class
