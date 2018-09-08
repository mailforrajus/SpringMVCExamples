package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.UserBO;
import com.nt.dao.AuthenticateDAO;

@Service("authManager")
public class AuthenticationManager {
	@Autowired
	private  AuthenticateDAO dao;
	private  ThreadLocal<UserBO> threadLocal=new ThreadLocal();
	
	

	
	
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
