package com.nt.dao;

public interface BankDAO {
	public int  addAmountToAccount(int acno,int amt);
	public int  deductAmountFromAccount(int acno,int amt);

}
