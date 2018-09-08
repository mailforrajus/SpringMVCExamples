package com.nt.service;



import com.nt.dao.AuthenticateDAO;


public class AuthenticateServiceImpl implements AuthenticateService {
   	private  AuthenticateDAO dao;
	
   	public AuthenticateServiceImpl(AuthenticateDAO dao) {
			this.dao = dao;
		}

	@Override
	public String login(String user, String pwd) {
		String result=null;
		//use DAO
		result=dao.authenticate(user, pwd);
		return result;
	}
    
	
}//class
