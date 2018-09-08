package com.nt.service;

public interface IBankService {
	public float calcSimpleIntrAmount(float pAmt,float rate,float time);
	public float calcCompoundIntrAmount(float pAmt,float rate,float time);

}
