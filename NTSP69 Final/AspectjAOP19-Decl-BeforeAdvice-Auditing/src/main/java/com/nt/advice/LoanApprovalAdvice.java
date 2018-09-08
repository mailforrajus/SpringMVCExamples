package com.nt.advice;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.springframework.aop.MethodBeforeAdvice;

public class LoanApprovalAdvice {

	
	/*public void  audit(JoinPoint jp,int loanId,String manager,int amount) throws Throwable{
		String auditLogMsg=null;
		FileWriter writer=null;
		System.out.println("target method name::"+jp.getSignature());
		System.out.println("Target method args::"+Arrays.toString(jp.getArgs()));
		System.out.println("Target class name::"+jp.getTarget().getClass());
	
		  if(amount<=0)
			  amount=amount*-1;
		
		//Generate audit Log message
		auditLogMsg=loanId+":Loan Id Loan has come for approval with request amount of:"+ amount+" to the manager"+manager+" on Date:: "+new Date()+"\n";
		//write message Audit Log file
		writer =new  FileWriter("E:/auditLog.txt",true);
		writer.write(auditLogMsg);
		writer.flush();
		writer.close();
	}//method
*/
/*	public void  audit(JoinPoint jp) throws Throwable{
		String auditLogMsg=null;
		FileWriter writer=null;
		Object args[]=null;
		System.out.println("target method name::"+jp.getSignature());
		System.out.println("Target method args::"+Arrays.toString(jp.getArgs()));
		System.out.println("Target class name::"+jp.getTarget().getClass());
	    //get taget method args
		args=jp.getArgs();
		if(((Integer)args[2])<0)
			args[2]=((Integer)args[2])*-1;
		
		
		//Generate audit Log message
		auditLogMsg=args[0]+":Loan Id Loan has come for approval with request amount of:"+args[2]+" to the manager"+args[1]+" on Date:: "+new Date()+"\n";
		//write message Audit Log file
		writer =new  FileWriter("E:/auditLog.txt",true);
		writer.write(auditLogMsg);
		writer.flush();
		writer.close();
	}//method
*/	
	
	public void  audit(int loanId,String manager,int amount) throws Throwable{
		String auditLogMsg=null;
		FileWriter writer=null;
		Object args[]=null;
		//Generate audit Log message
		auditLogMsg=loanId+":Loan Id Loan has come for approval with request amount of:"+amount+" to the manager  "+manager+" on Date:: "+new Date()+"\n";
		//write message Audit Log file
		writer =new  FileWriter("E:/auditLog.txt",true);
		writer.write(auditLogMsg);
		writer.flush();
		writer.close();
	}//method


}//class
