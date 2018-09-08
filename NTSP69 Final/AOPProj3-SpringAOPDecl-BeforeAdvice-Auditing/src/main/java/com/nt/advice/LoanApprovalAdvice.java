package com.nt.advice;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;

public class LoanApprovalAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String auditLogMsg=null;
		FileWriter writer=null;
		System.out.println("target method::"+method.getName());
		System.out.println("Target method args::"+Arrays.toString(args));
		System.out.println("Target class name::"+target.getClass());
		 //accessing target method arg value
		if(((Integer)args[2])<0){
			args[2]=((Integer)args[2])*-1;
		}
		//Generate audit Log message
		auditLogMsg=args[0]+":Loan Id Loan has come for approval with request amount:"+ args[2]+" to the manager"+args[1]+" on Date:: "+new Date()+"\n";
		//write message Audit Log file
		writer =new  FileWriter("E:/auditLog.txt",true);
		writer.write(auditLogMsg);
		writer.flush();
		writer.close();
	}//method
}//class
