package com.nt.service;

import com.nt.bo.UserBO;
import com.nt.dao.AuthenticateDAO;

public class AuthenticationManager {
	private  AuthenticateDAO dao;
	private  ThreadLocal<UserBO> threadLocal=new ThreadLocal();
	
	public AuthenticationManager(AuthenticateDAO dao) {
		this.dao = dao;
	}

	
	
	public void signIn(String user,String pwd){
		UserBO bo=null;
		//store into  UserBO obj
		bo=new UserBO();
		bo.setUname(user);
		bo.setPwd(pwd);
		//add to ThreadLocal
		threadLocal.set(bo);
	}
	
	
	public  void signOut(){
		threadLocal.remove();
	}
	
	public  boolean isAuthenticated(){
		UserBO  bo=null;
		int count=0;
		bo=threadLocal.get();
		if(bo!=null){
			count=dao.validate(bo);
			if(count==0)
				return false;
			else
				return true;
		}
		else{
		return false;
		}
	}//method
}//class
