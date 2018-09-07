package com.nt.service;

import com.nt.dao.BankDAO;

public class BankServiceImpl implements BankService {
	
	private BankDAO dao;

	public BankServiceImpl(BankDAO dao) {
		this.dao = dao;
	}

	@Override
	public String transferMoney(int srcAcno, int destAcno, int amt) {
	     int result1=0,result2=0;
	     //use DAO
	     result1=dao.withdraw(srcAcno, amt);
	     result2=dao.deposite(destAcno, amt);
	     if(result1==0 || result2==0)
	    	 throw new RuntimeException("TransferMoney Failed");
	     else
	    	 return "Money Transfered";
	}

}
