package com.nt.beans;

import org.springframework.stereotype.Service;

//@Service("bankService")
public  class BankService {
	  public  float calcIntrAmt(float pAmt,float time){
		  System.out.println("BankService:calcIntrAmt(-,-)");
          return pAmt*time*2.0f/100;
      }
}
