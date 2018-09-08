package com.nt.service;

import com.nt.dao.BankDAO;

public class BankServiceImpl implements BankService {
	private BankDAO dao;

	public BankServiceImpl(BankDAO dao) {
			this.dao = dao;
	}

	@Override
	public String withdraw(int acno, int amt) {
		int count=0;
	//use DAO
		count=dao.deductAmountFromAccount(acno, amt);
		if(count==0)
		  return  "Amount ::"+amt+" is not withdrawn from account no::"+acno;
		else
			return  "Amount ::"+amt+" is  withdrawn from account no::"+acno;
	}

	@Override
	public String deposite(int acno, int amt) {
		int count=0;
		//use DAO
			count=dao.addAmountToAccount(acno, amt);
			if(count==0)
			  return  "Amount ::"+amt+" is not deposisted to account no::"+acno;
			else
				return  "Amount ::"+amt+" is  deposisted to account no::"+acno;
	}

}
